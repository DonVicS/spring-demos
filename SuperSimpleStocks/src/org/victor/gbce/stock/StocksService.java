package org.victor.gbce.stock;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.victor.gbce.exceptions.StockNotFoundException;
import org.victor.gbce.trade.Trade;
import org.victor.gbce.trade.TradesService;
import org.victor.gbce.util.Constants;
import org.victor.gbce.util.StockType;

@Service
public class StocksService {

	private static final Logger log = LoggerFactory.getLogger(StocksService.class);

	@Autowired
	private TradesService tradesService;

	private Set<Stock> stocksData;

	public StocksService() {
		stocksData = new HashSet<>();
	}

	public Stock getOne(String stockSymbol) {
		Stock stock = stocksData.stream().filter(s -> s.getStockSymbol().equals(stockSymbol)).findFirst()
				.orElseThrow(StockNotFoundException::new);
		return recalculateStockValues(stock);
	}

	private Stock recalculateStockValues(Stock stock) {
		List<Trade> trades = getTradesByStockSymbol(stock);

		float stockPrice = calculateStockPrice(trades);
		float dividendYield = calculateDividendYield(stock, stockPrice);
		float p_e_ratio = calculatePriceEarningsRatio(stock, stockPrice);
		float geometricMean = calculateGeometricMean(trades);

		stock.setDividendYield(dividendYield);
		stock.setPriceEarningsRatio(p_e_ratio);
		stock.setGeometricMean(geometricMean);
		stock.setStockPrice(stockPrice);

		return stock;
	}

	private List<Trade> getTradesByStockSymbol(Stock stock) {
		LocalDateTime limit = LocalDateTime.now().minusMinutes(Constants.MINUTES_LIMIT_FOR_TRADES);
		return tradesService.get(t -> t.getStockSymbol().equals(stock.getStockSymbol()) && t.getTime().isAfter(limit));
	}

	private float calculateGeometricMean(List<Trade> trades) {
		float multTradePrice = trades.stream().mapToInt(Trade::getPrice).reduce(1, (a, b) -> a * b);
		return (float) Math.pow(multTradePrice, 1 / (float) trades.size());
	}

	private float calculatePriceEarningsRatio(Stock stock, float stockPrice) {
		return stock.getLastDividend() > 0 ? stockPrice / stock.getLastDividend() : 0;
	}

	private float calculateDividendYield(Stock stock, float stockPrice) {
		return stock.getType().equals(StockType.COMMON) ? stock.getLastDividend() / stockPrice
				: stock.getLastDividend() * stock.getParValue() / stockPrice * stock.getFixedDividend();
	}

	private float calculateStockPrice(List<Trade> trades) {
		float sumTradePrice = trades.stream().mapToInt(t -> t.getPrice() * t.getQuantityOfShares()).sum();
		float sumQuantities = trades.stream().mapToInt(Trade::getQuantityOfShares).sum();
		return sumTradePrice / sumQuantities;
	}

	public Set<Stock> getAll() {
		return stocksData;
	}

	public void add(Stock stock) {
		stocksData.add(stock);
	}

	public float getGbceAllShareIndex() {
		return calculateGeometricMean(tradesService.getAll(Constants.MINUTES_LIMIT_FOR_TRADES));
	}

}

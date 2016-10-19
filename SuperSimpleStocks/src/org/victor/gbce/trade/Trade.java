package org.victor.gbce.trade;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.victor.gbce.util.BuySellIndicator;

public class Trade {

	private static final Logger log = LoggerFactory.getLogger(Trade.class);

	private String stockSymbol;
	private LocalDateTime localTime;
	private int quantityOfShares;
	private BuySellIndicator indicator;
	private int price;

	public Trade() {
	}

	public Trade(String stockSymbol, int quantityOfShares, BuySellIndicator indicator, int price) {
		super();
		this.localTime = LocalDateTime.now();

		this.stockSymbol = stockSymbol;
		this.quantityOfShares = quantityOfShares;
		this.indicator = indicator;
		this.price = price;
	}

	public Trade(String stockSymbol, int quantityOfShares, BuySellIndicator indicator, int price,
			LocalDateTime localTime) {
		super();
		this.stockSymbol = stockSymbol;
		this.quantityOfShares = quantityOfShares;
		this.indicator = indicator;
		this.price = price;
		this.localTime = localTime;
	}

	@Override
	public String toString() {
		return String.format("Trade [stockSymbol=%s, time=%s, quantityOfShares=%s, indicator=%s, price=%s]",
				stockSymbol, localTime, quantityOfShares, indicator, price);
	}

	public String getStockSymbol() {
		return stockSymbol;
	}

	public LocalDateTime getTime() {
		return localTime;
	}

	public int getQuantityOfShares() {
		return quantityOfShares;
	}

	public BuySellIndicator getIndicator() {
		return indicator;
	}

	public int getPrice() {
		return price;
	}

}

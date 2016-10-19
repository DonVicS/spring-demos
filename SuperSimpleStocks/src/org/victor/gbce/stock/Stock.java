package org.victor.gbce.stock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.victor.gbce.util.StockType;

public class Stock {

	private static final Logger log = LoggerFactory.getLogger(Stock.class);

	private String stockSymbol;
	private StockType type;
	private float lastDividend;
	private float fixedDividend;
	private float parValue;

	private float dividendYield;
	private float priceEarningsRatio;
	private float geometricMean;
	private float stockPrice;

	public Stock(String stockSymbol, StockType type, float lastDividend, float fixedDividend, float parValue) {
		super();
		this.stockSymbol = stockSymbol;
		this.type = type;
		this.lastDividend = lastDividend;
		this.fixedDividend = fixedDividend;
		this.parValue = parValue;
	}

	public String getStockSymbol() {
		return stockSymbol;
	}

	public StockType getType() {
		return type;
	}

	public float getLastDividend() {
		return lastDividend;
	}

	public float getFixedDividend() {
		return fixedDividend;
	}

	public float getParValue() {
		return parValue;
	}

	public float getDividendYield() {
		return dividendYield;
	}

	public void setDividendYield(float dividendYield) {
		this.dividendYield = dividendYield;
	}

	public float getPriceEarningsRatio() {
		return priceEarningsRatio;
	}

	public void setPriceEarningsRatio(float priceEarningsRatio) {
		this.priceEarningsRatio = priceEarningsRatio;
	}

	public float getGeometricMean() {
		return geometricMean;
	}

	public void setGeometricMean(float geometricMean) {
		this.geometricMean = geometricMean;
	}

	public float getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(float stockPrice) {
		this.stockPrice = stockPrice;
	}

	@Override
	public String toString() {
		return String.format(
				"Stock [stockSymbol=%s, type=%s, lastDividend=%s, fixedDividend=%s, parValue=%s, dividendYield=%s, priceEarningsRatio=%s, geometricMean=%s, stockPrice=%s]",
				stockSymbol, type, lastDividend, fixedDividend, parValue, dividendYield, priceEarningsRatio,
				geometricMean, stockPrice);
	}

}

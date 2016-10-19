package org.victor.gbce;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.victor.gbce.exceptions.StockNotFoundException;
import org.victor.gbce.stock.Stock;
import org.victor.gbce.stock.StocksService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StocksServiceTest {

	@Autowired
	private StocksService service;

	@SuppressWarnings("unused")
	private void printAll(Set<Stock> stocks) {
		stocks.forEach(System.out::println);
	}

	@Test
	public void getAll() {
		Set<Stock> stocks = service.getAll();
		assertEquals(5, stocks.size());
	}

	@Test(expected = StockNotFoundException.class)
	public void getOneNotFoundException() {
		service.getOne("AAA");
	}

	@Test
	public void getOneStock_TEA() {
		Stock stock = service.getOne("TEA");
		double delta = 0.01;
		assertEquals(0, stock.getDividendYield(), delta);
		assertEquals(0, stock.getPriceEarningsRatio(), delta);
		assertEquals(114.89, stock.getGeometricMean(), delta);
		assertEquals(115, stock.getStockPrice(), delta);
	}

	@Test
	public void getOneStock_GIN() {
		Stock stock = service.getOne("GIN");
		double delta = 0.01;
		assertEquals(0.1267, stock.getDividendYield(), delta);
		assertEquals(15.781, stock.getPriceEarningsRatio(), delta);
		assertEquals(127.47, stock.getGeometricMean(), delta);
		assertEquals(126.25, stock.getStockPrice(), delta);
	}

	@Test
	public void getGbceAllShareIndex() {
		float allShareIndex = service.getGbceAllShareIndex();
		double delta = 0.01;
		assertEquals(121.0199, allShareIndex, delta);
	}

}

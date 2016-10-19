package org.victor.gbce;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.victor.gbce.trade.Trade;
import org.victor.gbce.trade.TradesService;
import org.victor.gbce.util.Constants;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TradesServiceTest {

	@Autowired
	private TradesService service;

	@SuppressWarnings("unused")
	private void printAll(List<Trade> trades) {
		trades.forEach(System.out::println);
	}

	@Test
	public void getAll() {
		List<Trade> trades = service.getAll();
		assertEquals(6, trades.size());
	}

	@Test
	public void getAllWithin_15_mins() {
		List<Trade> trades = service.getAll(Constants.MINUTES_LIMIT_FOR_TRADES);
		assertEquals(4, trades.size());
	}

	@Test
	public void getWithPredicate() {
		List<Trade> trades = service.get(t -> t.getStockSymbol().equals("TEA"));
		assertEquals(4, trades.size());
	}

	@Test
	public void getWithPredicateWithin_15_mins() {
		LocalDateTime limit = LocalDateTime.now().minusMinutes(Constants.MINUTES_LIMIT_FOR_TRADES);
		List<Trade> trades = service.get(t -> t.getStockSymbol().equals("TEA") && t.getTime().isAfter(limit));
		assertEquals(2, trades.size());
	}

	@Test
	public void getByStockName() {
		List<Trade> trades = service.get("TEA");
		assertEquals(4, trades.size());
	}

	@Test
	public void getByStockNameWithin_15_mins() {
		List<Trade> trades = service.get("TEA", Constants.MINUTES_LIMIT_FOR_TRADES);
		assertEquals(2, trades.size());
	}

}

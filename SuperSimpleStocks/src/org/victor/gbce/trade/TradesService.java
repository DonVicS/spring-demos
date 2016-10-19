package org.victor.gbce.trade;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TradesService {

	private static final Logger log = LoggerFactory.getLogger(TradesService.class);

	private List<Trade> trades;

	public TradesService() {
		trades = new ArrayList<>();
	}

	public void add(Trade trade) {
		this.trades.add(trade);
	}

	public List<Trade> get(String stockSymbol) {
		return get(t -> t.getStockSymbol().equals(stockSymbol));
	}

	public List<Trade> get(String stockSymbol, long minutes) {
		LocalDateTime limit = LocalDateTime.now().minusMinutes(minutes);
		return get(t -> t.getStockSymbol().equals(stockSymbol) && t.getTime().isAfter(limit));
	}

	public List<Trade> get(Predicate<Trade> predicate) {
		return trades.stream().filter(predicate).collect(Collectors.toList());
	}

	public List<Trade> getAll() {
		return trades;
	}

	public List<Trade> getAll(long minutes) {
		LocalDateTime limit = LocalDateTime.now().minusMinutes(minutes);
		return trades.stream().filter(t -> t.getTime().isAfter(limit)).collect(Collectors.toList());
	}

}

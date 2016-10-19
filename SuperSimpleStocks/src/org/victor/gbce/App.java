package org.victor.gbce;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.victor.gbce.stock.Stock;
import org.victor.gbce.stock.StocksService;
import org.victor.gbce.trade.Trade;
import org.victor.gbce.trade.TradesService;
import org.victor.gbce.util.BuySellIndicator;
import org.victor.gbce.util.StockType;

@SpringBootApplication
public class App {

	private static final Logger log = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		SpringApplication.run(App.class);
	}

	@Bean
	public CommandLineRunner demoStocks(StocksService service) {
		return (args) -> {
			service.add(new Stock("TEA", StockType.COMMON, 0, 0, 100));
			service.add(new Stock("POP", StockType.COMMON, 8, 0, 100));
			service.add(new Stock("ALE", StockType.COMMON, 23, 0, 60));
			service.add(new Stock("GIN", StockType.PREFERRED, 8, 0.02f, 100));
			service.add(new Stock("JOE", StockType.COMMON, 13, 0, 250));
		};
	}

	@Bean
	public CommandLineRunner demoTrades(TradesService service) {
		LocalDateTime timestamp = LocalDateTime.now().minusMinutes(20);
		return (args) -> {
			service.add(new Trade("TEA", 20, BuySellIndicator.BUY, 120, timestamp));
			service.add(new Trade("TEA", 20, BuySellIndicator.BUY, 120, timestamp));
			service.add(new Trade("TEA", 20, BuySellIndicator.BUY, 120));
			service.add(new Trade("TEA", 20, BuySellIndicator.BUY, 110));
			
			service.add(new Trade("GIN", 10, BuySellIndicator.BUY, 130));
			service.add(new Trade("GIN", 30, BuySellIndicator.BUY, 125));
		};
	}

}

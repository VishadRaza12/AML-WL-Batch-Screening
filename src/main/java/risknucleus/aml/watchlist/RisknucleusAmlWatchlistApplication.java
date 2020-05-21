package risknucleus.aml.watchlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import risknucleus.aml.watchlist.service.ListMatches;

@SpringBootApplication
@Component
public class RisknucleusAmlWatchlistApplication {

	
	public static void main(String[] args) {
		
		SpringApplication.run(RisknucleusAmlWatchlistApplication.class, args);
		
	}
	
}

package risknucleus.aml.watchlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import risknucleus.aml.watchlist.service.ListMatches;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
  //  private static final Logger logger = LoggerFactory.getLogger(CommandLineAppStartupRunner.class);
	@Autowired
	private  ListMatches listmatches;

	
	@Override
    public void run(String...args) throws Exception {
       // logger.info("Application started with command-line arguments: {} . \n To kill this application, press Ctrl + C.", Arrays.toString(args));
   listmatches.fetchedList();
	}
	
}
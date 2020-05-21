package risknucleus.aml.watchlist.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import risknucleus.aml.watchlist.model.Request;
import risknucleus.aml.watchlist.model.WatchlistMatchesPOJO;
import risknucleus.aml.watchlist.service.ListMatches;




@RestController
public class Matchescontroller {
	

//
//	@Autowired
//	private WatchlistMatches watchlistMatches;
	
//	@Autowired
//	private Match match;
	
	
	@Autowired
	private ListMatches listMatches;
	
	//List<WatchlistMatchesPOJO> list = new ArrayList<>();
	List<WatchlistMatchesPOJO> list2 = new ArrayList<>();
	
//	@RequestMapping(method = RequestMethod.POST, value = "/watchlist/list", consumes = "application/json")
//	public void checkStatus(@Valid @RequestBody ListNewPOJO request) {
//		trynew.getResult(request);
//
//	}
	
	@ResponseBody
	@GetMapping("/api/matches/incremental")
	public List<WatchlistMatchesPOJO> getall() throws IllegalArgumentException, IllegalAccessException {
	 list2 = listMatches.MatchesFind();
		return list2;
	}
	
	@ResponseBody
	@GetMapping("/api/matches/diffrential")
	public List<WatchlistMatchesPOJO> MatchesDifferential() throws IllegalArgumentException, IllegalAccessException{
		list2 = listMatches.Matchesdifferential();
		return list2;
	}
	
	
//	@ResponseBody
//	@GetMapping("/api/config/listnew")
//	public void getall() {
//	 try {
//		trynew.fetchList();
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
//	}
	
//original
	@RequestMapping(method = RequestMethod.POST, value = "/api/customerscreening", consumes = "application/json")
	public synchronized List<WatchlistMatchesPOJO> customerScreening(@Valid @RequestBody Request request) throws IllegalArgumentException, IllegalAccessException {
		List<WatchlistMatchesPOJO> list = new ArrayList<>();
		return listMatches.screenCustomer(request);
		
		//return list;
	}
	
	
	
//	@RequestMapping(method = RequestMethod.POST, value = "/api/customerscreening", consumes = "application/json")
//	public synchronized List<WatchlistMatchesPOJO> customerScreening(@Valid @RequestBody Request request) throws IllegalArgumentException, IllegalAccessException {
//		List<WatchlistMatchesPOJO> list = new ArrayList<>();
//		//return listMatches.screenCustomer(request);
//		return test(request);
//		//return list;
//	}
//	
//	public  List<WatchlistMatchesPOJO> test(@RequestBody Request request) throws IllegalArgumentException, IllegalAccessException{
//		return listMatches.screenCustomer(request);
//	}
//	
}

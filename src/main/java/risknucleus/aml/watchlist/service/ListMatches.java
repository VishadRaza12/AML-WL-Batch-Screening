package risknucleus.aml.watchlist.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.validation.Valid;

import org.simmetrics.metrics.StringMetrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import risknucleus.aml.watchlist.bean.Input;
import risknucleus.aml.watchlist.bean.WatchlistOutput;
import risknucleus.aml.watchlist.model.AlternateName;
import risknucleus.aml.watchlist.model.Customer_customernew;
import risknucleus.aml.watchlist.model.FocusTypes;
import risknucleus.aml.watchlist.model.LogsMaintain;
import risknucleus.aml.watchlist.model.RealtimeHit;
import risknucleus.aml.watchlist.model.Request;
import risknucleus.aml.watchlist.model.ScenarioThreshold;
import risknucleus.aml.watchlist.model.Servicepool;
import risknucleus.aml.watchlist.model.WatchlistAlertPOJO;
import risknucleus.aml.watchlist.model.WatchlistListNew;
import risknucleus.aml.watchlist.model.WatchlistMatchesPOJO;
import risknucleus.aml.watchlist.model.Watchlist_columnsetup;
import risknucleus.aml.watchlist.model.Watchlist_condition;
import risknucleus.aml.watchlist.model.Watchlist_conditiondetail;
import risknucleus.aml.watchlist.model.Watchlist_operator;
import risknucleus.aml.watchlist.model.Watchlist_scenario_setup;
import risknucleus.aml.watchlist.model.Watchlist_scenariothreshold;
import risknucleus.aml.watchlist.model.Watchlist_tablesetup;
import risknucleus.aml.watchlist.repository.AlternateNameRepository;
import risknucleus.aml.watchlist.repository.ColumnSetupRepository;
import risknucleus.aml.watchlist.repository.ConditionDetailRepository;
import risknucleus.aml.watchlist.repository.ConditionRepository;
import risknucleus.aml.watchlist.repository.CustomerRepository;
import risknucleus.aml.watchlist.repository.FocusTypesRepository;
import risknucleus.aml.watchlist.repository.FunctionSetupRepository;
import risknucleus.aml.watchlist.repository.LogsMaintainRepository;
import risknucleus.aml.watchlist.repository.RealTimeRepository;
import risknucleus.aml.watchlist.repository.ScenarioSetupRepository;
import risknucleus.aml.watchlist.repository.ScenarioThresholdRepository;
import risknucleus.aml.watchlist.repository.ServicepoolRepository;
import risknucleus.aml.watchlist.repository.StaticConfigurationRepository;
import risknucleus.aml.watchlist.repository.TableSetupRepository;
import risknucleus.aml.watchlist.repository.WatchListlistNewRepository;
import risknucleus.aml.watchlist.repository.WatchlistOperatorRepository;

@Service
public class ListMatches {
	@Autowired
	private ScenarioSetupRepository scenarioSetupRepository;

	@Autowired
	private AlternateNameRepository alternateNameRepository;

	@Autowired
	private WatchlistService watchListService;

	@Autowired
	private TableSetupRepository tableSetupRepository;
	
	@Autowired
	private StaticConfigurationRepository staticConfigurationRepository;

	@Autowired
	private WatchlistOperatorRepository watchlistOperatorRepository;

	@Autowired
	private FunctionSetupRepository functionSetupRepository;

	@Autowired
	private ColumnSetupRepository columnSetupRepository;
	
	@Autowired
	private LogsMaintainRepository logsMaintainRepository;
	
	@Autowired
	private RealTimeRepository realTimeRepository;

	List<Watchlist_scenario_setup> scenario;
	List<Watchlist_condition> conditionAll;
	List<AlternateName> alternateNameList;
	List<Watchlist_condition> condition;
	List<Watchlist_conditiondetail> conditionDetailAll;
	List<Watchlist_conditiondetail> conditionDetail;
	List<Customer_customernew> customerlist = new ArrayList<Customer_customernew>();
	List<WatchlistListNew> watchlist = new ArrayList<WatchlistListNew>();
	List<Customer_customernew> customertemp = new ArrayList<Customer_customernew>();
	List<WatchlistListNew> watchlisttemp = new ArrayList<WatchlistListNew>();
	FunctionsService functionService = new FunctionsService();
	List<Watchlist_tablesetup> tablesetup;
	List<Watchlist_operator> operatorlist;
	List<Watchlist_columnsetup> columnlist;
	Watchlist_operator operatr;
	Watchlist_columnsetup customertablecol1;
	Watchlist_columnsetup watchlistcolname1;
	WatchlistAlertPOJO alerts;
	WatchlistOutput watchlistOutput;
	RestTemplate restTemplate;
	Integer AlertID;

	String name = "";
	Boolean flg = false;
	String finalName = "";
	String fName = "";

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private WatchListlistNewRepository watchlistrepo;

	@Autowired
	private ConditionDetailRepository conditionDetailRepository;
	@Autowired
	private ConditionRepository conditionRepository;

	@Autowired
	private ScenarioThresholdRepository scenarioThresholdRepository;

	@Autowired
	private ServicepoolRepository servicepoolRepository;

	Customer_customernew customerTocheck;
	FocusTypes focusType;
	List<FocusTypes> focustypelist = new ArrayList<FocusTypes>();
	List<WatchlistMatchesPOJO> matchlist = new ArrayList<WatchlistMatchesPOJO>();
	List<WatchlistMatchesPOJO> matchlistduplicate = new ArrayList<WatchlistMatchesPOJO>();
	List<WatchlistMatchesPOJO> matchlistreturn = new ArrayList<WatchlistMatchesPOJO>();
	List<Servicepool> servicepoollist = new ArrayList<Servicepool>();
	List<Watchlist_scenario_setup> scenariosetup = new ArrayList<Watchlist_scenario_setup>();


	Integer focusTypeId;
	Servicepool servicepool = new Servicepool();
	Integer count = 0, countIncremental = 0;
	LogsMaintain log;
	@Autowired
	private FocusTypesRepository focusTypesRepository;

	int threshold = 0;
	String value,fetchedvalue,hcodevalue;
	@Value("${servicepoolvalue}")
	private int poolvalue;
	

//incremental screening
	public List<WatchlistMatchesPOJO> MatchesFind() throws IllegalArgumentException, IllegalAccessException {
        log= new LogsMaintain();
		customerlist.clear();
		log.setCurrentStatus("cutomerlist emptied");
		logsMaintainRepository.save(log);
//		log= new LogsMaintain();
//		operatorlist = watchlistOperatorRepository.findAll();
//		log.setCurrentStatus("opertorlist fetched");
//		logsMaintainRepository.save(log);
		log= new LogsMaintain();
		hcodevalue = getServiceResponse();
		log.setCurrentStatus("hcodevalue fetched");
		logsMaintainRepository.save(log);
//		log= new LogsMaintain();
//		tablesetup = tableSetupRepository.findAll();
//		log.setCurrentStatus("tablesetup list fetched");
//		logsMaintainRepository.save(log);
//		log= new LogsMaintain();
//		columnlist = columnSetupRepository.findAll();
//		log.setCurrentStatus("columns fetched");
//		logsMaintainRepository.save(log);
		log= new LogsMaintain();
		watchlist = watchlistrepo.findAll();
		log.setCurrentStatus("listnew fetched");
		logsMaintainRepository.save(log);
//		log= new LogsMaintain();
//		conditionAll = conditionRepository.findAll();
//		log.setCurrentStatus("conditions fetched");
//		logsMaintainRepository.save(log);
//		log= new LogsMaintain();
//		conditionDetailAll = conditionDetailRepository.findAll();
//		log.setCurrentStatus("conditiondetail list fetched");
//		logsMaintainRepository.save(log);
//		log= new LogsMaintain();
//		alternateNameList = alternateNameRepository.getNameList();
//		log.setCurrentStatus("alternate name list fetched");
//		logsMaintainRepository.save(log);
		log= new LogsMaintain();
		scenariosetup = scenarioSetupRepository.findAllActiveScenarios();
		log.setCurrentStatus("scennarios fetched");
		logsMaintainRepository.save(log);
		log= new LogsMaintain();
		servicepoolRepository.insertCustomer();
		log.setCurrentStatus("servicepool data inserted");
		logsMaintainRepository.save(log);
		matchlist = MatchFind();
		

		return matchlist;
	}
	
	//incremental
	public List<WatchlistMatchesPOJO> MatchFind() throws IllegalArgumentException, IllegalAccessException{
		countIncremental = servicepoolRepository.getIncrementalCount();
		matchlist.clear();
		matchlistduplicate.clear();
		matchlistreturn.clear();

		do
			incrementalcheck(scenariosetup, watchlist, customerlist, conditionAll, conditionDetailAll);
		while (countIncremental != 0);

		matchlistduplicate = matchlist.stream().filter(distinctByKey(p -> p.getCustomerId()))
				.collect(Collectors.toList());

		for (WatchlistMatchesPOJO duplicate : matchlistduplicate) {
			matchlistreturn.clear();
			for (WatchlistMatchesPOJO original : matchlist) {
				if (duplicate.getCustomerId() == original.getCustomerId()) {
					matchlistreturn.add(original);
				}
			}
			
			watchlistOutput = new WatchlistOutput();
			alerts = new WatchlistAlertPOJO();
			alerts.setScenarioClassId(6);
			alerts.setFocusTypeId(focusTypeId);
			alerts.setAlertType("A");
// alerts.setFocusColumnValue(id.toString());
			alerts.setAlertDate(new Date());
			alerts.setAlertScore(null);
			alerts.setWfStatus(3020);
			alerts.setAlertDueDate(new Date());
			alerts.setActivityStatus(1);
			alerts.sethCode(Integer.parseInt(hcodevalue));
			watchlistOutput.setAlerts(alerts);
			watchlistOutput.setMatches(matchlistreturn);
//35.226.249.140
			restTemplate = new RestTemplate();
			watchlistOutput = restTemplate.postForObject("http://35.226.249.140:8076/api/watchlistalerts", watchlistOutput,
					WatchlistOutput.class);

			WatchlistAlertPOJO alertpojo = watchlistOutput.getAlerts();
			AlertID = alertpojo.getAlertId();
// call api matchlistreturn;
		}
		
		return matchlist;
	}

	// incremental search
	public void incrementalcheck(List<Watchlist_scenario_setup> scenariosetup, List<WatchlistListNew> watchlist,
			List<Customer_customernew> customerlist, List<Watchlist_condition> conditionAll,
			List<Watchlist_conditiondetail> conditionDetailAll)
			throws IllegalArgumentException, IllegalAccessException {
		Pageable pageable = PageRequest.of(0, poolvalue);
		servicepoollist = servicepoolRepository.UpdateStatus(pageable);
		servicepoollist.stream().forEach(u -> u.setStatus("I"));
		servicepoolRepository.saveAll(servicepoollist);

		customerlist = customerRepository.getCustomerRecords();
		for (Customer_customernew customer : customerlist) {
			threshold = scenarioThresholdRepository.getThresholdValue(customer.getUniqueRefNo());
			scenario = scenariosetup.stream().filter(s -> s.getScore() >= threshold).collect(Collectors.toList());
			// scenario = scenarioSetupRepository.getActivescenarios(threshold);
			for (WatchlistListNew listnew : watchlist) {

				// loop for scenario
				loop: for (Watchlist_scenario_setup sce : scenario) {
					// get all conditions
					condition = conditionAll.stream()
							.filter(conditionAl -> sce.getScenarioId()
									.equals(conditionAl.getWatchlist_scenario_setup().getScenarioId()))
							.collect(Collectors.toList());
					// get all conditions
					Boolean match = getConditions(sce, customer, listnew, condition, operatorlist, tablesetup);
					
					if (!(match == false)) {
//						System.out.println(new Date() + "  scenario ID " + sce.getScenarioId() + " customr "
//								+ customer.getId() + " watchlist " + listnew.getId());

						WatchlistMatchesPOJO matchfound = new WatchlistMatchesPOJO();
						matchfound.setScenarioId(sce.getScenarioId());
						matchfound.setFocusTypeId(focusTypeId);
						matchfound.setFocusTypeValue("2");
						matchfound.setMatchDate(new Date());
						matchfound.setCustomerId(customer.getId());
						matchfound.setScore(sce.getScore());
						matchfound.setWatchlistId(listnew.getId().toString());
						matchfound.setListType(listnew.getListType());
						matchfound.setEntityTypeId(listnew.getEntityType());
						matchfound.setActualName(listnew.getActualName());
						matchfound.setCountryToken(listnew.getCountryToken());
						matchfound.setIdRegDoc(listnew.getIdRegDOc());
						matchlist.add(matchfound);

						break loop;

					}
				}
			}

		}
		servicepoollist.stream().forEach(u -> u.setStatus("C"));
		servicepoolRepository.saveAll(servicepoollist);

		countIncremental = servicepoolRepository.getIncrementalCount();
	}
	//********* incremental completed ********
	//startcall funct
	public synchronized void fetchedList() {
		operatorlist = watchlistOperatorRepository.findAll();
		tablesetup = tableSetupRepository.findAll();
		columnlist = columnSetupRepository.findAll();
		focustypelist = focusTypesRepository.findAll();
		conditionAll = conditionRepository.findAll();
		conditionDetailAll = conditionDetailRepository.findAll();
		alternateNameList = alternateNameRepository.getNameList();
		
	
	}
	

	// single customer screening
	public synchronized List<WatchlistMatchesPOJO> screenCustomer(@Valid Request request)
			throws IllegalArgumentException, IllegalAccessException {
		RealtimeHit realtimeHit = new RealtimeHit();
		RealtimeHit realtimeHit1 = new RealtimeHit();
//		conditionAll = conditionRepository.findAll();
//		conditionDetailAll = conditionDetailRepository.findAll();
//		operatorlist = watchlistOperatorRepository.findAll();
//		tablesetup = tableSetupRepository.findAll();
//		columnlist = columnSetupRepository.findAll();
//		focustypelist = focusTypesRepository.findAll();
//
//		alternateNameList = alternateNameRepository.getNameList();
		fName = checkforAlternateName(request.getCustomerName(), alternateNameList);

		matchlist.clear();

       //customerTocheck = getCustomer(request);
		Date dee = new Date();
		realtimeHit1.setHitstart(dee);
		realtimeHit1.setPlace("For customer name");
		customerTocheck = new Customer_customernew();
		// customerTocheck.setActualName(fName);
		customerTocheck.setActualName(request.getCustomerName());
		customerTocheck.setCountryToken(request.getCountry());
		customerTocheck.setEntityType(request.getEntityId());
		customerTocheck.setFocusType(request.getFocusType());
		customerTocheck.setIdRegDoc(request.getIdentityNumber());
		customerTocheck.setUniqueRefNo(request.getFixedReference());
		customerTocheck.setYearOfBirth(getYear(request.getDob()));


		Input i = new Input();
		i.setName(request.getCustomerName());

		WatchlistListNew wl2 = new WatchlistListNew();
		wl2 = watchListService.getWatchListObject(i);
		customerTocheck.setFullName(wl2.getFullName());
		customerTocheck.setFullNameMeta(wl2.getFullNameMeta());

		Input in = new Input();
		in.setName(fName);
		WatchlistListNew wl1 = new WatchlistListNew();

		wl1 = watchListService.getWatchListObject(in);

		customerTocheck.setFullNameMetaSansSW(wl1.getFullNameMetaSansSW());
		customerTocheck.setFullNameSound(wl1.getFullNameSound());
		customerTocheck.setFullNameSoundSansSW(wl1.getFullNameSoundSansSw());
		customerTocheck.setFullNameSansSW(wl1.getFullNameSanSW());
		Date dee2= new Date();
		realtimeHit1.setHitend(dee2);
		realTimeRepository.save(realtimeHit1);

     RealtimeHit realtimeHit2 = new RealtimeHit();
     Date dee1 = new Date();
     realtimeHit2.setHitstart(dee1);
     realtimeHit2.setPlace("database hit");
		watchlist = watchlistrepo.getActiveList();
        focusType = focustypelist.stream().filter(w->w.getFocusTypeKey().equals(request.getSystemInfo())).findAny().orElse(null);
		//focusType = focusTypesRepository.findByFocusTypeKey(request.getSystemInfo()); //
		focusTypeId = focusType.getFocusTypeId();
		// threshold = scenarioThresholdRepository.getfocusType(focusTypeId);
		scenario = scenarioSetupRepository.getActivescenarios(80);
		Date dee3= new Date();
		realtimeHit2.setHitend(dee3);
		realTimeRepository.save(realtimeHit2);
		
		Date d= new Date();
		realtimeHit.setHitstart(d);
		realtimeHit.setPlace("Customerscreening");
		for (WatchlistListNew listnew : watchlist) {

			// loop for scenario
			loop: for (Watchlist_scenario_setup sce : scenario) {
				condition = conditionAll.stream()
						.filter(conditionAll -> sce.getScenarioId()
								.equals(conditionAll.getWatchlist_scenario_setup().getScenarioId()))
						.collect(Collectors.toList());
				// get all conditions
				Boolean match = getConditions(sce, customerTocheck, listnew, condition, operatorlist, tablesetup);
				if (!(match == false)) {

					WatchlistMatchesPOJO matchfound = new WatchlistMatchesPOJO();
					matchfound.setScenarioId(sce.getScenarioId());
					matchfound.setFocusTypeId(focusTypeId);
					matchfound.setFocusTypeValue("2");
					matchfound.setMatchDate(new Date());
					matchfound.setScore(sce.getScore());
					matchfound.setWatchlistId(listnew.getId().toString());
					matchfound.setListType(listnew.getListType());
					matchfound.setEntityTypeId(listnew.getEntityType());
					matchfound.setActualName(listnew.getActualName());
					matchfound.setCountryToken(listnew.getCountryToken());
					matchfound.setIdRegDoc(listnew.getIdRegDOc());
					matchlist.add(matchfound);

					break loop;

				}
			}
		}
		

		Date de= new Date();
		realtimeHit.setHitend(de);
		realTimeRepository.save(realtimeHit);
		return matchlist;
	}


	// *********** Differentail Request **************//
	public List<WatchlistMatchesPOJO> Matchesdifferential() throws IllegalArgumentException, IllegalAccessException {

//		operatorlist = watchlistOperatorRepository.findAll();
//		tablesetup = tableSetupRepository.findAll();
//		columnlist = columnSetupRepository.findAll();
		log= new LogsMaintain();
		hcodevalue = getServiceResponse();
		log.setCurrentStatus("differential hicodevalue fetched");
		logsMaintainRepository.save(log);
		
		log= new LogsMaintain();
		watchlist = watchlistrepo.getWatchList();
		log.setCurrentStatus("differential watchlist fetched");
		logsMaintainRepository.save(log);
		log= new LogsMaintain();
		servicepoolRepository.insertDifferentialCustomer();
		log.setCurrentStatus("diffrntial customer insert");
		logsMaintainRepository.save(log);

		//alternateNameList = alternateNameRepository.getNameList();
		log= new LogsMaintain();
	     scenariosetup = scenarioSetupRepository.findAllActiveScenarios();
	     log.setCurrentStatus("differential/ scenarios fetched");
	     logsMaintainRepository.save(log);
		//conditionAll = conditionRepository.findAll();
		//conditionDetailAll = conditionDetailRepository.findAll();
		
		matchlist = MatchDifferential();
		return matchlist;

	}
	
	public List<WatchlistMatchesPOJO> MatchDifferential() throws IllegalArgumentException, IllegalAccessException{
		count = servicepoolRepository.getCount();
		customerlist.clear();
		matchlist.clear();
		matchlistduplicate.clear();
		matchlistreturn.clear();
		do
			checkdifferential(scenariosetup, watchlist, customerlist, conditionAll, conditionDetailAll);
		while (count != 0);
      
		matchlistduplicate = matchlist.stream().filter(distinctByKey(p -> p.getCustomerId()))
				.collect(Collectors.toList());

		for (WatchlistMatchesPOJO duplicate : matchlistduplicate) {
			matchlistreturn.clear();
			for (WatchlistMatchesPOJO original : matchlist) {
				if (duplicate.getCustomerId() == original.getCustomerId()) {
					matchlistreturn.add(original);
				}
			}
			watchlistOutput = new WatchlistOutput();
			alerts = new WatchlistAlertPOJO();
			alerts.setScenarioClassId(6);
			alerts.setAlertType("D");
			alerts.setFocusTypeId(focusTypeId);
			// alerts.setFocusColumnValue(id.toString());
			alerts.setAlertDate(new Date());
			alerts.setAlertScore(null);
			alerts.setWfStatus(3020);
			alerts.setAlertDueDate(new Date());
			alerts.setActivityStatus(1);
			alerts.sethCode(Integer.parseInt(hcodevalue));
			watchlistOutput.setAlerts(alerts);
			watchlistOutput.setMatches(matchlistreturn);

			restTemplate = new RestTemplate();
			watchlistOutput = restTemplate.postForObject("http://35.226.249.140:8076/api/watchlistalerts", watchlistOutput,
					WatchlistOutput.class);

			WatchlistAlertPOJO alertpojo = watchlistOutput.getAlerts();
			AlertID = alertpojo.getAlertId();
		}
	return matchlist;
	}

	// fucntion for diif
	public void checkdifferential(List<Watchlist_scenario_setup> scenariosetup, List<WatchlistListNew> watchlist,
			List<Customer_customernew> customerlist, List<Watchlist_condition> conditionAll,
			List<Watchlist_conditiondetail> conditionDetailAll)
			throws IllegalArgumentException, IllegalAccessException {
		Pageable pageable = PageRequest.of(0, poolvalue);
		servicepoollist = servicepoolRepository.UpdateStatusDifferential(pageable);

		servicepoollist.stream().forEach(u -> u.setStatus("I"));
		servicepoolRepository.saveAll(servicepoollist);
		customerlist = customerRepository.getCustomerRecordsDifferential();
	
		for (Customer_customernew customer : customerlist) {
			threshold = scenarioThresholdRepository.getThresholdValue(customer.getUniqueRefNo());
			
			scenario = scenariosetup.stream().filter(s -> s.getScore() >= threshold).collect(Collectors.toList());
			// scenario = scenarioSetupRepository.getActivescenarios(threshold);
			for (WatchlistListNew listnew : watchlist) {

				// loop for scenario
				loop: for (Watchlist_scenario_setup sce : scenario) {
					// get all conditions
					condition = conditionAll.stream()
							.filter(conditionAl -> sce.getScenarioId()
									.equals(conditionAl.getWatchlist_scenario_setup().getScenarioId()))
							.collect(Collectors.toList());
					// get all conditions
					Boolean match = getConditions(sce, customer, listnew, condition, operatorlist, tablesetup);
					// Boolean match = getConditions(sce, customer, listnew,operatorlist,
					// tablesetup);
					if (!(match == false)) {

						WatchlistMatchesPOJO matchfound = new WatchlistMatchesPOJO();
						matchfound.setScenarioId(sce.getScenarioId());
						matchfound.setFocusTypeId(focusTypeId);
						matchfound.setFocusTypeValue("2");
						matchfound.setMatchDate(new Date());
						matchfound.setCustomerId(customer.getId());
						matchfound.setScore(sce.getScore());
						matchfound.setWatchlistId(listnew.getId().toString());
						matchfound.setListType(listnew.getListType());
						matchfound.setEntityTypeId(listnew.getEntityType());
						matchfound.setActualName(listnew.getActualName());
						matchfound.setCountryToken(listnew.getCountryToken());
						matchfound.setIdRegDoc(listnew.getIdRegDOc());
						matchlist.add(matchfound);

						break loop;

					}
				}
			}

		}
		servicepoollist.stream().forEach(u -> u.setStatus("C"));
		servicepoolRepository.saveAll(servicepoollist);
		
		count = servicepoolRepository.getCount();
	}

// *************** Matches END *************** //
	private Boolean getConditions(Watchlist_scenario_setup sce, Customer_customernew customer, WatchlistListNew listnew,
			List<Watchlist_condition> condition, List<Watchlist_operator> operatorlst,
			List<Watchlist_tablesetup> tablelst) throws IllegalArgumentException, IllegalAccessException {
		// condition = conditionRepository.findAllByScenarioID(sce);

		Boolean match = false;
		for (Watchlist_condition cond : condition) {

			conditionDetail = conditionDetailAll.stream().filter(
					conditionDetailAll -> cond.getId().equals(conditionDetailAll.getWatchlist_condition().getId()))
					.collect(Collectors.toList());

			match = getconditionDetails(cond, sce.getScenarioId(), customer, listnew, conditionDetail, operatorlst,
					tablelst);
			if (match == false) {
				break;
			}

		}
		return match;

	}

	private Boolean getconditionDetails(Watchlist_condition cond, Integer scenarioId, Customer_customernew customer,
			WatchlistListNew listnew, List<Watchlist_conditiondetail> conditionDetail,
			List<Watchlist_operator> operatorlst, List<Watchlist_tablesetup> tablelst)
			throws IllegalArgumentException, IllegalAccessException {
		int function = 0;
		String operator = "", customertablecol = "", customertablename = "";
		String watchlisttablename = "", watchlistcolname = "";
		String input1 = "";

		// conditionDetail = conditionDetailRepository.findAllByCondition_ID(cond);
		for (Watchlist_conditiondetail conditiondetail : conditionDetail) {
			if (conditiondetail.getFunctionID() != null) {
				function = conditiondetail.getFunctionID();
			}
			if (conditiondetail.getOperatorID() != null) {
				operatr = operatorlst.stream().filter(c -> c.getId().equals(conditiondetail.getOperatorID())).findAny()
						.orElse(null);
				operator = operatr.getOperatorKey();

			}
			if (conditiondetail.getInputID() != null) {
				input1 = conditiondetail.getInputID();

			}

			if (conditiondetail.getTableID() != null) {
				if (conditiondetail.getTableID() == 16) {
					customertablename = tablesetup.get(0).getTableDisplayName();
					customertablecol1 = columnlist.parallelStream()
							.filter(d -> d.getId().equals(conditiondetail.getColumnID())).findAny().orElse(null);
					customertablecol = customertablecol1.getColumnName();

				} else if (conditiondetail.getTableID() == 17) {
					watchlisttablename = tablesetup.get(1).getTableDisplayName();
					watchlistcolname1 = columnlist.parallelStream()
							.filter(c -> c.getId().equals(conditiondetail.getColumnID())).findAny().orElse(null);
					watchlistcolname = watchlistcolname1.getColumnName();

				}
			}

		}
		Boolean match = getResult(scenarioId, input1, operator, watchlisttablename, watchlistcolname, customertablename,
				customertablecol, function, customer, listnew);
		return match;
	}

	private Boolean getResult(Integer scenarioId, String input1, String operator, String watchlisttablename,
			String watchlistcolname, String customertablename, String customertablecol, int function,
			Customer_customernew customer, WatchlistListNew listnew)
			throws IllegalArgumentException, IllegalAccessException {
		double input = 0;
		Boolean f = false;
		double i = 0;

		if (!input1.equals("")) {
			input = Double.parseDouble(input1);
		}
		Field fc = null, fw = null;
		if (customertablename != null) {
			Customer_customernew customer_customernew = new Customer_customernew();
			Field[] fieldsCust = customer_customernew.getClass().getDeclaredFields();
			for (Field f1 : fieldsCust) {

				f1.setAccessible(true);

				if (f1.getName().toString().toLowerCase().equals(customertablecol.toString().toLowerCase())) {
					fc = f1;
				}
			}
		}

		if (watchlisttablename != null) {
			WatchlistListNew watchlist = new WatchlistListNew();
			Field[] fields = watchlist.getClass().getDeclaredFields();
			for (Field f2 : fields) {

				f2.setAccessible(true);

				if (f2.getName().toString().toLowerCase().equals(watchlistcolname.toString().toLowerCase())) {
					fw = f2;
				}
			}

		}

		switch (function) {

		case 0:
			f = false;
			i = 0;
			if (fc != null && fw != null) {
				if (operator.equals("ET")) {
					f = fc.get(customer).toString().equals(fw.get(listnew).toString()) ? true : false;

				}
			}

			else if (fc != null) {
				if (operator.equals("ET")) {
					f = fc.get(customer).toString().equals(input1);
				}
			} else if (fw != null) {
				if (operator.equals("ET")) {
					f = fw.get(listnew).toString().equals(input1);
				}
			}
			if (f == false) {
				break;
			}
//			matches = "customer Id " + customer.getId() + " watchlist id " + listnew.getId() + " watchlist name: "
//					+ customer.getActualName() + " scenario id " + scenarioId;
			break;

		case 3:
			// Block Distance F
			f = false;
			i = 0;
			if (fc.get(customer) != null && fw.get(listnew) != null) {
				i = functionService.BlockDistanceF(fc.get(customer).toString(), fw.get(listnew).toString());
				f = getOperatorResult(operator, i, input);
			}

			if (f == false) {
				break;
			}
//			matches = "customer Id " + customer.getId() + " watchlist id " + listnew.getId() + " watchlist name: "
//					+ customer.getActualName() + " scenario id " + scenarioId;
			break;

		case 6:
			// LEN
			f = false;
			i = 0;
			// len
			if (fc != null && fc.get(customer) != null) {
				i = functionService.LEN(fc.get(customer).toString());
				f = getOperatorResult(operator, i, input);

			} else if (fw != null && fw.get(listnew) != null) {
				i = functionService.LEN(fw.get(listnew).toString());
				f = getOperatorResult(operator, i, input);
			}
			if (f == false) {
				break;
			}
//			matches = "customer Id " + customer.getId() + " watchlist id " + listnew.getId() + " watchlist name: "
//					+ customer.getActualName() + " scenario id " + scenarioId;
			break;

		case 9:
			// Overlap Coefficient f
			f = false;
			i = 0;
			if (fc.get(customer) != null && fw.get(listnew) != null) {
				i = functionService.OverlapCoefficientF(fc.get(customer).toString(), fw.get(listnew).toString());
				f = getOperatorResult(operator, i, input);
			}

			if (f == false) {
				break;
			}
			break;
		case 10:
			// WORD COUNT
			f = false;
			i = 0;
			if (fc != null && fc.get(customer) != null) {
				i = functionService.wordcount(fc.get(customer).toString());
				f = getOperatorResult(operator, i, input);

			} else if (fw != null && fw.get(listnew) != null) {
				i = functionService.wordcount(fw.get(listnew).toString());
				f = getOperatorResult(operator, i, input);
			}
			if (f == false) {
				break;
			}
//			matches = "customer ID " + customer.getId() + " watchlist id " + listnew.getId() + " watchlist name:"
//					+ customer.getActualName() + " scenario id " + scenarioId;
			break;

		case 20:
			// Token Match
			f = false;
			i = 0;
			if (fc.get(customer) != null && fw.get(listnew) != null) {
				i = functionService.splitMatchAlgo(fc.get(customer).toString(), fw.get(listnew).toString());
				f = getOperatorResult(operator, i, input);
			}

			if (f == false) {
				break;
			}
//			matches = "customer id " + customer.getId() + " watchlist id " + listnew.getId() + " watchlist name: "
//					+ customer.getActualName() + " scenario id " + scenarioId;
			break;

		case 21:
			// Large Word Split/Match Algorithm LV
			f = false;
			i = 0;
			if (fc.get(customer) != null && fw.get(listnew) != null) {
				i = functionService.LargeWordBreakupAlgoLEV(fc.get(customer).toString().toLowerCase(),
						fw.get(listnew).toString().toLowerCase());
				f = getOperatorResult(operator, i, input);
			}
			if (f == false) {
				break;
			}
		break;
		case 22:
			// Small Word Split/Match Algorithm LV
			f = false;
			i = 0;
			if (fc.get(customer) != null && fw.get(listnew) != null) {
				i = functionService.SmallWordBreakupAlgoLEV(fc.get(customer).toString().toLowerCase(),
						fw.get(listnew).toString().toLowerCase());
				f = getOperatorResult(operator, i, input);
			}
			if (f == false) {
				break;
			}

			break;

		case 23:
			// Large Word Split/Match Algorithm BD
			f = false;
			i = 0;
			if (fc.get(customer) != null && fw.get(listnew) != null) {
				i = functionService.LargeWordBreakupAlgoBD(fc.get(customer).toString().toLowerCase(),
						fw.get(listnew).toString().toLowerCase());
				f = getOperatorResult(operator, i, input);
			}
			if (f == false) {
				break;
			}
			break;

		case 24:
			// Small Word Split/Match Algorithm BD
			f = false;
			i = 0;
			if (fc.get(customer) != null && fw.get(listnew) != null) {
				i = functionService.SmallWordBreakupAlgoDB(fc.get(customer).toString().toLowerCase(),
						fw.get(listnew).toString().toLowerCase());
				f = getOperatorResult(operator, i, input);
			}
			if (f == false) {
				break;
			}
			break;
		}
		return f;

	}

	public boolean getOperatorResult(String operator, double funcanswer, double input) {
		Boolean flg = false;
		switch (operator) { // (double) Math.round(a * 100) / 100;
		case "ET":
			flg = (funcanswer == input) ? true : false;
			break;

		case "NET":
			flg = (funcanswer != input) ? true : false;
			break;

		case "GT":
			flg = (funcanswer > input) ? true : false;
			break;

		case "LT":
			flg = (funcanswer < input) ? true : false;
			break;

		case "GTE":
			flg = (funcanswer >= input) ? true : false;
			break;

		case "LTE":
			flg = (funcanswer <= input) ? true : false;
			break;

		}

		return flg;
	}

	public Integer getYear(String year) {
		Integer y = null;
		if (year == null) {
			y = null;
		} else {

			String yer[] = year.split("-");
			y = Integer.parseInt(yer[0]);
		}

		return y;
	}

	public String checkforAlternateName(String name, List<AlternateName> alternateNameList) {
		flg = true;

		finalName = "";
		if (name.contains("-")) {
			name = name.replace("-", " ");
		}
		String namecheck[] = name.split(" ");
		for (String chck : namecheck) {

			flg = true;

			// flg = alternateNameRepository.existsByNameDescription(chck);
			// flg = alternateNameList.stream().anyMatch(c->
			// c.getNameDescription().equals(chck));
			for (AlternateName c : alternateNameList) {

				if (c.getNameDescription().toLowerCase().equals(chck.toLowerCase())) {
					flg = false;
					break;
				}

			}
			if (flg == true) {
				finalName += chck;
				finalName += " ";
			}
		}
		if (finalName != "") {
			finalName = finalName.substring(0, finalName.length() - 1);
		}

		return finalName;
	}

	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
		Set<Object> seen = ConcurrentHashMap.newKeySet();
		//return t -> seen.add(keyExtractor.apply(t));
		return t -> {
	        Object cName = keyExtractor.apply(t);
	        if(cName == null)
	            return false;
	        return seen.add(cName);
	    };
		
	}
	
	public String getServiceResponse() {
		fetchedvalue = fetchValue("Hcode", "30");
		return fetchedvalue;
	}
	
	public String fetchValue(String code, String defaultvalue) {
		value = staticConfigurationRepository.findByCode(code);
		if (value != null) {
			return value;
		} else {
			return defaultvalue;
		}
	}
	
	

	
}

package risknucleus.aml.watchlist.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import info.debatty.java.stringsimilarity.*;

import org.apache.commons.codec.language.Metaphone;
import org.simmetrics.metrics.BlockDistance;
import org.simmetrics.metrics.OverlapCoefficient;
import org.simmetrics.metrics.StringMetrics;
import org.springframework.stereotype.Service;

import com.github.wslf.levenshteindistance.LevenshteinCalculator;

import risknucleus.aml.watchlist.model.CustomerWatchlistPOJO;
import risknucleus.aml.watchlist.model.Customer_customernew;
import risknucleus.aml.watchlist.model.WatchlistListNew;

public class FunctionsService {

//	 List<CustomerWatchlistPOJO> listPojo = new ArrayList<CustomerWatchlistPOJO>();
//	 CustomerWatchlistPOJO watchlistPojo = new CustomerWatchlistPOJO();

	// length
	public int LEN(String s) {
		int i = s.length();
		return i;
	}

	// strip character
	private String stripChar(String val, String exp, String replace) {
		if (checkValidString(val))
			return val.replaceAll(exp, replace);
		else
			return null;
	}

	private boolean checkValidString(String str) {
		return ((str == "" || str == null) ? false : true);
	}

//	 public List<CustomerWatchlistPOJO> getLENGTH(Field cus, Field watch, String operator, int input, List<WatchlistListNew> listnew, List<Customer_customernew> customerlist) throws IllegalArgumentException, IllegalAccessException{
//		
//		 if(cus!= null) {
//			for(Customer_customernew customer: customerlist) {
//				if(operator.equals("ET")) {
//					int s = cus.get(customer).toString().length() > input ? 1:0;
//					if(s == 0) {
//						customerlist.remove(customer);
//					}
//				}
//			}
//		 }
//		 if(watch != null) {
//			 
//		 }
//		 
//		 return listPojo;
//		 
//	 }

	// metaphone
	private String getMetaPhone(String str) {
		if (str == null)
			return null;

		Metaphone objMeta = new Metaphone();
		String ret = objMeta.encode(str);

		return ret.trim();
	}

	// word count

	public int wordcount(String string) {
		int count = 0;

		char ch[] = new char[string.length()];
		for (int i = 0; i < string.length(); i++) {
			ch[i] = string.charAt(i);
			if (((i > 0) && (ch[i] != ' ') && (ch[i - 1] == ' ')) || ((ch[0] != ' ') && (i == 0)))
				count++;
		}
		return count;
	}

	// LevenshteinDistance
	public double LevenshteinDistance(String x, String y) {
		Levenshtein l = new Levenshtein();
		return l.distance(x, y);
	}

	// upper case

	public String toUppercase(String str) {
		return str.toUpperCase();
	}

	// JaroWinkler

	public double jaroDistance(String s1, String s2) {
		JaroWinkler w = new JaroWinkler();

		return w.distance(s1, s2);
	}

	// split Match Algo
	public Double splitMatchAlgo(String String1, String String2) {
		String[] Values1 = null, Values2 = null;
		Double Score = 0.0;

		if (String1.contains("|")) {
			Values1 = String1.trim().split("\\|");
		}
		if (String2.contains("|")) {
			Values2 = String2.trim().split("\\|");
		}

		if (String1.contains("|") && String2.contains("|")) {
			for (String str : Values1) {
				for (String strinner : Values2) {
					if ((strinner.equals(str))) {
						return (double) 1;
					}

				}
			}
		} else if (String1.contains("|") && !(String2.contains("|"))) {
			for (String str : Values1) {
				if (str.equals(String2)) {
					return (double) 1;
				}

			}

		}

		else if (!(String1.contains("|")) && String2.contains("|")) {
			for (String strinner : Values2) {
				if (strinner.equals(String1)) {
					return (double) 1;
				}
			}
		} else if (!(String1.contains("|")) && !(String2.contains("|"))) {
			if (String1.equals(String2)) {
				return (double) 1;
			}

		}
		return Score;
	}

	// OverlapCoefficient

	public double OverlapCoefficientF(String str1, String str2) {

		return StringMetrics.overlapCoefficient().compare(str1.toLowerCase(), str2.toLowerCase());

	}

	//
	public final double BlockDistanceF(String str1, String str2) {
		return StringMetrics.blockDistance().compare(str1.toLowerCase(), str2.toLowerCase());
	}

	// smallwordbreakupAlgoLEV

	public double SmallWordBreakupAlgoLEV(String Bigword, String SmallWord) {

		int wcB = wordcount(Bigword);
		int wcS = wordcount(SmallWord);

		String swap = "";
		if (wcB > wcS) {
			swap = Bigword;
			Bigword = SmallWord;
			SmallWord = swap;
		}
		Levenshtein ObjLev = new Levenshtein();

		// Levenstein ObjLev = new Levenstein();

		String[] valuesBig = Bigword.split(" ");
		String[] valuesSmall = SmallWord.split(" ");
		double sscore = 0;

		double[][] score = new double[valuesBig.length][valuesSmall.length];
		double[][] maxscore = new double[valuesBig.length][valuesSmall.length];
		double[][] maxmax = new double[valuesBig.length][valuesSmall.length];

		for (int i = 0; i < valuesBig.length; i++) {
			double maxHelp = 0;
			for (int j = 0; j < valuesSmall.length; j++) {
				sscore = score[i][j] = ObjLev.similarity(valuesBig[i], valuesSmall[j]);
				// sscore = score[i, j] = objJaroWinkler.GetSimilarity(valuesBig[i],
				// valuesSmall[j]);

				maxHelp = (maxHelp > sscore ? maxHelp : sscore);
			}
			for (int j = 0; j < valuesSmall.length; j++) {
				maxscore[i][j] = maxHelp;
			}
		}
		for (int j = 0; j < valuesSmall.length; j++) {
			double maxmaxHelp = 0;
			for (int i = 0; i < valuesBig.length; i++) {
				maxmaxHelp = (maxmaxHelp > maxscore[i][j] ? maxmaxHelp : maxscore[i][j]);
			}
			for (int i = 0; i < valuesBig.length; i++) {
				if (maxscore[i][j] != score[i][j]) {
					maxmax[i][j] = -1;
				} else if ((maxmaxHelp > maxscore[i][j])) {
					maxmax[i][j] = 0;
				} else {
					maxmax[i][j] = maxmaxHelp;
				}

			}
		}
		double total = 0;
		for (int i = 0; i < valuesBig.length; i++) {
			double MaxHelp = 0;

			for (int j = 0; j < valuesSmall.length; j++) {
				if (maxmax[i][j] != -1) {
					MaxHelp = (MaxHelp > maxmax[i][j] ? MaxHelp : maxmax[i][j]);
				}
			}
			total += MaxHelp;
		}
		double avg = total / valuesBig.length;
		return avg;
	}

	// LargeWordBreakupAlgoLEV
	public double LargeWordBreakupAlgoLEV(String Bigword, String SmallWord) {

		Levenshtein ObjLev = new Levenshtein();
		// Levenstein ObjLev = new Levenstein();
		// JaroWinkler objJaroWinkler = new JaroWinkler();
		int wcB = wordcount(Bigword);
		int wcS = wordcount(SmallWord);

		String swap = "";
		if (wcB < wcS) {
			swap = Bigword;
			Bigword = SmallWord;
			SmallWord = swap;
		}

		String[] valuesBig = Bigword.split(" ");
		String[] valuesSmall = SmallWord.split(" ");
		double sscore = 0;

		double[][] score = new double[valuesBig.length][valuesSmall.length];
		double[][] maxscore = new double[valuesBig.length][valuesSmall.length];
		double[][] maxmax = new double[valuesBig.length][valuesSmall.length];

		for (int i = 0; i < valuesBig.length; i++) {
			double maxHelp = 0;
			for (int j = 0; j < valuesSmall.length; j++) {
				sscore = score[i][j] = ObjLev.similarity(valuesBig[i], valuesSmall[j]);
				// sscore = score[i, j] = objJaroWinkler.GetSimilarity(valuesBig[i],
				// valuesSmall[j]);

				maxHelp = (maxHelp > sscore ? maxHelp : sscore);
			}
			for (int j = 0; j < valuesSmall.length; j++) {
				maxscore[i][j] = maxHelp;
			}
		}
		for (int j = 0; j < valuesSmall.length; j++) {
			double maxmaxHelp = 0;
			for (int i = 0; i < valuesBig.length; i++) {
				maxmaxHelp = (maxmaxHelp > maxscore[i][j] ? maxmaxHelp : maxscore[i][j]);
			}
			for (int i = 0; i < valuesBig.length; i++) {
				if (maxscore[i][j] != score[i][j]) {
					maxmax[i][j] = -1;
				} else if ((maxmaxHelp > maxscore[i][j])) {
					maxmax[i][j] = 0;
				} else {
					maxmax[i][j] = maxmaxHelp;
				}

			}
		}
		double total = 0;
		for (int i = 0; i < valuesBig.length; i++) {
			double MaxHelp = 0;

			for (int j = 0; j < valuesSmall.length; j++) {
				if (maxmax[i][j] != -1) {
					MaxHelp = (MaxHelp > maxmax[i][j] ? MaxHelp : maxmax[i][j]);
				}
			}
			total += MaxHelp;
		}
		double avg = total / valuesBig.length;
		return avg;
	}
//larger word break up algo

	public double LargeWordBreakupAlgo(String Bigword, String SmallWord) {
		JaroWinkler objJaroWinkler = new JaroWinkler();
		// JaroWinkler objJaroWinkler = new JaroWinkler();

		int wcB = wordcount(Bigword);
		int wcS = wordcount(SmallWord);

		String swap = "";
		if (wcB < wcS) {
			swap = Bigword;
			Bigword = SmallWord;
			SmallWord = swap;
		}

		String[] valuesBig = Bigword.split(" ");
		String[] valuesSmall = SmallWord.split(" ");
		double sscore = 0;

		double[][] score = new double[valuesBig.length][valuesSmall.length];
		double[][] maxscore = new double[valuesBig.length][valuesSmall.length];
		double[][] maxmax = new double[valuesBig.length][valuesSmall.length];

		for (int i = 0; i < valuesBig.length; i++) {
			double maxHelp = 0;
			for (int j = 0; j < valuesSmall.length; j++) {
				sscore = score[i][j] = objJaroWinkler.similarity(valuesBig[i], valuesSmall[j]);
				// sscore = score[i, j] = objJaroWinkler.GetSimilarity(valuesBig[i],
				// valuesSmall[j]);

				maxHelp = (maxHelp > sscore ? maxHelp : sscore);
			}
			for (int j = 0; j < valuesSmall.length; j++) {
				maxscore[i][j] = maxHelp;
			}
		}
		for (int j = 0; j < valuesSmall.length; j++) {
			double maxmaxHelp = 0;
			for (int i = 0; i < valuesBig.length; i++) {
				maxmaxHelp = (maxmaxHelp > maxscore[i][j] ? maxmaxHelp : maxscore[i][j]);
			}
			for (int i = 0; i < valuesBig.length; i++) {
				if (maxscore[i][j] != score[i][j]) {
					maxmax[i][j] = -1;
				} else if ((maxmaxHelp > maxscore[i][j])) {
					maxmax[i][j] = 0;
				} else {
					maxmax[i][j] = maxmaxHelp;
				}

			}
		}
		double total = 0;
		for (int i = 0; i < valuesBig.length; i++) {
			double MaxHelp = 0;

			for (int j = 0; j < valuesSmall.length; j++) {
				if (maxmax[i][j] != -1) {
					MaxHelp = (MaxHelp > maxmax[i][j] ? MaxHelp : maxmax[i][j]);
				}
			}
			total += MaxHelp;
		}
		double avg = total / valuesBig.length;
		return avg;

	}

	// Matching the Smaller word with smaller one.
	public double SmallWordBreakupAlgo(String Bigword, String SmallWord) {
		int wcB = wordcount(Bigword);
		int wcS = wordcount(SmallWord);

		String swap = "";
		if (wcB > wcS) {
			swap = Bigword;
			Bigword = SmallWord;
			SmallWord = swap;
		}

		// BlockDistance ObjBD = new BlockDistance();
		JaroWinkler objJaroWinkler = new JaroWinkler();

		String[] valuesBig = Bigword.split(" ");
		String[] valuesSmall = SmallWord.split(" ");
		double sscore = 0;

		double[][] score = new double[valuesBig.length][valuesSmall.length];
		double[][] maxscore = new double[valuesBig.length][valuesSmall.length];
		double[][] maxmax = new double[valuesBig.length][valuesSmall.length];

		for (int i = 0; i < valuesBig.length; i++) {
			double maxHelp = 0;
			for (int j = 0; j < valuesSmall.length; j++) {
				sscore = score[i][j] = objJaroWinkler.similarity(valuesBig[i], valuesSmall[j]);
				// sscore = score[i, j] = objJaroWinkler.GetSimilarity(valuesBig[i],
				// valuesSmall[j]);

				maxHelp = (maxHelp > sscore ? maxHelp : sscore);
			}
			for (int j = 0; j < valuesSmall.length; j++) {
				maxscore[i][j] = maxHelp;
			}
		}
		for (int j = 0; j < valuesSmall.length; j++) {
			double maxmaxHelp = 0;
			for (int i = 0; i < valuesBig.length; i++) {
				maxmaxHelp = (maxmaxHelp > maxscore[i][j] ? maxmaxHelp : maxscore[i][j]);
			}
			for (int i = 0; i < valuesBig.length; i++) {
				if (maxscore[i][j] != score[i][j]) {
					maxmax[i][j] = -1;
				} else if ((maxmaxHelp > maxscore[i][j])) {
					maxmax[i][j] = 0;
				} else {
					maxmax[i][j] = maxmaxHelp;
				}

			}
		}
		double total = 0;
		for (int i = 0; i < valuesBig.length; i++) {
			double MaxHelp = 0;

			for (int j = 0; j < valuesSmall.length; j++) {
				if (maxmax[i][j] != -1) {
					MaxHelp = (MaxHelp > maxmax[i][j] ? MaxHelp : maxmax[i][j]);
				}
			}
			total += MaxHelp;
		}
		double avg = total / valuesBig.length;
		return avg;
	}

	// Year Match

	public final double YearMatch(int input1, int input2, int input3) {
		return (Math.abs(input1 - input2) <= input3 ? 1 : 0);
	}

	// smaller word breakup db

	public double SmallWordBreakupAlgoDB(String Bigword, String SmallWord) {
		int wcB = wordcount(Bigword);
		int wcS = wordcount(SmallWord);

		String swap = "";
		if (wcB > wcS) {
			swap = Bigword;
			Bigword = SmallWord;
			SmallWord = swap;
		}

		// BlockDistance ObjBD = new BlockDistance();
		// JaroWinkler objJaroWinkler = new JaroWinkler();

		String[] valuesBig = Bigword.split(" ");
		String[] valuesSmall = SmallWord.split(" ");
		double sscore = 0;

		double[][] score = new double[valuesBig.length][valuesSmall.length];
		double[][] maxscore = new double[valuesBig.length][valuesSmall.length];
		double[][] maxmax = new double[valuesBig.length][valuesSmall.length];

		for (int i = 0; i < valuesBig.length; i++) {
			double maxHelp = 0;
			for (int j = 0; j < valuesSmall.length; j++) {
				sscore = score[i][j] = StringMetrics.blockDistance().compare(valuesBig[i], valuesSmall[j]);
				// sscore = score[i, j] = objJaroWinkler.GetSimilarity(valuesBig[i],
				// valuesSmall[j]);

				maxHelp = (maxHelp > sscore ? maxHelp : sscore);
			}
			for (int j = 0; j < valuesSmall.length; j++) {
				maxscore[i][j] = maxHelp;
			}
		}
		for (int j = 0; j < valuesSmall.length; j++) {
			double maxmaxHelp = 0;
			for (int i = 0; i < valuesBig.length; i++) {
				maxmaxHelp = (maxmaxHelp > maxscore[i][j] ? maxmaxHelp : maxscore[i][j]);
			}
			for (int i = 0; i < valuesBig.length; i++) {
				if (maxscore[i][j] != score[i][j]) {
					maxmax[i][j] = -1;
				} else if ((maxmaxHelp > maxscore[i][j])) {
					maxmax[i][j] = 0;
				} else {
					maxmax[i][j] = maxmaxHelp;
				}

			}
		}
		double total = 0;
		for (int i = 0; i < valuesBig.length; i++) {
			double MaxHelp = 0;

			for (int j = 0; j < valuesSmall.length; j++) {
				if (maxmax[i][j] != -1) {
					MaxHelp = (MaxHelp > maxmax[i][j] ? MaxHelp : maxmax[i][j]);
				}
			}
			total += MaxHelp;
		}
		double avg = total / valuesBig.length;
		return avg;
	}

	// larger word breakup algo DB
	public final double LargeWordBreakupAlgoBD(String Bigword, String SmallWord) {

		// BlockDistance ObjBD = new BlockDistance();
		// JaroWinkler objJaroWinkler = new JaroWinkler();

		int wcB = wordcount(Bigword);
		int wcS = wordcount(SmallWord);

		String swap = "";
		if (wcB < wcS) {
			swap = Bigword;
			Bigword = SmallWord;
			SmallWord = swap;
		}

		String[] valuesBig = Bigword.split(" ");
		String[] valuesSmall = SmallWord.split(" ");
		double sscore = 0;

		double[][] score = new double[valuesBig.length][valuesSmall.length];
		double[][] maxscore = new double[valuesBig.length][valuesSmall.length];
		double[][] maxmax = new double[valuesBig.length][valuesSmall.length];

		for (int i = 0; i < valuesBig.length; i++) {
			double maxHelp = 0;
			for (int j = 0; j < valuesSmall.length; j++) {
				sscore = score[i][j] = StringMetrics.blockDistance().compare(valuesBig[i], valuesSmall[j]);
				// sscore = score[i, j] = objJaroWinkler.GetSimilarity(valuesBig[i],
				// valuesSmall[j]);

				maxHelp = (maxHelp > sscore ? maxHelp : sscore);
			}
			for (int j = 0; j < valuesSmall.length; j++) {
				maxscore[i][j] = maxHelp;
			}
		}
		for (int j = 0; j < valuesSmall.length; j++) {
			double maxmaxHelp = 0;
			for (int i = 0; i < valuesBig.length; i++) {
				maxmaxHelp = (maxmaxHelp > maxscore[i][j] ? maxmaxHelp : maxscore[i][j]);
			}
			for (int i = 0; i < valuesBig.length; i++) {
				if (maxscore[i][j] != score[i][j]) {
					maxmax[i][j] = -1;
				} else if ((maxmaxHelp > maxscore[i][j])) {
					maxmax[i][j] = 0;
				} else {
					maxmax[i][j] = maxmaxHelp;
				}

			}
		}
		double total = 0;
		for (int i = 0; i < valuesBig.length; i++) {
			double MaxHelp = 0;

			for (int j = 0; j < valuesSmall.length; j++) {
				if (maxmax[i][j] != -1) {
					MaxHelp = (MaxHelp > maxmax[i][j] ? MaxHelp : maxmax[i][j]);
				}
			}
			total += MaxHelp;
		}
		double avg = total / valuesBig.length;
		return avg;
	}

	// LTRIM
	public static String ltrim(String value) {
		// Remove leading spaces.
		return value.replaceFirst("^\\s+", "");
	}
//		 		 public String ltrim(String s)
//		 	    {int i=0;
//		 	    String ltrim="";
//		 	        for(i=0;i<s.length();i++)
//		 	        {
//		 	            char ch=s.charAt(i);
//		 	            if(ch!=' ')
//		 	            break;
//		 	        }
//		 	        for(int j=i;j<s.length();j++)
//		 	        {	ltrim+= s.charAt(j);}
//		 	       return ltrim;
//		 	    }
//		 		 

	// RTRIM
	public static String rtrim(String value) {
		// Use replaceFirst to remove trailing spaces.
		return value.replaceFirst("\\s+$", "");
	}
}

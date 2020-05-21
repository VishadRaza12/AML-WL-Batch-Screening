package risknucleus.aml.watchlist.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.apache.commons.codec.language.Metaphone;
import org.apache.commons.codec.language.Soundex;
import org.springframework.stereotype.Service;

import risknucleus.aml.watchlist.bean.Input;
import risknucleus.aml.watchlist.model.AlternateName;
import risknucleus.aml.watchlist.model.WatchlistListNew;





@Service
public class WatchlistService {
	List<AlternateName> objAlternateName = new ArrayList<AlternateName>();

	public WatchlistListNew getWatchListObject(Input objInput) {
		WatchlistListNew objWl = new WatchlistListNew();
		if(!objInput.getName().equals("") && !(objInput.getName()==null) && !objInput.getName().isEmpty()) {
		String fullName = removeDuplicateValuWithDelimator(
				stripChar(objInput.getName().toUpperCase(), "[^a-zA-Z0-9_А-Яأ-يа-я ]", " "), " ");
		String fullNameSW = replaceStopWords(fullName);

		objWl.setEntityType(objInput.getEntityType());
		objWl.setActualName(fullName);
		objWl.setFullName(fullName);
		objWl.setFullNameMeta(getMetaPhonewithSplitString(fullName, " "));
		objWl.setFullNameSansSW(fullNameSW);
		objWl.setFullNameMetaSansSW(getMetaPhonewithSplitString(fullNameSW, " "));
       
		objWl.setCountryToken(objInput.getCountry().toUpperCase());
      
		objWl.setIDRegDOc(stripChar(objInput.getName().toUpperCase(), "[^0-9]", ""));
          
		if (objInput.getDateOfBirth() != null) {
			Calendar objCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
			objCal.setTime(objInput.getDateOfBirth());
			objWl.setYearOfBirth(objCal.get(Calendar.YEAR));
		}

		// Translation & Language Detect if any will go there ()

		objWl.setFullNameSound(getSoundex(fullName));
		objWl.setFullNameSoundSansSw(getSoundex(fullNameSW));
		objWl.setListType(objInput.getListType());
		objWl.setIDRegDOc(objInput.getIdentity());

		}
		return objWl;

	}

	private String getSoundex(String str) {
		Soundex objSound = new Soundex();
		str = stripChar(str, "[^bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ ]", "");
		String[] words = null;
		String ret = "";

		if (!(str == null)) {
			if (str.contains(" ")) {
				words = str.split(" ");
				for (int i = 0; i < words.length; i++) {
					ret += objSound.soundex(words[i].trim()) + " ";
				}
			} else {
				ret = objSound.soundex(str.trim());
			}
		}

		return ret;
	}
	private String stripChar(String val, String exp, String replace) {
		if (checkValidString(val))
			return val.replaceAll(exp, replace);
		else
			return null;
	}
	private boolean checkValidString(String str) {
		return ((str == "" || str == null) ? false : true);
	}

	private String replaceStopWords(String str) {
		if (str == null)
			return null;

		String[] words = str.split(" ");
		
		for (int i = 0; i < words.length; i++) {
			for (AlternateName objAlt : objAlternateName) {
				if (objAlt.getNameDescription().equals(words[i]))
					words[i] = "";
			}
		}
		str = "";
		for (int i = 0; i < words.length; i++) {
			if (!words[i].equals(""))
				str += words[i] + " ";
		}
		

		return str.trim();
	}
	private String getMetaPhonewithSplitString(String str, String del) {
		if (str == null)
			return null;
		String[] words = str.split(del);

		Metaphone objMeta = new Metaphone();

		String ret = "";

		for (int i = 0; i < words.length; i++) {
			ret += objMeta.metaphone(words[i]) + " ";
		}

		return ret.trim();
	}

	private String removeDuplicateValuWithDelimator(String val, String del) {
		if (val == null)
			return null;
		String[] words = val.split(del);
		for (int i = 0; i < words.length; i++) {
			words[i] = words[i].trim();
		}
		for (int i = 0; i < words.length; i++) {
			for (int j = i + 1; j < words.length; j++) {
				if (words[i].equals(words[j]))
					words[i] = "";
			}
		}
		String ret = "";
		for (int i = 0; i < words.length; i++) {
				ret += words[i] + " ";
		}
		return ret.trim();
	}
}

package cken;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class ConvertToMap {
	public static Ultils ultils = new Ultils();

	// map to json
	public HashMap<String, String> convertStringSourceToMap(final String fileName) {

		final String SPLIT = ";";
		final String SEPR_STRING = " ";
		final HashMap<String, String> result = new LinkedHashMap<>();

		final List<String> listStr = ultils.readFileToList(SPLIT, fileName);
		String lastString = null;

		for (final String str : listStr) {
			String typeString = new String(str);
			lastString = str.substring(str.lastIndexOf(SEPR_STRING) + 1);

			typeString = typeString.substring(0, typeString.lastIndexOf(SEPR_STRING));
			typeString = typeString.substring(typeString.lastIndexOf(SEPR_STRING) + 1);

			result.put(StringUtils.deleteWhitespace(lastString), StringUtils.deleteWhitespace(typeString));
		}
		return result;
	}

	public HashMap<String, String> convertStringFileDBToMap() {

		final String SPLIT = "\n";
		// final String SEPR_STRING = " ";
		final String SEPR_STRING = "\t";

		final HashMap<String, String> result = new LinkedHashMap<>();

		final List<String> listStr = ultils.readFileToList(SPLIT, "E:\\f.txt");

		String lastString = null;

		for (final String str : listStr) {
			String str2 = new String(str);
			lastString = str.substring(str.lastIndexOf(SEPR_STRING) + 1);

			str2 = str2.substring(0, str2.lastIndexOf(SEPR_STRING));

			result.put(StringUtils.deleteWhitespace(str2), StringUtils.deleteWhitespace(lastString));
		}
		return result;
	}

}

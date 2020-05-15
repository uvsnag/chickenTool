package cken;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class ConvertToList {
	public static Ultils ultils = new Ultils();

	public List<String> convertStringSourceToList(final String dir) {
		final String SPLIT = ";";
		final String SEPR_STRING = " ";

		final List<String> result = new ArrayList<>();
		final List<String> listStr = ultils.readFileToList(SPLIT, dir);

		String lastString = null;

		for (final String str : listStr) {

			lastString = str.substring(str.lastIndexOf(SEPR_STRING) + 1);

			result.add(StringUtils.deleteWhitespace(lastString));
		}
		return result;
	}
}

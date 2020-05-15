package cken;

import java.util.HashMap;
import java.util.List;

public class ConvertToJson {

	public void maptToJson(final HashMap<String, String> map) {

		String strResult = "{\n";

		// String STRING = "\"" + "\"";
		final String STRING = "\"" + "2\"";
		final String INTEGER = "0";
		final String LONG = "22";
		final String DATE = "\"2019/02/02\"";
		final String BOOLEAN = "true";
		final String END_LINE = "," + "\n";

		// final String DEFAULT = "\"" + "\"";
		final String DEFAULT = "\"" + "1\"";

		for (final String key : map.keySet()) {
			strResult += "   " + "\"" + key + "\":";

			// STRING = "\"" + key + "\"";

			switch (map.get(key)) {

			case "VARCHAR2":
				strResult += STRING + END_LINE;
				break;
			case "NUMBER":
				strResult += INTEGER + END_LINE;
				break;
			case "CHAR":
				strResult += STRING + END_LINE;
				break;
			case "VARCHAR3":
				strResult += STRING + END_LINE;
				break;
			// ---------------------------------
			case "Long":
				strResult += LONG + END_LINE;
				break;
			case "Integer":
				strResult += INTEGER + END_LINE;
				break;
			case "LocalDate":
				strResult += DATE + END_LINE;
				break;
			case "Boolean":
				strResult += BOOLEAN + END_LINE;
				break;
			case "String":
				strResult += STRING + END_LINE;
				break;
			default:
				strResult += DEFAULT + END_LINE;
				break;
			}
		}
		strResult = strResult.substring(0, strResult.length() - 2);
		strResult += "\n}\n";

		// System.out.println("total:" + total);
		// System.out.println("size:" + map.size() + "\n");

		System.out.println(strResult);
	}

	public void listToJson(final List<String> list) {
		System.out.println("==================================================" + "\n" + "\n");

		String strResult = "{\n";
		for (int i = 0; i < list.size() - 1; i++) {
			final String str = list.get(i);
			strResult += "   " + "\"" + str + "\":" + "\"\"," + "\n";
		}
		strResult += "   " + "\"" + list.get(list.size() - 1) + "\":" + "\"\"" + "\n";
		strResult += "}\n";

		System.out.println(strResult);
	}
}

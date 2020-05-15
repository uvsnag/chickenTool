package cken;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

/**
 * @author sangnv
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		final String[] arrOne = { "pipTel", "npKbn", "nttMoveKbn", "npTelArea", "npTelCity", "npTelLocal",
				"npApplyKbnName", "npApplyKbnNameCon", "nttNameKana", "nttName", "notifyDispKbn", "telInfoKbn",
				"helloPageKbn", "catchPhoneKbn", "numDisplayKbn", "catchNumDispKbn", "numRequestKbn", "repulseKbn",
				"forwardKbn", "auReceiptKbn", "auTelNo1", "auTelNo2", "auTelNo3", "fileMakeYmd", "offerStartYmd",
				"errYmd", "concludeYmd", "billStartYmd", "cancelActionYmd", "cancelYmd", "stopStartYmd", "stopEndYmd",
				"campaignYmd", "billinputNo", "billaddNo", "billAddress", "townPageKbn", "townPagePublishedName",
				"townPagePublishedNameKana", "townPageDuplicateName", "townPageDuplicateNameKana", "checkApplied",
				"npThirdKbn", "precarrierCd", "precarrierName", "precarrierTelServiceName", "npConYmd", "npSamedayKbn",
				"npConWantYmd", "npConWantTime", "phoneDetailKbn", "constSafetyPackKbn", "jigCustomerNo", "deleteYmd",
				"moveTel", "tiedTel", "tiedLineKbn", "tiedLineKbnName", "applyStatus", "applyStatusName", "cmMac",
				"serialNoEmta", "serialNoHgw", "seqNo", "basicServContractNo", "applyName" };

		final String[] arrTwo = { "seqNo", "kddiUserCd", "stationCd", "stationCdName", "methodTransmitKddi",
				"methodTransmitKddiName", "lastName", "firstName", "lastNameKana", "firstNameKana", "zipCd", "houseNo",
				"apartmentName", "tel1Area", "tel1City", "tel1Local", "tel2Area", "tel2City", "tel2Local", "sendKbn",
				"sendKbnName", "extraCd", "extZipCd", "extAddress", "buildingName", "chargeNameKana", "chargeName",
				"moveYmd", "sendTelArea", "sendTelCity", "sendTelLocal", "sourceSeqNo", "targetSeqNo", "lineChangeYmd",
				"catvCustomerNo", "hinmokuCd", "hinmokuName" };

		// final List<String> listOne = Arrays.asList(arrOne);
		// final List<String> listTwo = Arrays.asList(arrTwo);
		// final List<String> listOne = convertStringSourceToList("D:\\1.txt");
		// final List<String> listTwo = convertStringSourceToList("D:\\1.txt");

		// showItemList(listFromStringSource);

		// System.out.println("listOne.size():" + listOne.size());
		// System.out.println("listTwo.size():" + listTwo.size());

		// compare list
		// compareItemOrderInList(listOne, listTwo);
		// checkListContainsAnotherList(listOne, listTwo);

		// final List<String> listFromStringSource =
		// convertStringSourceToList("E:\\f.txt");
		// listToJson(listFromStringSource);

		// maptToJson(convertStringSourceToMap("D:\\1.txt"));
		// maptToJson(convertStringFileDBToMap());

		// checkIntLong();

		convertSQLToSourceSQL("D:\\1.txt");

	}

	static void checkIntLong() {
		final String notTake = "#";
		final String spilit = "\n";
		int i = 0;
		// get list
		final List<String> listTableColu = readFileToList("#", "E:\\1.txt");
		final Set<String> setListColu = new HashSet<>();
		String str2 = "";
		// showItemList(listTableColu);

		for (String str : listTableColu) {

			if (!str.isEmpty()) {
				str = notTake + str;

				while (str.length() > 0) {
					i++;
					str = str.trim();
					try {

						if (!str.contains(spilit)) {
							str2 = str;
							str = "";
							continue;
						}
						str2 = str.substring(0, str.indexOf(spilit));
						str = str.substring(str.indexOf(spilit));
					} catch (final Exception e) {
						System.out.println("exception ");
						e.fillInStackTrace();
						throw e;

					}

					if (!str2.startsWith(notTake) && !str2.trim().isEmpty()) {
						setListColu.add(str2.trim());
					}
				}
			}
		}
		final List<String> listColu = new ArrayList<>(setListColu);
		//
		i = 0;
		for (final String strColu : listColu) {

			final List<String> listResult = new ArrayList<>();
			for (final String strTableColu : listTableColu) {
				if (strTableColu.contains(strColu)) {
					listResult.add(strTableColu.substring(0, strTableColu.indexOf(spilit)).trim());
				}
			}
			System.out.println("# " + i + " - size: " + listResult.size() + " -     " + strColu);

			// for (final String item : listResult) {
			for (int j = 0; j < listResult.size(); j++) {
				final String item = listResult.get(j);
				if (listResult.size() <= 1) {
					System.out.println("> " + item);
				} else {
					System.out.println("> " + (j + 1) + ": " + item);
				}

			}
			System.out.println("\n ====================================");

			// showItemList(listResult);
			i++;
		}

	}

	static void showItemList(final List<String> list) {
		System.out.println("list.size(): " + list.size());
		System.out.println("---------------------------");
		for (final String item : list) {
			System.out.println(">" + item);
		}
		System.out.println("====================================");

	}

	static void compareItemOrderInList(final List<String> listOne, final List<String> listTwo) {

		System.out.println("===================== compareItemOrderInList =====================");
		for (int i = 0; i < listOne.size(); i++) {
			try {
				if (!listOne.get(i).trim().equals(listTwo.get(i).trim())) {
					System.out.println("i=:" + i);
					System.out.println("listOne--listTwo: " + listOne.get(i) + " -- " + listTwo.get(i));
					System.out.println("---------------------------");
				}
			} catch (final Exception e) {
				System.out.println(">>>> only listOne: " + listOne.get(i));
			}
		}

		for (int i = 0; i < listTwo.size(); i++) {
			try {
				if (!listTwo.get(i).trim().equals(listOne.get(i).trim())) {
				}
			} catch (final Exception e) {
				System.out.println(">>>> only listTwo: " + listTwo.get(i));
			}
		}
	}

	static void checkListContainsAnotherList(final List<String> listOne, final List<String> listTwo) {
		System.out.println("================= checkListContainsAnotherList =========================");
		System.out.println("listTwo not contain item in listOne:" + "\n");
		for (final String str : listOne) {
			if (!listTwo.contains(str)) {
				System.out.println(">:" + str);
			}
		}
		System.out.println("---------------------------");
		System.out.println("listOne not contain item in listTwo:" + "\n");
		for (final String str : listTwo) {
			if (!listOne.contains(str)) {
				System.out.println(">:" + str);
			}
		}
	}

	static void convertSQLToSourceSQL(final String dir) {
		final String SPLIT = "\n";
		final List<String> listStr = readFileToList(SPLIT, dir);

		for (final String str : listStr) {
			if (StringUtils.isNotBlank(str)) {
				System.out.println("sqlBuf.append(\" " + str.trim() + " \");");
			}
		}
	}

	static List<String> convertStringSourceToList(final String dir) {
		final String SPLIT = ";";
		final String SEPR_STRING = " ";

		final List<String> result = new ArrayList<>();
		final List<String> listStr = readFileToList(SPLIT, dir);

		String lastString = null;

		for (final String str : listStr) {

			lastString = str.substring(str.lastIndexOf(SEPR_STRING) + 1);

			result.add(StringUtils.deleteWhitespace(lastString));
		}
		return result;
	}

	// map to json
	static HashMap<String, String> convertStringSourceToMap(final String fileName) {

		final String SPLIT = ";";
		final String SEPR_STRING = " ";
		final HashMap<String, String> result = new LinkedHashMap<>();

		final List<String> listStr = readFileToList(SPLIT, fileName);
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

	static HashMap<String, String> convertStringFileDBToMap() {

		final String SPLIT = "\n";
		// final String SEPR_STRING = " ";
		final String SEPR_STRING = "\t";

		final HashMap<String, String> result = new LinkedHashMap<>();

		final List<String> listStr = readFileToList(SPLIT, "E:\\f.txt");

		String lastString = null;

		for (final String str : listStr) {
			String str2 = new String(str);
			lastString = str.substring(str.lastIndexOf(SEPR_STRING) + 1);

			str2 = str2.substring(0, str2.lastIndexOf(SEPR_STRING));

			result.put(StringUtils.deleteWhitespace(str2), StringUtils.deleteWhitespace(lastString));
		}
		return result;
	}

	static List<String> readFileToList(final String split, final String dirFile) {
		String strSource = null;
		try {
			strSource = new String(Files.readAllBytes(Paths.get(dirFile)));
		} catch (final IOException e) {
			e.printStackTrace();
		}

		List<String> listStr = new ArrayList<>();
		listStr = new ArrayList<>(Arrays.asList(strSource.split(split)));

		return listStr;
	}

	static void maptToJson(final HashMap<String, String> map) {

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

	static void listToJson(final List<String> list) {
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
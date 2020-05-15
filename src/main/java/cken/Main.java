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

	public static Ultils ultils= new Ultils();
	public static ConvertToSource convertToSource= new ConvertToSource();
	public static CompareList compareList= new CompareList();
	public static ConvertToList convertToList= new ConvertToList();
	public static ConvertToMap convertToMap= new ConvertToMap();
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

		convertToSource.convertSQLToSourceSQL("D:\\1.txt");

	}

	

	static void showItemList(final List<String> list) {
		System.out.println("list.size(): " + list.size());
		System.out.println("---------------------------");
		for (final String item : list) {
			System.out.println(">" + item);
		}
		System.out.println("====================================");

	}


}
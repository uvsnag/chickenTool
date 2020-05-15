package cken;


import java.util.Arrays;
import java.util.List;

/**
 * @author sangnv
 *
 */
public class Main {

	public static final Ultils ultils= new Ultils();
	public static final ConvertToSource convertToSource= new ConvertToSource();
	public static  final CompareList compareList= new CompareList();
	public static  final ConvertToList convertToList= new ConvertToList();
	public static  final ConvertToMap convertToMap= new ConvertToMap();
	public static  final ConvertToJson convertToJson= new ConvertToJson();
	public static  final ExcellUltis excellUltis= new ExcellUltis();
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

//		final List<String> listOne = Arrays.asList(arrOne);
//		final List<String> listTwo = Arrays.asList(arrTwo);
//		final List<String> listOne = convertStringSourceToList("D:\\1.txt");
//		final List<String> listTwo = convertStringSourceToList("D:\\1.txt");

//		showItemList(listTwo);
//
//		System.out.println("listOne.size():" + listOne.size());
//		System.out.println("listTwo.size():" + listTwo.size());
//
//		// compare list
//		compareList.compareItemOrderInList(listOne, listTwo);
//		compareList.checkListContainsAnotherList(listOne, listTwo);
//
//		final List<String> listFromStringSource = convertToList.convertStringSourceToList("E:\\f.txt");
//		convertToJson.listToJson(listFromStringSource);
//
//		convertToJson.maptToJson(convertToMap.convertStringSourceToMap("D:\\1.txt"));
//		convertToJson.maptToJson(convertToMap.convertStringFileDBToMap("D:\\1.txt"));
//
//		excellUltis.checkIntLong();

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
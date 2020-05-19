package cken;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author sangnv
 *
 */
public class Main {

	public static final Ultils ultils = new Ultils();
	public static final ConvertToSource convertToSource = new ConvertToSource();
	public static final CompareList compareList = new CompareList();
	public static final ConvertToList convertToList = new ConvertToList();
	public static final ConvertToMap convertToMap = new ConvertToMap();
	public static final ConvertToJson convertToJson = new ConvertToJson();
	public static final ExcellUltis excellUltis = new ExcellUltis();

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

		final int CONVERT_SOURCE_TO_JSON = 0;
		final int COMPARE_LIST = 1;
		final int SOURCE_TO_SQL = 2;
		final int SQL_TO_SOURCE = 3;
		final int SHOW_LIST = 4;

		/* init var */
		final List<String> listOne = Arrays.asList(arrOne);
		final List<String> listTwo = convertToList.convertStringSourceToList("D:\\1.txt");

		switch (CONVERT_SOURCE_TO_JSON) {
		case CONVERT_SOURCE_TO_JSON:
			final HashMap<String, String> result = convertToMap.convertStringSourceToMap("D:\\1.txt");
			convertToJson.maptToJson(result);
			break;
		case COMPARE_LIST:
			compareList.compareItemOrderInList(listOne, listTwo);
			compareList.checkListContainsAnotherList(listOne, listTwo);
			break;
		case SOURCE_TO_SQL:
			sourceToSql();
			break;
		case SQL_TO_SOURCE:
			convertToSource.convertSQLToSourceSQL("D:\\1.txt");
			break;
		case SHOW_LIST:
			showItemList(listTwo);

			System.out.println("listOne.size():" + listOne.size());
			System.out.println("listTwo.size():" + listTwo.size());
			break;
		default:

		}

	}

	static void sourceToSql() {
		StringBuffer sqlBuf = new StringBuffer();
		sqlBuf.append(" SELECT ");
		sqlBuf.append(" COUNT (TRNMCF.CONTENTS_ID) AS CNT ");
		sqlBuf.append(" FROM ");
		sqlBuf.append("CTT").append(".");
		sqlBuf.append("TRNMCAFEE");
		sqlBuf.append(" TRNMCF ");
		sqlBuf.append(" WHERE ");
		sqlBuf.append(" TRNMCF.DELETE_YMD IS NULL ");
		sqlBuf.append(" AND TRNMCF.INPUT_NO IS NOT NULL ");
		sqlBuf.append(" AND TRNMCF.CONTENTS_ID = :CONTENTS_ID ");

		String sql = sqlBuf.toString();
		System.out.println(sql);
	}

	static void showItemListComment(final List<String> list) {
		System.out.println("list.size(): " + list.size());
		System.out.println("---------------------------");
		for (final String item : list) {
			System.out.println(">" + item);
		}
		System.out.println("====================================");

	}

	static void showItemList(final List<String> list) {
		for (final String item : list) {
			System.out.println(item);
		}
	}

}
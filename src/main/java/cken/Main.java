package cken;

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

	public static final int CONVERT_SOURCE_TO_JSON = 0;
	public static final int COMPARE_LIST = 1;
	public static final int SOURCE_TO_SQL = 2;
	public static final int SQL_TO_SOURCE = 3;
	public static final int SHOW_LIST = 4;
	public static final int CONVERT_FILE_TO_LIST = 5;

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

		/** init var */
//		final List<String> listOne1 = Arrays.asList(arrOne);
//		final List<String> listTwo2 = convertToList.convertStringSourceToList("D:\\1.txt");
		final List<String> listOne = convertToList.convertStringFileToList("D:\\1.txt", "\n");
		final List<String> listTwo = convertToList.convertStringFileToList("D:\\2.txt", "\n");

		/*********/
		switch (COMPARE_LIST) {

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
			showItemList(listOne);
			showItemList(listTwo);

			System.out.println("listOne.size():" + listOne.size());
			System.out.println("listTwo.size():" + listTwo.size());
			break;
		case CONVERT_FILE_TO_LIST:
			break;
		default:

		}

	}

	static void sourceToSql() {
		StringBuilder query = new StringBuilder();

		query.append(" SELECT ");
		query.append(" COUNT(*) ");
		query.append(" FROM ");
		query.append(" TRNBLDJOINT ");
		query.append(" BJ ");
		query.append(" INNER JOIN ");
		query.append(" TRNCONTRACT ");
		query.append(" TC ");
		query.append(" ON TC.BLD_JOINT_NO = BJ.BLD_JOINT_NO ");
		query.append(" AND TC.DELETE_YMD IS NULL ");
		query.append(" AND TC.CONTRACT_CD = '2' ");
		query.append(" INNER JOIN ");
		query.append(" MSTCNTCLASSSERVICE ");
		query.append(" MCCS ");
		query.append(" ON MCCS.CNT_CLASS_CD = TC.CNT_CLASS_CD ");
		query.append(" AND MCCS.DELETE_YMD IS NULL ");
		query.append(" INNER JOIN ");
		query.append(" MSTSERVICE ");
		query.append(" MS ");
		query.append(" ON MS.SERVICE_CD = MCCS.SERVICE_CD ");
		query.append(" AND MS.DELETE_YMD IS NULL ");
		query.append(" AND MS.SERVICE_KBN IN ('0', '1') ");
		query.append(" WHERE ");
		query.append(" BJ.DELETE_YMD IS NULL ");
		query.append(" AND EXISTS ( ");
		query.append(" SELECT ");
		query.append(" MDS.SERVICE_CD ");
		query.append(" FROM ");
		query.append(" MSTDEVSERVICE ");
		query.append(" MDS ");
		query.append(" WHERE ");
		query.append(" MDS.DELETE_YMD IS NULL  ");
		query.append(" AND MDS.SERVICE_CD = MCCS.SERVICE_CD  ");
		query.append(" AND MDS.DEV_SBT IN ('4', 'C') )");
		query.append(" AND BJ.INPUT_NO = :INPUT_NO ");
		query.append(" AND MS.SERVICE_CD = :SERVICE_CD ");

		String sql = query.toString();
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
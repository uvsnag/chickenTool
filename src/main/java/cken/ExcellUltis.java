package cken;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcellUltis {

	public static Ultils ultils = new Ultils();

	public static void main(final String[] args) throws IOException {
		// "https://o7planning.org/vi/11259/doc-ghi-file-excel-trong-java-su-dung-apache-poi#a5144240";

//		File file = new File("D:\\excelf\\テーブルレイアウト（第５版）_HIS.xls");
//		File file = new File("D:\\excelf\\テーブルレイアウト（第５版）_MST.xls");
//		File file = new File("D:\\excelf\\テーブルレイアウト（第５版）_TMP.xls");
		File file = new File("D:\\excelf\\テーブルレイアウト（第５版）_TRN.xls");

		FileInputStream inputStream = new FileInputStream(file);
		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
		int rowTable = 3;
		int cellTable = 3;
		int cellCol = 2;
		int cellType = 5;
		int cellSize = 6;
		for (int j = 5; j < workbook.getNumberOfSheets(); j++) {
			HSSFSheet sheet = workbook.getSheetAt(j);
			HSSFCell cell = sheet.getRow(rowTable).getCell(cellTable);
			String table = cell.getStringCellValue();
			if (!table.trim().isEmpty()) {
				boolean flag = true;
				int i = 4;
				int n = 0;
				boolean tableFlag = true;
				while (flag) {
					i++;
					if (n > 10) {
						flag = false;
					}
					if (sheet.getRow(i) == null || sheet.getRow(i).getCell(cellCol) == null
							|| sheet.getRow(i).getCell(cellType) == null || sheet.getRow(i).getCell(cellSize) == null) {
						n++;
						i++;
						continue;
					}
					String colVal = "";
					String typeVal = "";
					Integer sizeVal = null;
					try {
						colVal = sheet.getRow(i).getCell(cellCol).getStringCellValue();
						typeVal = sheet.getRow(i).getCell(cellType).getStringCellValue();
						sizeVal = (int) sheet.getRow(i).getCell(cellSize).getNumericCellValue();
					} catch (Exception e) {
						// System.out.println(e+sheet.getRow(i).getCell(cellSize).getStringCellValue());
					}
					if (!colVal.trim().isEmpty() && !typeVal.trim().isEmpty() && sizeVal != null) {
						if ("NUMBER".equals(typeVal.trim()) && sizeVal > 9) {
							if (tableFlag) {
								System.out.println("\n# " + table);
								tableFlag = false;
							}
							System.out.println(colVal);
						}
					}
				}
			}
		}
	}

	public void checkIntLong() {
		final String notTake = "#";
		final String spilit = "\n";
		int i = 0;
		// get list
		final List<String> listTableColu = ultils.readFileToList("#", "D:\\excel.txt");
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
						if ("BILL".equals(str2.trim())) {
							System.out.println("sd");
						}
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
				int count = StringUtils.countMatches(strTableColu, strColu);
				if (count > 0) {
					if (!strTableColu.contains("_" + strColu) && !strTableColu.contains(strColu + "_")) {
						listResult.add(strTableColu.substring(0, strTableColu.indexOf(spilit)).trim());
					}
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
}

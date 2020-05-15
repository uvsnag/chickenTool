package cken;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExcellUltis {

	public static Ultils ultils = new Ultils();

	public void checkIntLong() {
		final String notTake = "#";
		final String spilit = "\n";
		int i = 0;
		// get list
		final List<String> listTableColu = ultils.readFileToList("#", "E:\\1.txt");
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
}

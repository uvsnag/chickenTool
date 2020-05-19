package cken;

import java.util.List;

/**
 * @author sangnv
 *
 */
public class CompareList {

	public void compareItemOrderInList(final List<String> listOne, final List<String> listTwo) {

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

	public void checkListContainsAnotherList(final List<String> listOne, final List<String> listTwo) {
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
}

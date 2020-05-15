package cken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ultils {

	public static List<String> readFileToList(final String split, final String dirFile) {
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
}

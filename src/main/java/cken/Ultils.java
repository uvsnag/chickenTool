package cken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * @author sangnv
 *
 */
public class Ultils {

	public List<String> readFileToList(final String split, final String dirFile) {
		String strSource = null;
		try {
			strSource = new String(Files.readAllBytes(Paths.get(dirFile)));
		} catch (final IOException e) {
			e.printStackTrace();
		}

		List<String> listStr = new ArrayList<>(Arrays.asList(strSource.split(split)));

		return listStr;
	}

	/**
	 * @param dirFile
	 * @return
	 */
	@Deprecated
	public List<String> trimSQLWhiteSpacetoList(final String dirFile) {
		String split = "\n";
		List<String> listResult = new ArrayList<>();
		List<String> listConvert = readFileToList(split, dirFile);
		for (final String item : listConvert) {
			if (!StringUtils.isEmpty(item)) {
				listResult.add(item.trim());
			}
		}
		return listResult;
	}
}

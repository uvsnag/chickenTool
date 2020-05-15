package cken;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class ConvertToSource {
	
	public static Ultils ultils= new Ultils();
	
	public void convertSQLToSourceSQL(final String dir) {
		final String SPLIT = "\n";
		final List<String> listStr = ultils.readFileToList(SPLIT, dir);

		for (final String str : listStr) {
			if (StringUtils.isNotBlank(str)) {
				System.out.println("sqlBuf.append(\" " + str.trim() + " \");");
			}
		}
	}
}

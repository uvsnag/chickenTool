package cken;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class ConvertToSource {

	public static final Ultils ultils = new Ultils();
	public static final String MASK = "^^";
	public static final String PRE = "?";

	public void convertSQLToSourceSQL(final String dir) {
		final String SPLIT = "\n";
		final List<String> listStr = ultils.readFileToList(SPLIT, dir);

		System.out.println("StringBuilder sqlBuf = new StringBuilder();");

		for (String str : listStr) {
			if (StringUtils.isNotBlank(str)) {
				if (str.contains(MASK)) {
					str = str.replace(MASK, "");
					System.out.println("sqlBuf.append(getQualifiedName(" + str.trim() + "));");
				} else {
					System.out.println("sqlBuf.append(\" " + str.trim() + " \");");
				}
			}
		}
		System.out.println("");
		System.out.println("MapSqlParameterSource params = new MapSqlParameterSource();");
		System.out.println("params.addValue(\"" + PRE + "\", inputNo, Types.INTEGER);");
		System.out.println("params.addValue(\"" + PRE + "\", inputNo, Types.VARCHAR);");

		if ("2?".equals(PRE)) {
			System.out.println("");
			System.out.println("");
			System.out.println(
					"return DaoUtils.extractNillableInteger(this.getNamedParameterJdbcTemplate(), sqlBuf.toString(), params);");// Integer
			System.out.println(
					"return DaoUtils.extractNillableString(this.getNamedParameterJdbcTemplate(), queryNew, paramSource);");// String
			System.out.println(
					"return DaoUtils.extractRequiredInteger(this.getNamedParameterJdbcTemplate(), query, paramSource).intValue();");// int
			System.out.println("return this.getNamedParameterJdbcTemplate().query(sqlBuf.toString(), "
					+ "paramSource, new BeanPropertyRowMapper<MvnoKpoDto>(MvnoKpoDto.class));");// List
			System.out.println("return this.getNamedParameterJdbcTemplate().update(query.toString(), paramSource);");// Insert
		}

	}
}

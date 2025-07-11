package com.coolcoder.demo;

public class DynamicqueryBuilder {
	
	private static final String AND = " and";
	private static final String WHERE = " where";

	private DynamicqueryBuilder() {
		
	}
	
	public static String getQuery(InputCriteria inputCriteria) {
		
		String baseQuery = "select * from employee_info";
		
		StringBuilder buffer = new StringBuilder(baseQuery);
		
		int count = 0;
		
		if (inputCriteria.getId() != null ) {
			buffer.append(" where id = "+inputCriteria.getId());
			count++;
		}
		
		if (inputCriteria.getName() != null ) {
			if (count>0) {
				buffer.append(AND);
			}
			else {
				buffer.append(WHERE);
			}
			String val = " name = '{name}'";
			buffer.append(val.replace("{name}", inputCriteria.getName()));
			count++;
		}
		
		if (inputCriteria.getGender() != null ) {
			if (count>0) {
				buffer.append(AND);
			}
			else {
				buffer.append(WHERE);
			}
			
			String val = " gender = '{gender}'";
			buffer.append(val.replace("{gender}", inputCriteria.getGender()));
			count++;
		}
		
		if (inputCriteria.getDeptName() != null ) {
			if (count>0) {
				buffer.append(AND);
			}
			else {
				buffer.append(WHERE);
			}
			String val = " dept_name = '{dept_name}'";
			buffer.append(val.replace("{dept_name}", inputCriteria.getDeptName()));
			
		}
		
		return buffer.toString();
	}

}

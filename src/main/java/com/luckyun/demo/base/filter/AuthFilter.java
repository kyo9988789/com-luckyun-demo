package com.luckyun.demo.base.filter;

import com.luckyun.core.data.filter.AuthInfo;
import com.luckyun.core.data.filter.PermissionFilter;

/**
 * 权限过滤
 * @author omai
 *
 */
public class AuthFilter extends PermissionFilter {

	private String columnName;
	private AuthInfo authInfo;

	public AuthFilter(AuthInfo authInfo, String columnName) {
		super();
		this.columnName = columnName;
		this.authInfo = authInfo;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	@Override
	public String getSql() {
		return this.getColumnName() + " = " + authInfo.getIndocno();
	}

}

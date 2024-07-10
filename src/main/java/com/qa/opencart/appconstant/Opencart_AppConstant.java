package com.qa.opencart.appconstant;

import java.util.ArrayList;

public class Opencart_AppConstant {

	public static final String LOGIN_PAGE_TILE = "Account Login";
	public static final String LOGIN_PAGE_URL = "route=account/login";

	public static final String ACCOUNT_PAGE_TILE = "My Account";
	public static final String ACCOUNT_PAGE_URL = "route=account/account";

	public static final int ACCT_PAGE_HEADERS_COUNT=4;
	
	public final static String REGISTER_SUCCESSFUL_MESSG = "Your Account Has Been Created";
	
	public static final ArrayList<String> accountsPageHeaders() {
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("My Account");
		al.add("My Orders");
		al.add("My Affiliate Account");
		al.add("Newsletter");

		return al;
	}

}

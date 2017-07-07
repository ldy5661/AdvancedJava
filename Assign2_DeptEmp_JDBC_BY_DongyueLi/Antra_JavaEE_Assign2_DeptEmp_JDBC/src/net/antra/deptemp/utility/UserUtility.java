package net.antra.deptemp.utility;

import javax.servlet.http.HttpServletRequest;

public class UserUtility {
	public static boolean validateUser(String userName, String password, HttpServletRequest req) {
		return "Dongyue".equalsIgnoreCase(userName) && "dongyue".equals(password) ||
				"David".equalsIgnoreCase(userName) && "1".equals(password);				
	}
}

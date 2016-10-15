package com.ethionews.util;

import org.apache.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EthioUtil {
	private static final Logger logger = Logger.getLogger(EthioUtil.class);

	public static String passwordEncoder(String password) {
		String hashedPassword = null;
		for (int i = 0; i < 10; i++) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			hashedPassword = passwordEncoder.encode(password);

		}
		return hashedPassword;
	}

}

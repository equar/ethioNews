package com.ethionews.util;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

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

	public static String uploadFileToServer(MultipartFile file, String fileName) {
		String filePath = null;
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + fileName);
				if (!dir.exists()) {
					dir.mkdirs();
				}

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				filePath = serverFile.toString();

			} catch (Exception e) {
				logger.info(e.getMessage());
			}
		}
		return filePath;
	}

	public static String getBase64Encoded(String imagePath) throws IOException {
		File file = new File(imagePath);
		FileInputStream fis = new FileInputStream(file);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		byte[] buf = new byte[1024];
		for (int readNum; (readNum = fis.read(buf)) != -1;) {
			bos.write(buf, 0, readNum);
		}
		byte[] bytes = bos.toByteArray();
		byte[] encodeBase64 = Base64.encodeBase64(bytes);
		fis.close();

		return new String(encodeBase64, "UTF-8");
	}

}

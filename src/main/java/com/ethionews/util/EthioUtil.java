package com.ethionews.util;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

import com.ethionews.model.ClientLocation;
import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;
import com.maxmind.geoip.regionName;

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

	public static String uploadFileToServer(MultipartFile file, String dirName) {
		String filePath = null;
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + dirName);
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

	public static void writeToFile(String filePath, String content) {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000000);

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {

			bw.write(content);

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	public static String getClientIpAddress(HttpServletRequest request) {
		// is client behind something?
		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null) {
			ipAddress = request.getRemoteAddr();
		}
		return ipAddress;
	}

	public static ClientLocation getLocation(String ipAddress) {
		// String locationDataFile = "GeoLiteCity.dat";
		ClientLocation clientLocation = null;
		ipAddress = "206.190.36.45";
		// URL url = getClass().getClassLoader().getResource(locationDataFile);
		// URL url = EthioUtil.class.getResource(locationDataFile);

		/*
		 * if (url == null) { System.err.println(
		 * "location database is not found - " + locationDataFile); } else {
		 */
		File locationDataFile = new File("C:\\resources\\location\\GeoLiteCity.dat");
		try {

			clientLocation = new ClientLocation();

			LookupService lookup = new LookupService(locationDataFile, LookupService.GEOIP_MEMORY_CACHE);
			Location locationServices = lookup.getLocation(ipAddress);

			clientLocation.setCountryCode(locationServices.countryCode);
			clientLocation.setCountryName(locationServices.countryName);
			clientLocation.setRegion(locationServices.region);
			clientLocation
					.setRegionName(regionName.regionNameByCode(locationServices.countryCode, locationServices.region));
			clientLocation.setCity(locationServices.city);
			clientLocation.setPostalCode(locationServices.postalCode);
			clientLocation.setLatitude(String.valueOf(locationServices.latitude));
			clientLocation.setLongitude(String.valueOf(locationServices.longitude));

		} catch (IOException e) {

			System.err.println(e.getMessage());

		}

		// }

		return clientLocation;

	}
}

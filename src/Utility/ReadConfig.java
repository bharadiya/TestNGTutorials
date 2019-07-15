package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	FileInputStream fis;

	public ReadConfig(String filePath) {
		try {
			fis = new FileInputStream(filePath);
			pro = new Properties();
			pro.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getValue(String key) {
		String value = pro.getProperty(key);
		return value;
	}

	public String getURL() {
		String url = pro.getProperty("baseurl");
		return url;
	}

	public String getUserName() {
		String user = pro.getProperty("username");
		return user;
	}

	public String getPassword() {
		String pass = pro.getProperty("password");
		return pass;
	}

	public String getBrowser() {
		String path = pro.getProperty("browser");
		return path;
	}

	public String getArrowButtonXpath() {
		String arrow = pro.getProperty("arrow");
		return arrow;
	}

	public String getLogOutXpath() {
		String logoff = pro.getProperty("logout");
		return logoff;
	}
}

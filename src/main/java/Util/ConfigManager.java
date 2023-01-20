package Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

	private static ConfigManager manager;
	public static final Properties props = new Properties();
	public static FileInputStream fi ;
	
	private ConfigManager() throws IOException {
		fi = new FileInputStream (System.getProperty("user.dir")+"\\resources\\config.properties");
		props.load(fi);
	}
	
	public static ConfigManager getInstance() {
		if(manager==null) {
			try {
				manager = new ConfigManager();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return manager;
	}
	public String getString(String key) {
		return props.getProperty(key);
	}

}

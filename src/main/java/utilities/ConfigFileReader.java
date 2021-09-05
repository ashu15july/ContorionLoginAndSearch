package utilities;

/**********************************************************************
 *****This class is created to read data from properties file*******
 **********************************************************************/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	private Properties properties;
	private final String propertyFilePath= ".\\Configs\\Configuation.properties";

	
	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	public String getEmailId(){
		String emailId = properties.getProperty("email");
		if(emailId!= null) return emailId;
		else throw new RuntimeException("Emailid is not specified in the Configuration.properties file.");		
	}
	
	public String getPassword() {		
		String pwd = properties.getProperty("password");
		if(pwd != null) return pwd;
		else throw new RuntimeException("Password of the mail is not specified in the Configuration.properties file.");		
	}
	
	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if(url != null) return url;
		else throw new RuntimeException("url is not specified in the Configuration.properties file.");
	}
	
	public String getDriverPath() {
		String driverPath = properties.getProperty("driverPath");
		if(driverPath != null) return driverPath;
		else throw new RuntimeException("DriverPath is not specified in the Configuration.properties file.");
			
	}
	
	public String getProduct() {
		String product = properties.getProperty("product");
		if(product != null) return product;
		else throw new RuntimeException("Product is not specified in the Configuration.properties file.");
	}	
	
}

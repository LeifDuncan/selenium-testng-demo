package com.demo.nonstatic.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {
    
    public WebDriver driver;
    public Properties prop;
    private String baseUrl;

    public Base() {
		try {

            prop = new Properties();
			FileInputStream ip = new FileInputStream(
                System.getProperty("user.dir")
				+ "/src/main/java/com/demo"
                + "/nonstatic/config/config.properties"
			);
			prop.load(ip);

		} catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("FILE NOT FOUND. PLEASE CHECK INTENDED FILE");
		} catch (IOException e) {
			e.printStackTrace();
            System.out.println("IOEXCEPTION. ERROR READING FILE.");
		}
    }

    public void initialization(String uri) {

        switch(prop.getProperty("browser")) {
            case "firefox":
                // IMPLEMENT
            
            case "edge": 
                // IMPLEMENT
            
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                // System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver126");
                System.setProperty("webdriver.chrome.driver", "C:/Program Files/chromedriver-win64/chromedriver.exe");
                driver = new ChromeDriver(options);

            default: 
                System.out.println("Invalid browser specified");
                break;
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        baseUrl = prop.getProperty("baseUrl");

        driver.get(String.format(baseUrl + "%s", uri));
    }

}

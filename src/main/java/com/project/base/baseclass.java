package com.project.base;


import com.project.WebEventListener.WebEventListener;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;
import static org.openqa.selenium.remote.BrowserType.IE;

public class baseclass {

    public static final Logger log = Logger.getLogger(baseclass.class.getName());
    public static WebDriver driver = null;
    public static Properties prop;
    protected ThreadLocal<RemoteWebDriver> threadDriver = null;
    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;
    public static DesiredCapabilities desired;
    private final static String WEBDRIVER_MODE_LOCAL = "local";
    private final static String WEBDRIVER_MODE_GRID = "grid";

    public baseclass() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("D:\\TrafficHomepage\\src\\test\\resources\\config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void logExtentReport(String strExtentReport){

    }

    public static void initialization() throws InterruptedException, MalformedURLException {

        String browserName = prop.getProperty("browser");
        if (WEBDRIVER_MODE_LOCAL.equals(prop.getProperty("LOCAL_WEBDRIVER_MODE"))) {
            switch (browserName) {
                case CHROME:
                    System.out.println("Launching Google Chrome browser");
                    System.setProperty("webdriver.chrome.driver", prop.getProperty("ChromeDriverPath"));
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("test-type");
                    options.addArguments("start-maximized");
                    //options.addArguments("--headless");
                    options.addArguments("--js-flags=--expose-gc");
                    options.addArguments("--enable-precise-memory-info");
                    options.addArguments("--disable-popup-blocking");
                    options.addArguments("--disable-default-apps");
                    options.addArguments("--disable-extensions");
                    options.addArguments("test-type=browser");
                    options.addArguments("ACCEPT_SSL_CERTS");
                    options.addArguments("window-size=1366x768");
                    options.addArguments("disable-infobars");
                    driver = new ChromeDriver(options);
                    break;
                case FIREFOX:
                   System.setProperty("webdriver.gecko.driver", prop.getProperty("FirefoxDriverPath"));
                   File FirefoxPathBinary = new File("D:\\Program Files\\Mozilla Firefox\\firefox.exe");
                    FirefoxBinary firefoxBinary = new FirefoxBinary(FirefoxPathBinary);
                    desired = DesiredCapabilities.firefox();
                    FirefoxOptions firefoxoption = new FirefoxOptions();
                    desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxoption.setBinary(firefoxBinary));
                    driver = new FirefoxDriver(firefoxoption);
                    break;
                case IE:
                    DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                    capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                    File InternetPath = new File(prop.getProperty("InternetExplorerDriverPath"));
                    System.setProperty("webdriver.ie.driver", InternetPath.getAbsolutePath());
                    driver = new InternetExplorerDriver(capabilities);
                default:
                    throw new RuntimeException("Invalid Browser Name");
            }
        } else if (WEBDRIVER_MODE_GRID.equals(prop.getProperty("GRID_WEBDRIVER_MODE"))) {
            if (browserName.equalsIgnoreCase("chrome")) {
                System.out.println(" Executing on Chrome");
                ChromeOptions option = new ChromeOptions();
                option.addArguments("disable-infobars");
                DesiredCapabilities capability = DesiredCapabilities.chrome();
                capability.setBrowserName("chrome");
                capability.setPlatform(Platform.WINDOWS);
                //option.merge(capability);
                String HUBURL = "http://192.168.10.60:4444/wd/hub";
                driver = new RemoteWebDriver(new URL(HUBURL),capability);

            } else if (browserName.equalsIgnoreCase("firefox")) {
                System.out.println(" Executing on firefox");
                DesiredCapabilities capability = DesiredCapabilities.firefox();
                capability.setBrowserName("firefox");
                capability.setPlatform(Platform.WINDOWS);
                FirefoxOptions option = new FirefoxOptions();
                option.merge(capability);
                String HUBURL = "http://192.168.10.47:4444/wd/hub";
                driver = new RemoteWebDriver(new URL(HUBURL), option);

            } else if (browserName.equalsIgnoreCase("ie")) {
                System.out.println(" Executing on IE");
                DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
                capability.setBrowserName("internet explorer");
                capability.setPlatform(Platform.WINDOWS);
                InternetExplorerOptions option = new InternetExplorerOptions();
                option.merge(capability);
                String HUBURL = "http://192.168.10.47:4444/wd/hub";
                driver = new RemoteWebDriver(new URL(HUBURL), option);
            } else {
                throw new RuntimeException("Invalid Browser Name");
            }

        }
        e_driver = new EventFiringWebDriver(driver);
        eventListener = new WebEventListener();
        e_driver.register(eventListener);
        driver = e_driver;
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        (new Thread(new LoginWindow())).start();
        try {
            driver.get(prop.getProperty("URL"));
            WebDriverWait wait = new WebDriverWait (driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='9b1e4f63-e161-49e8-8e03-31afe87c38fb_4e03e453-4f43-66ee-3ee8-0468c23af24d_012c3e84-a014-a9eb-09d7-28abe808f6e9_73c59b4a-60c2-47a6-88d0-fd896f7b67a4']/div[3]/div[2]/div/div/table/tbody/tr[3]")));
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static class LoginWindow implements Runnable {
        @Override
        public void run() {
            try {
                login();
            } catch (Exception ex) {
                System.out.println("Error in Login Thread: " + ex.getMessage());
            }
        }

        public void login() throws Exception {
            Thread.sleep(2000);
            Robot rb = new Robot();
            StringSelection username = new StringSelection("Asingh");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(username, null);
            rb.keyPress(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_V);
            rb.keyRelease(KeyEvent.VK_V);
            rb.keyRelease(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_TAB);
            rb.keyRelease(KeyEvent.VK_TAB);
            Thread.sleep(1000);
            StringSelection pwd = new StringSelection("Pass#12345");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(pwd, null);
            rb.keyPress(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_V);
            rb.keyRelease(KeyEvent.VK_V);
            rb.keyRelease(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);
            }

        public String getReportConfigPath() {
            String reportConfigPath = prop.getProperty("reportConfigPath");
            if (reportConfigPath != null) return reportConfigPath;
            else
            throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
        }

    }
}




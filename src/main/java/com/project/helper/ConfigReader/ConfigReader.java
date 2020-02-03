package com.project.helper.ConfigReader;

/**
 * Created by Asit.Singh on 06-05-2019.
 */
public interface ConfigReader {
    public int getImpliciteWait();
    public int getExplicitWait();
    public int getPageLoadTime();
    public BrowserType getBrowserType();
    public String getUrl();
    public String getUserName();
    public String getPassword();
}

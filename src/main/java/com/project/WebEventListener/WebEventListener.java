package com.project.WebEventListener;

import com.project.base.baseclass;
import com.project.utility.utility;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.io.IOException;

/**
 * Created by Administrator on 4/28/2018.
 */
public class WebEventListener extends baseclass implements WebDriverEventListener {

    public static final Logger log = Logger.getLogger(WebEventListener.class.getName());

    public void beforeNavigateTo(String url, WebDriver driver) {
        //System.out.println("Before navigating to: '" + url + "'");
        log.info("Before navigating to: '" + url + "'");
    }

    public void afterNavigateTo(String url, WebDriver driver) {
        log.info("Navigated to:'" + url + "'");
       // System.out.println("Navigated to:'" + url + "'");
    }

    public void beforeChangeValueOf(WebElement element, WebDriver driver) {
      //  System.out.println("Value of the:" + element.toString() + " before any changes made");
        log.info("Value of the:" + element.toString() + " before any changes made");
    }

    public void afterChangeValueOf(WebElement element, WebDriver driver) {
   //     System.out.println("Element value changed to: " + element.toString());
        log.info("Element value changed to: " + element.toString());
    }

    public void beforeClickOn(WebElement element, WebDriver driver) {
    //    System.out.println("Trying to click on: " + element.toString());
        log.info("Trying to click on: " + element.toString());
    }

    public void afterClickOn(WebElement element, WebDriver driver) {
   //    System.out.println("Clicked on: " + element.toString());
        log.info("Clicked on: " + element.toString());
    }

    public void beforeNavigateBack(WebDriver driver)
    {
    //    System.out.println("Navigating back to previous page");
        log.info("Navigating back to previous page");
    }

    public void afterNavigateBack(WebDriver driver) {
     //   System.out.println("Navigated back to previous page");
        log.info("Navigated back to previous page");
    }

    public void beforeNavigateForward(WebDriver driver) {
     //   System.out.println("Navigating forward to next page");
        log.info("Navigating forward to next page");
    }

    public void afterNavigateForward(WebDriver driver) {
      //  System.out.println("Navigated forward to next page");
        log.info("Navigated forward to next page");
    }

    public void onException(Throwable error, WebDriver driver) {
        log.info("Exception occured: " +error);
        try {
            utility.takeScreenshotAtEndOfTest("Traffic");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        log.info("Trying to find Element By : " + by.toString());
    }

    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        log.info("Found Element By : " + by.toString());
    }

    public void beforeScript(String script, WebDriver driver) {

    }

    public void afterScript(String script, WebDriver driver) {

    }
    public void beforeAlertAccept(WebDriver driver) {

    }

    public void afterAlertAccept(WebDriver driver) {


    }

    public void afterAlertDismiss(WebDriver driver) {

    }

    public void beforeAlertDismiss(WebDriver driver) {


    }

    public void beforeNavigateRefresh(WebDriver driver) {


    }

    public void afterNavigateRefresh(WebDriver driver) {


    }

    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

    }

    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {


    }
}

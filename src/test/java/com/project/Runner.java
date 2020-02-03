package com.project;


import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;


import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions( plugin={"html:target/cucumber-html-report",
       // "json:target/cucumber.json",
        "json:target/cucumber-html-report/cucumber.json",
        "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",
        "pretty:target" +"/cucumber-pretty.txt",
        "junit:target/cucumber-results"+"xml"},
        tags = {"@Sanity"},
        monochrome = true,
       // dryRun = true,
       features="D:\\TrafficHomepage\\src\\test\\resources\\com.project")

    public class Runner {

    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File(System.getProperty("user.dir")+"\\AutomationFramework-master\\config.xml"));
    }


    }


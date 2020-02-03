package com.project;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(plugin={"html:target/cucumber-html-report",
        "json:target/cucumber.json",
        "pretty:target/cucumber-pretty.txt",
        "junit:target/cucumber-results.xml"},features="D:\\AutomateTrafficHomepage\\Automate-Traffic-Homepage\\AutomationFramework-master\\src\\test\\resources\\com.project\\TeamView.feature")

public class RunnersTestng extends AbstractTestNGCucumberTests {
}

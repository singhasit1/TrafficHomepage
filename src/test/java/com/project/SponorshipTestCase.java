package com.project;

import com.project.base.baseclass;
import com.project.page.SponorshipPage;
import com.project.page.TeamViewPage;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SponorshipTestCase extends baseclass {

    public static final Logger log = Logger.getLogger(SponorshipTestCase.class.getName());
    SponorshipPage Sponorship = new SponorshipPage();;

    public SponorshipTestCase() {
        super();
    }

    @After
    public void Teardown(){
        log.info("Close Browser");
        driver.quit();    }


    @When("^Navigate To sponorship tab$")
    public void navigate_To_sponorship_tab() throws Throwable {
        Sponorship.navigatetoSponsorshipTab();
        log.info("Navigate To Sponorship Tab");
    }

    @Then("^Verify That Sponorship Tab Contain Following Menu$")
    public void verify_That_Sponorship_Tab_Contain_Following_Menu(DataTable SponorshipColumn) throws Throwable {
        List<String> list = SponorshipColumn.asList(String.class);
        SoftAssert softAssertion= new SoftAssert();
        System.out.println("softAssert Method Was Started");
        softAssertion.assertEquals(list.get(0),Sponorship.FindMenu());
        softAssertion.assertEquals(list.get(1),Sponorship.ApplicationMenu());
        softAssertion.assertAll();
    }
    @Given("^Click on Find  Menu$")
    public void click_on_Find_Menu() throws Throwable {
        Sponorship.ClickOnFindmenu();
        }
    @Then("^Verify The Sub-Menu Of Sponorship Find Menu$")
    public void verify_The_Sub_Menu_Of_Sponorship_Find_Menu() throws Throwable {
        Sponorship.VerifySponFindSubmenu();
    }

    @Then("^Verify Sub-Menu Of Sponorship Application Menu$")
    public void verify_Sub_Menu_Of_Sponorship_Application_Menu() throws Throwable {
        Sponorship.VerifySponApplicationSubmenu();    }

    @Given("^Click on Find  Menu Of Sponorship Tab$")
    public void click_on_Find_Menu_Of_Sponorship_Tab() throws Throwable {
        Sponorship.ClickOnFindmenu();

    }
    @Given("^Click on Application Menu Of Sponorship Tab$")
    public void click_on_Application_Menu_Of_Sponorship_Tab() throws Throwable {
        Sponorship.ClickOnApplicationmenu();
    }

    @Then("^Verify That Sponorship Tab Has Following Widgets$")
    public void verify_That_Sponorship_Tab_Has_Following_Widgets() throws Throwable {
       Assert.assertTrue(Sponorship.ValidateSponorshipWidgets());
    }



}

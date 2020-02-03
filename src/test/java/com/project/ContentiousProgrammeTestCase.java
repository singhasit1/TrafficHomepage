package com.project;


import com.project.base.baseclass;
import com.project.page.ContentiousProgrammePage;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ContentiousProgrammeTestCase extends baseclass {


    ContentiousProgrammePage CPP = new ContentiousProgrammePage();

    @After
    public void TearDown(){
        driver.quit();
    }

    @When("^User In Team View Tab$")
    public void user_In_Team_View_Tab() throws Throwable {

    }

    @Then("^Verify The Following Column List In Contentious Programme$")
    public void verify_The_Following_Column_List_In_Contentious_Programme(List<String> ViewColumn) throws Throwable {
        Assert.assertEquals(ViewColumn,CPP.Verify_Contentious_Programme_Column_Name());
    }
    @Given("^User Set Date Range As \"([^\"]*)\" and \"([^\"]*)\" in Contentious Programme Widget$")
    public void user_Set_Date_Range_As_and_in_Contentious_Programme_Widget(String Start_date, String End_date) throws Throwable {
        CPP.SetDateRange(Start_date,End_date);
    }

    @Given("^Click On View button$")
    public void click_On_View_button() throws Throwable {
        CPP.ClickonViewButton();
    }
    @Given("^Click On View All button$")
    public void click_On_View_All_button() throws Throwable {
        CPP.ClickonViewAll();
    }

    @Then("^Verify That Total <(\\d+)> Records Display when NextPage Button is Enable$")
    public void verify_That_Total_Records_Display_when_NextPage_Button_is_Enable(int Row_count) throws Throwable {
        int  Record_Count = CPP.CountRecords(Row_count);
        Assert.assertEquals(Row_count, Record_Count);
    }
    @Given("^Verify that Transmission Dates should be \"([^\"]*)\"$")
    public void verify_that_Transmission_Dates_should_be(String Date) throws Throwable {
        Assert.assertEquals(Date,CPP.VerifyTransmissionDate());
    }
    @Then("^Verify That Total Records Display In View All Contentious Programme Widget$")
    public void verify_That_Total_Records_Display_In_View_All_Contentious_Programme_Widget() throws Throwable {
        System.out.println("Total Record Count Is : "+CPP.ContentiousProgrammeTotalCount());
    }

    @Then("^Verify That Transmission Date should be contain date as \"([^\"]*)\"$")
    public void verify_That_Transmission_Date_should_be_contain_date_as(String TransmissionDate) throws Throwable {
        Assert.assertEquals(TransmissionDate,CPP.VerifyTransmissionDateViewAll());
    }




}

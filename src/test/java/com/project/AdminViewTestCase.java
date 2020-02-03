package com.project;


import com.project.base.baseclass;
import com.project.page.AdminViewPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AdminViewTestCase extends baseclass {
    AdminViewPage adminViewPage = new AdminViewPage();

    @When("^Navigate to Admin view Tab$")
    public void navigate_to_Admin_view_Tab() throws Throwable {
        adminViewPage.NavigateToAdminTab();
        Thread.sleep(5000);
        }

    @Then("^Validate All widget of Admin View tab$")
    public void validate_All_widget_of_Admin_View_tab() throws Throwable {
        Assert.assertTrue(adminViewPage.ValidateAdminViewWidgets());
    }

    @When("^Set Date as \"([^\"]*)\" and \"([^\"]*)\" in Channel Responsibilities$")
    public void set_Date_as_and_in_Channel_Responsibilities(String StartDate, String EndDate) throws Throwable {
        adminViewPage.SetDateRange(StartDate,EndDate);
    }

    @When("^Click On View Button$")
    public void click_On_View_Button() throws Throwable {
        adminViewPage.ClickonViewButton();
    }
    @Then("^Corresponding Data Should be populated$")
    public void corresponding_Data_Should_be_populated() throws Throwable {
        Thread.sleep(5000);



    }

    @Then("^Corresponding Data Should be Generated$")
    public void corresponding_Data_Should_be_Generated() throws Throwable {

    }
    @When("^Click On AutoGenerate Button$")
    public void click_On_AutoGenerate_Button() throws Throwable {
        adminViewPage.ClickonAutogenerate();
    }

    @Then("^Verify The System Warning Message_And_Confirm$")
    public void Verify_The_System_Warning_Message_And_Confirm() throws Throwable {
    adminViewPage.AcceptWaringMessage();
    }


    @When("^Click On View All/Update Button$")
    public void click_On_View_All_Update_Button() throws Throwable {
        adminViewPage.ClickonViewAll();
    }
    @When("^Go to Next Page is Enable$")
    public void go_to_Next_Page_is_Enable() throws Throwable {

    }
    @Then("^Verify that Maximum Five Records available in View mode$")
    public void verify_that_Maximum_Five_Records_available_in_View_mode() throws Throwable {


    }
    @Then("^Channel Responsibilities Widget Contain Minimum <(\\d+)> Records$")
    public void channel_Responsibilities_Widget_Contain_Minimum_Records(int  Row_count) throws Throwable {
        int  Record_Count =adminViewPage.CountRecords(Row_count);
        Assert.assertEquals(Row_count, Record_Count);
    }

    @Given("^Click on ViewAll Button$")
    public void click_on_ViewAll_Button() throws Throwable {
        adminViewPage.ClickonViewAll();

    }

    @Then("^ViewAll channel Responsibilites Screen Open$")
    public void viewall_channel_Responsibilites_Screen_Open() throws Throwable {
        String Value = "Channel Responsibilities";
        Assert.assertEquals(Value,adminViewPage.Channel_repsonsibilites_viewAll_title());
    }

    @Given("^Select an user as \"([^\"]*)\" and Save$")
    public void select_an_user_as_and_Save(String User) throws Throwable {
        adminViewPage.SetUserName(User);
    }
    @Then("^Verify that \"([^\"]*)\" display in View Mode$")
    public void verify_that_display_in_View_Mode(String ViewUserName) throws Throwable {
        System.out.println("Value is ");
        Assert.assertEquals(ViewUserName,adminViewPage.View_UserName());
    }

    @Then("^Verify that \"([^\"]*)\" display in ViewAll Mode$")
    public void verify_that_display_in_ViewAll_Mode(String ViewAllUserName) throws Throwable {
        adminViewPage.ClickonViewAll();
        Thread.sleep(1000);
        WebElement Frame = driver.findElement(By.className("runtime-popup"));
        driver.switchTo().frame(Frame);
        Assert.assertEquals(ViewAllUserName,adminViewPage.ViewAll_UserName());
    }
    @Then("^Verify That Channel Responsibilities Contain Following Column$")
    public void verify_That_Channel_Responsibilities_Contain_Following_Column(List<String> ViewColumn) throws InterruptedException {
        Assert.assertEquals(ViewColumn,adminViewPage.Verify_Channel_Channel_Responsibilty_Column_Name());
    }



}

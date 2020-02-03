package com.project;

import com.project.base.baseclass;
import com.project.page.MyViewPage;
import com.project.page.TeamViewPage;
import com.project.page.WorklistPage;
import com.project.utility.utility;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WorklistWidgetTestCase extends baseclass {

    TeamViewPage tvp ;
    MyViewPage mvp;
    utility util ;
    WorklistPage worklistpage = new WorklistPage();

    public WorklistWidgetTestCase() { super();}

    @After
    public void teardown(){
        driver.quit();
    }


    @When("^Select any record of worklist$")
    public void select_any_record_of_worklist_and_choose_an_Assign_To() throws Throwable {

    }

    @Then("^Verify that \"([^\"]*)\" selected as Assign name in worklist third record$")
    public void verify_that_selected_as_Assign_name_in_worklist_third_record(String ActualAssigneName) throws Throwable {
        org.testng.Assert.assertEquals(ActualAssigneName,worklistpage.AssigneeName());
    }

    @Given("^Select an Assign \"([^\"]*)\"$")
    public void select_an_Assign(String AssignUsreName) throws Throwable {
        worklistpage.select_an_Assign_To_UserName(AssignUsreName);
    }

    @When("^User in Worklist Widget$")
    public void userInWorklistWidget() throws Throwable {
            //WP.Select_Third_Row();

    }
    @When("^Click on Third Row$")
    public void click_on_Third_Row() throws Throwable {
        worklistpage.Select_Third_Row();
    }

    @And("^Select an Assign To$")
    public void selectAnAssignTo() throws Throwable {

    }

    @And("^Click on Assign Button$")
    public void click_On_Assign_Button() throws Throwable {
        worklistpage.ClickonAssign();
    }

    @And("^Click on RemoveFromList Button$")
    public void click_On_Remove_From_List_Button() {
        worklistpage.RemoveFromList();
    }

    @Then("^Then CRI Remove From Worklist$")
    public void thenCRIRemoveFromWorklist()  {
        driver.findElement(By.linkText("OK")).click();

    }

    @Then("^Verify Warning Message of Remove CRI$")
    public void verify_Warning_Message_Of_Remove_CRI() throws Throwable {

          }
    @When("^User In Team View Tab and Select Worklist Widget$")
    public void user_In_Team_View_Tab_and_Select_Worklist_Widget() throws Throwable {

    }

    @Then("^Verify That Worklist Widget Have Following Column Name$")
    public void verify_That_Worklist_Widget_Have_Following_Column_Name(List<String> WorklistColumn) throws Throwable {
        org.testng.Assert.assertEquals(WorklistColumn,worklistpage.worklistColumn());
      }
}

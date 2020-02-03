package com.project;

import com.project.base.baseclass;
import com.project.helper.DatabaseConffigure.DataBaseHelper;
import com.project.helper.Logger.LoggerHelper;
import com.project.page.*;
import com.project.utility.utility;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TeamViewTestCase extends baseclass {
    TeamViewPage teamViewpage;
    MyViewPage mvp;
    WorklistPage WP;
    AdminViewPage adminViewPage;
    SponorshipPage Spontab;
    AccountSetup accountsetup;
    WorklistWidgetTestCase  worklistwidgettestcase;

    DataBaseHelper databasehelper = new DataBaseHelper();

    public static final Logger log = Logger.getLogger(TeamViewTestCase.class.getName());


    public TeamViewTestCase() { super();}

    @After
    public void teardown(){
    driver.quit();
    log.info("Browser Closed");
    }

    @Given("^\"([^\"]*)\" Has Access of Traffic Homepage$")
    public void has_Access_of_Traffic_Homepage(String UserName) throws Throwable {
        if(teamViewpage.VerifyLoggedInUser()){
            Assert.assertEquals(UserName,teamViewpage.VerifyUserName());
            log.info("User Logged in Traffic");
        }
        else
        {   JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("alert('Either User Does Not Have Mapping or Remote Server is Down');");
        }

    }

    @When("^Launch browser and Application$")
    public void launch_browser_and_Application() throws InterruptedException, MalformedURLException {
        log.info("========================================================================");
        log.info (" TRAFFIC HOMEPAGE LAUNCHED");
        log.info("========================================================================");
        initialization();
       teamViewpage = new TeamViewPage();
        mvp=new MyViewPage();
        Spontab= new SponorshipPage();
        adminViewPage= new AdminViewPage();
        accountsetup = new AccountSetup();
        worklistwidgettestcase = new WorklistWidgetTestCase();
    }

    @When("^User In TeamView Tab$")
    public void User_In_TeamView_Tab() {
        log.info("User In TeamView Tab");
    }

    @When("^Click on Set Up Menu$")
    public void click_on_Set_Up_Menu() throws Throwable {
        teamViewpage.ClickOnSetupMenu();
        log.info("User Click on Set Up Menu");
    }
    @Given("^Click on Find Menu$")
    public void click_on_Find_Menu() throws Throwable {
        teamViewpage.ClickOnFindmenu();
    }


    @Then("^Verify that Team View Tab Contain Following Menu$")
    public void verify_that_Team_View_Tab_Contain_Following_Menu(DataTable table) throws Throwable {
        List<String> list = table.asList(String.class);
        SoftAssert softAssertion= new SoftAssert();
        System.out.println("softAssert Method Was Started");
        softAssertion.assertEquals(list.get(0),teamViewpage.Setupmenu());
        softAssertion.assertEquals(list.get(1),teamViewpage.Findmenu());
        softAssertion.assertEquals(list.get(2),teamViewpage.Actionmenu());
        softAssertion.assertEquals(list.get(3),teamViewpage.SequenceBreakmenu());
        softAssertion.assertEquals(list.get(4),teamViewpage.GeneratePlaylistmenu());
        softAssertion.assertEquals(list.get(5),teamViewpage.ApplicationMenu());
        softAssertion.assertAll();
    }

    @Then("^Verify Sub-Menu Of Setup Menu$")
    public void verify_Sub_Menu_Of_Setup_Menu() throws Throwable {
        teamViewpage.VerifySetupSubmenu();
    }

    @Then("^Verify Sub-Menu Of Find Menu$")
    public void verify_Sub_Menu_Of_Find_Menu() throws Throwable {
        teamViewpage.VerifyFindSubmenu();
    }


    @Then("^Validate Traffic Homepage Title$")
    public void validate_Traffic_HomepageTitle() throws Throwable {
        try{
        String Title="Traffic";
        Assert.assertEquals(driver.getTitle(),Title);}
        catch (Exception e9){
            System.out.println(e9);
        }
            }


     @Then("^System should warn that No Stellar User is mapped$")
    public void system_Should_warn_that_No_Stellar_User_is_mapped() throws Throwable {
         teamViewpage.VerifyUsernotMapped();
    }

    @Then("^System should warn that \"([^\"]*)\"$")
    public void system_should_warn_that(String WarningMessage) throws Throwable {
    Assert.assertEquals(WarningMessage,teamViewpage.VerifyUsernotMapped());
    }

    @Given("^Assign Role and Team Name As \"([^\"]*)\"$")
    public void assign_Role_and_Team_Name_As(String TeamName) throws Throwable {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con= DriverManager.getConnection("jdbc:oracle:thin:@C-STELL-DEVORA01:1521:REDTEST","stowner","stowner");
            Statement stmt=con.createStatement();
            ResultSet resultset=stmt.executeQuery("DELETE FROM  cmn_user_ldmmap WHERE  LEO_USER_CD ='ASINGH'");
            resultset=stmt.executeQuery("commit");
            resultset=stmt.executeQuery("INSERT INTO cmn_user_ldmmap VALUES ('ASINGH','KSAHA',SYSDATE,'*SYS',SYSDATE,'*SYS','000Kdg0uq-wiWE.XCYzK3l9sUARtXrG0')");
            resultset=stmt.executeQuery("select * from cmn_user_ldmmap WHERE  LEO_USER_CD ='ASINGH'");
            while(resultset.next())
            System.out.println(resultset.getString(1)+"/"+resultset.getString(2)+"/"+resultset.getString(3)+"/"+resultset.getString(4)+"/"+resultset.getString(5)+"/"+resultset.getString(6));
            resultset=stmt.executeQuery("UPDATE cmn_user SET TEAM_KEY=20,DEFAULT_ROLE_KEY=149 WHERE user_cd='ASINGH1'");
            resultset=stmt.executeQuery("SELECT USER_NM,TEAM_KEY,DEFAULT_ROLE_KEY FROM cmn_user WHERE user_cd='ASINGH1' ");
            while(resultset.next())
                //System.out.println(rs.getInt(1)+"/"+rs.getString(2)+"/"+rs.getString(3)+"/"+rs.getString(4));
                System.out.println("User Name Is"+resultset.getString(1)+"/"+resultset.getString(2)+"/"+resultset.getString(3));
            con.close();
        }
        catch(Exception exception){ System.out.println(exception);}

    }


    @Given("^User should have proper mapping$")
    public void user_Should_Have_Proper_Mapping() throws Throwable {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con= DriverManager.getConnection("jdbc:oracle:thin:@C-STELL-DEVORA01:1521:REDTEST","stowner","stowner");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("DELETE FROM  cmn_user_ldmmap WHERE  LEO_USER_CD ='ASINGH'");
            rs=stmt.executeQuery("INSERT INTO cmn_user_ldmmap VALUES ('ASINGH','KSAHA',SYSDATE,'*SYS',SYSDATE,'*SYS','000Kdg0uq-wiWE.XCYzK3l9sUARtXrG0')");
            rs=stmt.executeQuery("select * from cmn_user_ldmmap WHERE  LEO_USER_CD ='ASINGH'");
            while(rs.next())
                //System.out.println(rs.getInt(1)+"/"+rs.getString(2)+"/"+rs.getString(3)+"/"+rs.getString(4));
                System.out.println(rs.getString(1)+"/"+rs.getString(2)+"/"+rs.getString(3)+"/"+rs.getString(4)+"/"+rs.getString(5)+"/"+rs.getString(6));
            con.close();
        }
        catch(Exception e){ System.out.println(e);}
    }

    @Given("^User does not have Mapping$")
    public void User_Does_Not_Have_Mapping() throws Throwable {
        teamViewpage = new TeamViewPage();
        String userDeleteQuery = "DELETE FROM cmn_user_ldmmap WHERE leo_user_cd='ASINGH'";
        teamViewpage.resultset(userDeleteQuery);
    }



    @Then("^Traffic homepage should Launch and verify Refresh Button$")
    public void Traffic_Homepage_Should_Launch_And_Verify_Refresh_Button() throws Throwable {
        //Assert.assertTrue(tvp.VerifyUserName());
    }

    @Then("^Traffic homepage should Launch and verify user name as \"([^\"]*)\"$")
    public void Traffic_homepage_should_Launch_and_verify_user_name_as(String UserName) throws Throwable {
       Assert.assertEquals(UserName,teamViewpage.VerifyUserName());
    }

    @Then("^Verify Refresh Button Should Available$")
    public void Verify_Refresh_Button_Should_Available() throws Throwable {
        teamViewpage.VerifyRefreshButton();

    }

    @And("^Click on Action Menu$")
    public void click_On_Action_Menu() throws Throwable {
        teamViewpage.ClickOnActionmenu();
    }
    @Then("^Verify Sub-Menu Of Action Menu$")
    public void verify_Sub_Menu_Of_Action_Menu() throws Throwable {
        teamViewpage.VerifyActionSubmenu();
    }
    @When("^Click on Application Menu$")
    public void click_on_Application_Menu() throws Throwable {
        teamViewpage.ClickOnApplicationmenu();
    }

    @Then("^Verify Sub-Menu Of Application Menu$")
    public void verify_Sub_Menu_Of_Application_Menu() throws Throwable {
        teamViewpage.VerifyApplicationSubmenu();    }

    @Then("^Verify That Team View Tab Has Following Widgets$")
    public void verify_That_Team_View_Tab_Has_Following_Widgets() throws Throwable {
        Assert.assertTrue(teamViewpage.ValidateTeamViewWidgets());

      }
}





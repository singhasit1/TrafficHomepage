package com.project;


import com.project.base.baseclass;
import com.project.page.MyViewPage;
import com.project.page.TeamViewPage;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class MyViewTestCase extends baseclass {

    public static final Logger log = Logger.getLogger(MyViewTestCase.class.getName());

    MyViewPage myviewpage = new MyViewPage();

    @After
    public void teardown(){
        driver.quit();
    }

    @When("^Navigate to My View Tab$")
    public void Navigate_to_My_View_Tab() {
        myviewpage.ClickonMyviewTab();
    }

    @Then("^Verify That My View Tab Has Following Widgets$")
    public void Verify_That_My_View_Tab_Has_Following_Widgets() throws Throwable {
        myviewpage.ValidateMyViewWidgets();
    }
    @Then("^Verify That My View Tab Has Following Menu$")
    public void Verify_That_My_View_Tab_Has_Following_Menu(DataTable table1) throws Throwable {
        List<String> list = table1.asList(String.class);
        SoftAssert softAssertion= new SoftAssert();
        System.out.println("softAssert Method Was Started");
        softAssertion.assertEquals(list.get(0),myviewpage.Setupmenu());
        softAssertion.assertEquals(list.get(1),myviewpage.Findmenu());
        softAssertion.assertEquals(list.get(2),myviewpage.Actionmenu());
        softAssertion.assertEquals(list.get(3),myviewpage.SequenceBreakmenu());
        softAssertion.assertEquals(list.get(4),myviewpage.GeneratePlaylistmenu());
        softAssertion.assertEquals(list.get(5),myviewpage.ApplicationMenu());
        softAssertion.assertAll();
    }


    @Then("^Verify that My View Tab Contain Following Menu Item$")
    public void verify_that_My_View_Tab_Contain_Following_Menu_item(List<String> TopMenuItems) throws InterruptedException {
       Assert.assertEquals(TopMenuItems,myviewpage.VerifyTopMenuItems());
    }

}

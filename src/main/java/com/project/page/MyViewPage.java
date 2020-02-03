package com.project.page;

import com.project.base.baseclass;
import com.project.helper.Action.TrafficMenu;
import com.project.helper.JavaScript.JavaScriptHelper;
import com.project.helper.Logger.LoggerHelper;
import com.project.helper.Wait.WaitHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class MyViewPage extends baseclass {

    @FindBy(xpath = "//*[@id=\"00000000-0000-0000-0000-000000000000_8c40ed24-69c3-4f13-86e8-f0b8642fa123\"]/span/span")
    private WebElement webMyviewTab;

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='http://www.k2.com'])[2]/following::div[3]")
    private  WebElement webSetUpMenu;

    @FindBy(xpath="//*[@id=\"9b1e4f63-e161-49e8-8e03-31afe87c38fb_8c40ed24-69c3-4f13-86e8-f0b8642fa123_8362216c-37a3-cf1d-b079-ec182037153d_73c59b4a-60c2-47a6-88d0-fd896f7b67a4\"]/div[3]/div[2]/div/div/table/tbody/tr[4]")
    private WebElement webWorklistRecords;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='PROCESS COMPANIES'])[2]/following::div[1]")
    private  WebElement webFindMenu;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='FIND COMMON ROTATIONS'])[2]/following::div[1]")
    private WebElement webActionMenu;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Request Privilege'])[2]/following::div[1]")
    private WebElement webSequenceBreaksMenu;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='SEQUENCE BREAKS'])[2]/following::div[1]")
    private WebElement WebGeneratePlaylistsMenu;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='GENERATE PLAYLISTS'])[2]/following::div[1]")
    private WebElement webApplicationMenu;

    @FindBy(xpath="(.//*[normalize-space(text()) and normalize-space(.)='KSAHA'])[1]/following::span[2]")
    private  WebElement webWorklist;
    @FindBy(xpath="(.//*[normalize-space(text()) and normalize-space(.)='of 1'])[1]/following::span[9]")
    private  WebElement webChannelProgress;
    @FindBy(xpath="(.//*[normalize-space(text()) and normalize-space(.)='of 1'])[2]/following::span[9]")
    private  WebElement webCopyAssignment;
    @FindBy(xpath="(.//*[normalize-space(text()) and normalize-space(.)='of 1'])[3]/following::span[9]")
    private  WebElement webReserveList;
    @FindBy(xpath="(.//*[normalize-space(text()) and normalize-space(.)='of 1'])[5]/following::span[9]")
    private WebElement webChannelGroupResponsibilities;
    @FindBy(xpath="/(.//*[normalize-space(text()) and normalize-space(.)='of 1'])[6]/following::span[9]")
    private  WebElement webMy_Channel;
    @FindBy(xpath="(.//*[normalize-space(text()) and normalize-space(.)='of 1'])[7]/following::span[9]")
    private  WebElement webContentiousProgramme;
    @FindBy(xpath="(.//*[normalize-space(text()) and normalize-space(.)='of 1'])[8]/following::span[9]")
    private  WebElement webCopySummary;


    private Logger log = LoggerHelper.getLogger(MyViewPage.class);
    JavaScriptHelper javascripthelper = new JavaScriptHelper(driver);
    TrafficMenu trafficmenu = new TrafficMenu();
    SoftAssert softAssertion= new SoftAssert();
    WaitHelper waithelper = new WaitHelper(driver);

    public MyViewPage(){
        PageFactory.initElements(driver, this);
    }
    public String ValidatePageTitle(){
        return driver.getTitle();
    }

    public void ClickonMyviewTab(){
        javascripthelper.clickElement(webMyviewTab);
        waithelper.waitForElement(webWorklistRecords,40);
    }

    public boolean ValidateTeamViewWidgets() {
        boolean result = (webWorklist.getAttribute("innerText").equals("Worklist")) &&
                (webChannelProgress.getAttribute("innerText").equals("CRI Pending For Processing")) &&
                (webChannelProgress.getAttribute("innerText").equals("Channel Progress")) &&
                (webContentiousProgramme.getAttribute("innerText").equals("Contentious Programme")) &&
                (webReserveList.getAttribute("innerText").equals("Reserve List")) &&
                (webCopyAssignment.getAttribute("innerText").equals("Copy Assignment")) &&
                (webCopySummary.getAttribute("innerText").equals("Copy Summary"));
                 return result;
    }

    public List<String> VerifyTopMenuItems() throws InterruptedException {
        List<String> TopMenuValue = new ArrayList<String>();
        String Beforepath="//*[@id=\"TopMenu\"]/li[";
        String AfterPath="]";
        for(int i=1;i<7;i++){
            //String Value=driver.findElement(By.xpath(Beforepath+(i+1)+AfterPath)).getAttribute("innerText");
            String Value=driver.findElement(By.xpath(Beforepath+(i+1)+AfterPath)).getText();
            System.out.println("Value is "+Value);
            TopMenuValue.add(Value);
            Thread.sleep(500);
        }
        return TopMenuValue;
    }
    public String Setupmenu(){
        String SetupMenu=webSetUpMenu.getAttribute("innerText");
        return SetupMenu;
    }
    public String Findmenu(){
        String FindMenu=webFindMenu.getAttribute("innerText");
        return FindMenu;
    }
    public String Actionmenu(){
        String ActionMenu=webActionMenu.getAttribute("innerText");
        return ActionMenu;
    }
    public String SequenceBreakmenu(){
        String SequenceBreak=webSequenceBreaksMenu.getAttribute("innerText");
        return SequenceBreak;
    }
    public String GeneratePlaylistmenu(){
        String GeneratePlaylist=WebGeneratePlaylistsMenu.getAttribute("innerText");
        return GeneratePlaylist;
    }
    public String ApplicationMenu(){
        String ApplicationMenu=webApplicationMenu.getAttribute("innerText");
        return ApplicationMenu;
    }


    public void ValidateMyViewWidgets() {


    }
}

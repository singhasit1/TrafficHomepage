package com.project.page;

import com.google.common.base.Verify;
import com.project.base.baseclass;
import com.project.helper.Action.TrafficMenu;
import com.project.helper.JavaScript.JavaScriptHelper;
import com.project.helper.Logger.LoggerHelper;
import com.project.helper.Wait.WaitHelper;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;


public class TeamViewPage extends baseclass {

    public static final Logger log = Logger.getLogger(TeamViewPage.class.getName());

    @FindBy(id = "00000000-0000-0000-0000-000000000000_27a7f512-7eff-b07f-cfce-0e4f1a0d490b")
    private WebElement webRefreshButton;
    @FindBy(xpath = "//span[@name='User Name Data Label']")
    private  WebElement webLoggedInUser;
    @FindBy(xpath = "//img[@class='picture-control-inline' and @src='/Runtime/Image.ashx?ImID=59']")
    private WebElement webCompanyLogo;
    @FindBy(xpath = "//*[contains(text(),'No Stellar User is mapped with')]")
    private WebElement WarningMessage;

    @FindBy(xpath = "//*[@id=\"00000000-0000-0000-0000-000000000000_4e03e453-4f43-66ee-3ee8-0468c23af24d\"]/span/span")
    private WebElement webTeamviewTab;

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='http://www.k2.com'])[2]/following::div[3]")
    private  WebElement webSetUpMenu;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Set Up'])[2]/following::a[1]")
    private  WebElement webNewCopy;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='NEW COPY'])[2]/following::a[1]")
    private  WebElement webNewRotation;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='NEW ROTATION'])[2]/following::div[1]")
    private  WebElement webProcessCompanies;

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='PROCESS COMPANIES'])[2]/following::div[1]")
    private  WebElement webFindMenu;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='FIND'])[2]/following::a[1]")
    private  WebElement webFindRotation;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='FIND ROTATION'])[2]/following::a[1]")
    private  WebElement webFindCri;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Find CRI'])[2]/following::a[1]")
    private  WebElement webFindBreak;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='FIND BREAK'])[2]/following::a[1]")
    private  WebElement webFindCopy;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='FIND COPY'])[2]/following::a[1]")
    private  WebElement webFindProduct;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='FIND PRODUCT'])[2]/following::a[1]")
    private  WebElement webFindSpot;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='FIND SPOT'])[2]/following::div[1]")
    private  WebElement webTrafficSupportAdvanced;
    @FindBy(xpath = "(//ul[@id='TopMenu']/li[3]/ul/li[8]/table/tbody/tr/td/a/div)[2]")
    private  WebElement webFindCommonRotation;

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='FIND COMMON ROTATIONS'])[2]/following::div[1]")
    private WebElement webActionMenu;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='ACTION'])[2]/following::a[1]")
    private  WebElement webAssignCopy;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='ASSIGN COPY'])[2]/following::div[1]")
    private  WebElement webAssignCreditCopy;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='ASSIGN CREDIT COPY'])[2]/following::div[1]")
    private  WebElement webAmendAirtimeStatus;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='AMEND AIRTIME STATUS'])[2]/following::div[1]")
    private  WebElement webGenerateTransmissionLog;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='GENERATE TRANSMISSION LOG'])[2]/following::div[1]")
    private  WebElement webCertificateViolationCopy;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='CERTIFICATE VIOLATION – COPY'])[2]/following::div[1]")
    private  WebElement webCertificationViolationProduct;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='CERTIFICATE VIOLATION – PRODUCT'])[2]/following::div[1]")
    private WebElement webRequestPrivilege;

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Request Privilege'])[2]/following::div[1]")
    private WebElement webSequenceBreaksMenu;

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='SEQUENCE BREAKS'])[2]/following::div[1]")
    private WebElement WebGeneratePlaylistsMenu;

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='GENERATE PLAYLISTS'])[2]/following::div[1]")
    private WebElement webApplicationMenu;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Application'])[2]/following::a[1]")
    private WebElement webAdStream;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='AdStream'])[2]/following::a[1]")
    private WebElement webImd;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='IMD'])[2]/following::a[1]")
    private WebElement webHoneycomb;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Honeycomb'])[2]/following::a[1]")
    private WebElement webCopyCentral;

    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Copycentral'])[2]/following::span[3]")
    private  WebElement webWorklist;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='of 1'])[18]/following::span[9]")
    private  WebElement webContentiousProgramme;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='of 1'])[17]/following::span[9]")
    private  WebElement webCriPendingForProcessing;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='of 1'])[10]/following::span[9]")
    private  WebElement webChannelProgress;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='of 1'])[11]/following::span[9]")
    private WebElement webReserveList;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='of 1'])[12]/following::span[9]")
    private WebElement webCopyAssignment;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='of 1'])[15]/following::span[9]")
    private WebElement webCopySummary;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='of 1'])[14]/following::span[9]")
    private WebElement webCopyApprovedDelivered;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='of 1'])[13]/following::span[9]")
    private WebElement webProductAwaitingApproval;
    @FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='of 1'])[16]/following::span[9]")
    private WebElement webOutstandingAsRunLogs;

    JavaScriptHelper javascripthelper = new JavaScriptHelper(driver);
    TrafficMenu trafficmenu = new TrafficMenu();
    SoftAssert softAssertion= new SoftAssert();
    WaitHelper waithelper = new WaitHelper(driver);


    public TeamViewPage() {
        PageFactory.initElements(driver, this);
    }

    public String ValidatePageTitle() {
        return driver.getTitle();
    }

    public boolean ValidateC4Image() {
        return webCompanyLogo.isDisplayed();
    }

    public boolean VerifyLoggedInUser(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("c6762578-70f2-1311-522c-e4d96103533f_d4cf2299-6305-4a5d-a906-87f151539c03")));
        boolean LogggedInUser=webLoggedInUser.isDisplayed();
        return LogggedInUser;
    }

    public boolean ValidateTeamViewWidgets() {
        boolean result = (webWorklist.getAttribute("innerText").equals("Worklist")) &&
                (webCriPendingForProcessing.getAttribute("innerText").equals("CRI Pending For Processing")) &&
                (webChannelProgress.getAttribute("innerText").equals("Channel Progress")) &&
                (webContentiousProgramme.getAttribute("innerText").equals("Contentious Programme")) &&
                (webReserveList.getAttribute("innerText").equals("Reserve List")) &&
                (webCopyAssignment.getAttribute("innerText").equals("Copy Assignment")) &&
                (webCopySummary.getAttribute("innerText").equals("Copy Summary")) &&
                (webCopyApprovedDelivered.getAttribute("innerText").equals("Copy Approved/Delivered")) &&
                (webProductAwaitingApproval.getAttribute("innerText").equals("Product Awaiting Approval")) &&
                (webOutstandingAsRunLogs.getAttribute("innerText").equals("Outstanding As-Run Logs"));
        return result;
    }

   public boolean VerifyTopMenuItems() {
       boolean result = (webWorklist.getAttribute("innerText").equals("Set Up")) &&
               (webCriPendingForProcessing.getAttribute("innerText").equals("FIND")) &&
               (webChannelProgress.getAttribute("innerText").equals("ACTION")) &&
               (webContentiousProgramme.getAttribute("innerText").equals("SEQUENCE BREAKS")) &&
               (webReserveList.getAttribute("innerText").equals("GENERATE PLAYLISTS")) &&
               (webOutstandingAsRunLogs.getAttribute("innerText").equals("Application"));
       return result;
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


    public void VerifySetupSubmenu() {
        softAssertion.assertEquals(webNewCopy.getAttribute("innerText"), "NEW COPY");
        softAssertion.assertEquals(webNewRotation.getAttribute("innerText"), "NEW ROTATION");
        softAssertion.assertEquals(webProcessCompanies.getAttribute("innerText"), "PROCESS COMPANIES");
        softAssertion.assertAll();
       }

    public void VerifyFindSubmenu() {
        softAssertion.assertEquals(webFindRotation.getAttribute("innerText"), "FIND ROTATION");
        softAssertion.assertEquals(webFindCri.getAttribute("innerText"), "FIND CRI");
        softAssertion.assertEquals(webFindBreak.getAttribute("innerText"), "FIND BREAK");
        softAssertion.assertEquals(webFindCopy.getAttribute("innerText"), "FIND COPY");
        softAssertion.assertEquals(webFindProduct.getAttribute("innerText"), "FIND PRODUCT");
        softAssertion.assertEquals(webFindSpot.getAttribute("innerText"), "FIND SPOT");
        softAssertion.assertEquals(webTrafficSupportAdvanced.getAttribute("innerText"), "FIND TRAFFIC SUPER ADVANCED");
        softAssertion.assertEquals(webFindCommonRotation.getAttribute("innerText"), "FIND COMMON ROTATIONS");
        softAssertion.assertAll();
    }
    public void VerifyActionSubmenu() {
        softAssertion.assertEquals(webAssignCopy.getAttribute("innerText"), "ASSIGN COPY");
        softAssertion.assertEquals(webAssignCreditCopy.getAttribute("innerText"), "ASSIGN CREDIT COPY");
        softAssertion.assertEquals(webAmendAirtimeStatus.getAttribute("innerText"), "AMEND AIRTIME STATUS");
        softAssertion.assertEquals(webGenerateTransmissionLog.getAttribute("innerText"), "GENERATE TRANSMISSION LOG");
        softAssertion.assertEquals(webCertificateViolationCopy.getAttribute("innerText"), "CERTIFICATE VIOLATION – COPY");
        softAssertion.assertEquals(webCertificationViolationProduct.getAttribute("innerText"), "CERTIFICATE VIOLATION – PRODUCT");
        softAssertion.assertEquals(webRequestPrivilege.getAttribute("innerText"), "Request Privilege");
        softAssertion.assertAll();
    }
    public void VerifyApplicationSubmenu() {
        softAssertion.assertEquals(webAdStream.getAttribute("innerText"), "ADSTREAM");
        softAssertion.assertEquals(webImd.getAttribute("innerText"), "IMD");
        softAssertion.assertEquals(webHoneycomb.getAttribute("innerText"), "HONEYCOMB");
        softAssertion.assertEquals(webCopyCentral.getAttribute("innerText"), "COPYCENTRAL");
        softAssertion.assertAll();
    }

    public String VerifyUsernotMapped() {
        waithelper.waitForElement(WarningMessage,40);
        String Warningmsg = WarningMessage.getAttribute("innerText");
        return Warningmsg;
    }
    public boolean VerifyRefreshButton() {
        boolean EnableRefreshButton = webRefreshButton.isEnabled();
        return EnableRefreshButton;
    }

    public void ClickOnSetupMenu(){
        trafficmenu.MouseOver(webSetUpMenu);
    }
    public void ClickOnFindmenu(){
         trafficmenu.MouseOver(webFindMenu);
    }

    public void ClickOnActionmenu(){
        trafficmenu.MouseOver(webActionMenu);
    }


    public void ClickOnSequenceBreakmenu(){
        trafficmenu.MouseOver(webSequenceBreaksMenu);
    }

    public void ClickOnGeneratePlaylistmenu(){
        trafficmenu.MouseOver(WebGeneratePlaylistsMenu);
    }

    public void ClickOnApplicationmenu(){
        trafficmenu.MouseOver(webApplicationMenu);
        waithelper.waitForElement(webCopyCentral,20);
    }



    public List<String> getActionMenu() throws InterruptedException {
        List<String> ActionMenuValue = new ArrayList<String>();
        String Beforepath="//*[@id='TopMenu']/li[4]/ul/li[";
        String AfterPath="]/table/tbody/tr/td/a/div";
        for(int i=0;i<7;i++){
            String Value=driver.findElement(By.xpath(Beforepath+(i+1)+AfterPath)).getAttribute("innerText");
            System.out.println("Value is "+Value);
            Thread.sleep(50);
            ActionMenuValue.add(Value);
        }
        return ActionMenuValue;
    }
    public String VerifyUserName( ){
        String LoggedInUser=webLoggedInUser.getAttribute("innerText");
        return LoggedInUser;
    }
    public void resultset(String Query) throws Throwable {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con= DriverManager.getConnection("jdbc:oracle:thin:@C-STELL-DEVORA01:1521:REDTEST","stowner","stowner");
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(Query);
        ResultSet rs1=stmt.executeQuery("commit");
        con.close();
    }
}







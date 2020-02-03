package com.project.page;

import com.project.base.baseclass;
import com.project.helper.Action.TrafficMenu;
import com.project.helper.JavaScript.JavaScriptHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;


public class SponorshipPage extends baseclass {
    @FindBy(xpath="//span[text()='Sponsorship'][@class=\"tab-text\"]")
    WebElement webSponorshipTab;
    @FindBy(xpath = "//span[@data-sf-title=\"Sponsorship Credits And Breaks\"]")
    private WebElement webSponorshipCreditsandBreaksWidget;
    @FindBy(xpath = "//span[@data-sf-title=\"Final Credit Pattern\"]")
    private WebElement webFinalCreditPatternWidget;
    @FindBy(xpath = "//span[@data-sf-title=\"Sponsorship Campaigns\"]")
    private WebElement webSponorshipCampaignWidget;
    @FindBy(xpath = "//a[@name=\"btnSponsorshipRefresh\"]")
    private WebElement webRefreshButton;
    @FindBy(xpath = "//*[@id=\"TopMenu\"]/li[2]/table/tbody/tr/td/a/div[text()='Find']")
    private WebElement webFindMenu;
    @FindBy(xpath = "//*[@id=\"TopMenu\"]/li[3]/table/tbody/tr/td/a/div[text()=\"APPLICATION\"]")
    private WebElement webApplicationMenu;
    @FindBy(xpath = "//*[@id=\"TopMenu\"]/li[2]/ul/li[1]/table/tbody/tr/td/a/div[text()=\"LFT BREAKS WITH AVAILABILITY\"]")
    private WebElement webLftBreaksWithAvailability;
    @FindBy(xpath = "//*[@id=\"TopMenu\"]/li[2]/ul/li[2]/table/tbody/tr/td/a/div[text()=\"LFT BREAKS WITH CERTIFICATE\"]")
    private WebElement webLftBreaksWithCertificate;
    @FindBy(xpath = "//*[@id=\"TopMenu\"]/li[3]/ul/li[1]/table/tbody/tr/td/a/div[text()=\"AdStream\"]")
    private WebElement webAdstream;
    @FindBy(xpath = "//*[@id=\"TopMenu\"]/li[3]/ul/li[2]/table/tbody/tr/td/a/div[text()=\"IMD\"]")
    private WebElement webImd;
    @FindBy(xpath = "//*[@id=\"TopMenu\"]/li[3]/ul/li[3]/table/tbody/tr/td/a/div[text()=\"Honeycomb\"]")
    private WebElement webHoneyComb;
    @FindBy(xpath = "//*[@id=\"TopMenu\"]/li[3]/ul/li[4]/table/tbody/tr/td/a/div[text()=\"Copycentral\"]")
    private WebElement webCopyCentral;


    TrafficMenu trafficmenu = new TrafficMenu();
    JavaScriptHelper javascripthelper = new JavaScriptHelper(driver);
    SoftAssert softAssertion= new SoftAssert();

    public SponorshipPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean ValidateSponorshipWidgets() {
                boolean SponorshipWidgets = (webSponorshipCreditsandBreaksWidget.getAttribute("innerText").equals("Sponsorship Credits And Breaks")) &&
                (webFinalCreditPatternWidget.getAttribute("innerText").equals("Final Credit Pattern")) &&
                (webSponorshipCampaignWidget.getAttribute("innerText").equals("Sponsorship Campaigns"));
                return SponorshipWidgets;
                }

     public void navigatetoSponsorshipTab()
     {
         javascripthelper.clickElement(webSponorshipTab);
     }
    public String FindMenu(){
        String findmenu=webFindMenu.getAttribute("innerText");
        return findmenu;
    }
    public String ApplicationMenu(){
        String AppMenu=webApplicationMenu.getAttribute("innerText");
        return AppMenu;
    }
    public void ClickOnApplicationmenu(){
        trafficmenu.MouseOver(webApplicationMenu);
    }
    public void VerifySponFindSubmenu() {
        softAssertion.assertEquals(webLftBreaksWithAvailability.getAttribute("innerText"), "LFT BREAKS WITH AVAILABILITY");
        softAssertion.assertEquals(webLftBreaksWithCertificate.getAttribute("innerText"), "LFT BREAKS WITH CERTIFICATE");
        softAssertion.assertAll();
    }
    public void ClickOnFindmenu(){
        trafficmenu.MouseOver(webFindMenu);
    }

    public void VerifySponApplicationSubmenu() {
        softAssertion.assertEquals(webAdstream.getAttribute("innerText"), "ADSTREAM");
        softAssertion.assertEquals(webImd.getAttribute("innerText"), "IMD");
        softAssertion.assertEquals(webHoneyComb.getAttribute("innerText"), "HONEYCOMB");
        softAssertion.assertEquals(webCopyCentral.getAttribute("innerText"), "COPYCENTRAL");
        softAssertion.assertAll();
    }



}

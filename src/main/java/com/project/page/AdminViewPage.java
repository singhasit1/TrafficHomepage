package com.project.page;

import com.project.base.baseclass;
import com.project.helper.JavaScript.JavaScriptHelper;
import com.project.helper.Wait.WaitHelper;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class AdminViewPage extends baseclass {

    @FindBy(xpath="//*[@id=\"00000000-0000-0000-0000-000000000000_4c48a59e-5d1e-ce6a-fc37-e5812c7d4437\"]/span/span")
    private WebElement AdminViewTab;
    @FindBy(xpath = "//*[@id=\"9b1e4f63-e161-49e8-8e03-31afe87c38fb_4c48a59e-5d1e-ce6a-fc37-e5812c7d4437_bb8719f3-cd49-587d-9d12-8d127509fd44_389d5611-d759-47a3-aa4b-9b3e737bd133\"]/div[1]/div/div[1]/span[text()=\"Channel Responsibilities\"]")
    private WebElement Channel_Responsibilities;
    @FindBy(xpath="//*[@id=\"9b1e4f63-e161-49e8-8e03-31afe87c38fb_4c48a59e-5d1e-ce6a-fc37-e5812c7d4437_957df475-2bfa-bbe7-8f4f-880aabcc17f2_1b2668c9-85e7-456a-9a49-a3f0eda93226\"]/div[1]/div/div[1]/span")
    private  WebElement Channel_Group_Responsibilities;
    @FindBy(xpath="//*[@id=\"9b1e4f63-e161-49e8-8e03-31afe87c38fb_4c48a59e-5d1e-ce6a-fc37-e5812c7d4437_ed82c0b8-2af5-6768-69cc-6c4120304725_22bce406-db0c-4cca-b498-7491e40c2343\"]/div[1]/div/div[1]/span")
    private WebElement Filling_Rota;
    @FindBy(xpath="//*[@id=\"9b1e4f63-e161-49e8-8e03-31afe87c38fb_4c48a59e-5d1e-ce6a-fc37-e5812c7d4437_b9a0960d-a297-ecd1-a7d0-fc33edb82935_66689cfc-cf24-40ef-8217-03f0de8da6ba\"]/div[1]/div/div[1]/span")
    private WebElement Stay_Late_Rota;
    @FindBy(xpath="//*[@id=\"9b1e4f63-e161-49e8-8e03-31afe87c38fb_4c48a59e-5d1e-ce6a-fc37-e5812c7d4437_75a56975-3d38-a14f-c4f9-2d6088c394b4_7223e145-d855-422b-8c38-ce0e0fbb3704\"]/div[1]/div/div[1]/span")
    private  WebElement Reserves;
    @FindBy(xpath="//*[@id=\"9b1e4f63-e161-49e8-8e03-31afe87c38fb_4c48a59e-5d1e-ce6a-fc37-e5812c7d4437_979ea219-2eea-768b-aac2-24d8aef17fc3_5352818e-7817-4922-bb15-c01e1650c4d5\"]/div[1]/div/div[1]/span")
    private  WebElement Traffic_Product_Allocation;
    //Channel responsibilities Web Component
    @FindBy(xpath="//*[@id=\"bb8719f3-cd49-587d-9d12-8d127509fd44_1b3c7a18-ab88-4992-4b13-5c6ca9a2f021_TextBox\"]")
    private  WebElement Channel_Responsibilities_Start_Date;
    @FindBy(xpath="//*[@id=\"bb8719f3-cd49-587d-9d12-8d127509fd44_cd5e5011-d1a8-753b-a564-450fd8dc1331_TextBox\"]")
    private  WebElement Channel_Responsibilities_End_Date;
    @FindBy(xpath="//*[@id=\"bb8719f3-cd49-587d-9d12-8d127509fd44_93ebedb4-9b51-f0f3-574a-1abd63667a37_ToolbarButton\"]/span[2]/span[2]")
    private  WebElement Channel_Responsibilities_View;
    @FindBy(xpath="//*[@id=\"bb8719f3-cd49-587d-9d12-8d127509fd44_cd5e5011-d1a8-753b-a564-450fd8dc1331_TextBox\"]")
    private  WebElement Channel_Responsibilities_View_AllUpdate_Button;
    @FindBy(xpath="//*[@id='00000000-0000-0000-0000-000000000000_0df293a8-4143-4293-83cf-37aacecdfc0d_ToolbarButton']/span[2]/span[2]")
    private WebElement Channel_Responsibilities_Auto_Generate_Button;
    @FindBy(xpath="//*[@id=\"9b1e4f63-e161-49e8-8e03-31afe87c38fb_4c48a59e-5d1e-ce6a-fc37-e5812c7d4437_bb8719f3-cd49-587d-9d12-8d127509fd44_389d5611-d759-47a3-aa4b-9b3e737bd133\"]/div[6]/div/div/div/a[3]/span[2]/span")
    private  WebElement Channel_Responsibilities_Next_Page;
    @FindBy(xpath="//*[@id=\"PopupWin_1531745770418\"]/div[2]/div[2]/div/div/div/div/div[2]/div[2]/div")
    private WebElement AutogenerateWarningMessage;
    @FindBy(xpath="//*[@id=\"PopupWin_1531745770418\"]/div[3]/div[2]/a[1]")
    private  WebElement AcceptWarningMessage;
    @FindBy(xpath = "//*[@id='9b1e4f63-e161-49e8-8e03-31afe87c38fb_4c48a59e-5d1e-ce6a-fc37-e5812c7d4437_bb8719f3-cd49-587d-9d12-8d127509fd44_389d5611-d759-47a3-aa4b-9b3e737bd133']/div[6]/div/div/div/a[3]/span[2]/span")
    private   WebElement NextPage;
    @FindBy(xpath = "//*[@id=\"bb8719f3-cd49-587d-9d12-8d127509fd44_af6922d0-f08c-44e6-8d87-051ff940dc09_ToolbarButton\"]/span[2]/span[2]")
    private WebElement Channel_Responsibilities_ViewAll;
    @FindBy(xpath = "//*[@title=\"Channel Responsibilities\"]")
    private  WebElement Channel_Responsibilities_ViewAll_Title;
    @FindBy(xpath = "//*[@id=\"_3e721c41-12d0-46e6-8836-ef59c9037c34\"]/div[2]/div[2]/div/div/table/tbody/tr[1]/td[3]/div/div")
    private   WebElement Channel_Responsibilities_ViewAll_UpdateUsername;
    @FindBy(xpath = "//*[@id='_3e721c41-12d0-46e6-8836-ef59c9037c34']/div[2]/div[2]/div/div/table/tbody/tr[1]/td[3]")
    private  WebElement Update_Username;
    @FindBy(xpath = "//*[@id='00000000-0000-0000-0000-000000000000_165b3b9a-a07f-7e75-fa28-6fbafab47bdc']/div/div[1]/div[2]/div[2]/div/a/span")
    private  WebElement Dropdown_List;
    @FindBy(xpath = "//*[@id='00000000-0000-0000-0000-000000000000_165b3b9a-a07f-7e75-fa28-6fbafab47bdc_droplist']/div[2]/div[2]/div/ul/li")
    List<WebElement> Dropdown_List_Value;
    @FindBy(xpath = "//*[@id='00000000-0000-0000-0000-000000000000_ce513296-3119-bab1-b593-571e714318fe_ToolbarButton']/span[2]/span[2]")
    private  WebElement Update_Row;
    @FindBy(xpath = "//*[@id='00000000-0000-0000-0000-000000000000_dcbbd640-38b7-ad2d-1762-4fbd29b2d9d8_ToolbarButton']/span[2]/span[2]")
    private WebElement Save_Record;
    @FindBy(xpath = "//*[@id=\"9b1e4f63-e161-49e8-8e03-31afe87c38fb_4c48a59e-5d1e-ce6a-fc37-e5812c7d4437_bb8719f3-cd49-587d-9d12-8d127509fd44_389d5611-d759-47a3-aa4b-9b3e737bd133\"]/div[3]/div[2]/div/div/table/tbody/tr[1]/td[3]/div/div/span")
    private  WebElement View_UserName;
    @FindBy(xpath = "//*[@id=\"_3e721c41-12d0-46e6-8836-ef59c9037c34\"]/div[2]/div[2]/div/div/table/tbody/tr[1]/td[3]/div/div/span")
    private WebElement ViewAll_UserName;
    @FindBy(xpath = "//*[@id='9b1e4f63-e161-49e8-8e03-31afe87c38fb_4c48a59e-5d1e-ce6a-fc37-e5812c7d4437_bb8719f3-cd49-587d-9d12-8d127509fd44_389d5611-d759-47a3-aa4b-9b3e737bd133']/div[3]/div[1]/div/table/tbody/tr/td/div")
    List<WebElement> Column_Name;

    JavaScriptHelper javascripthelper = new JavaScriptHelper(driver);
    WaitHelper waithelper = new WaitHelper(driver);

    public AdminViewPage(){
        PageFactory.initElements(driver, this);
    }
    public void NavigateToAdminTab() throws InterruptedException {
        javascripthelper.clickElement(AdminViewTab);
       //  WebElement Records=driver.findElement(By.xpath("//*[@id=\"9b1e4f63-e161-49e8-8e03-31afe87c38fb_4c48a59e-5d1e-ce6a-fc37-e5812c7d4437_75a56975-3d38-a14f-c4f9-2d6088c394b4_7223e145-d855-422b-8c38-ce0e0fbb3704\"]/div[3]/div[2]/div/div/table/tbody/tr[3]/td[2]"));
      //  waithelper.waitForElement(Records,30);
       // WebDriverWait wait = new WebDriverWait(driver, 30);
      //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("00000000-0000-0000-0000-000000000000_0676525a-4c9c-68a0-51a9-3082d31f6b45")));
    }

    public boolean ValidateAdminViewWidgets() {
        boolean result = (Channel_Responsibilities.getAttribute("innerText").equals("Channel Responsibilities")) &&
                (Channel_Group_Responsibilities.getAttribute("innerText").equals("Channel Group Responsibilities")) &&
                (Filling_Rota.getAttribute("innerText").equals("Filling Rota")) &&
                (Stay_Late_Rota.getAttribute("innerText").equals("Stay Late Rota")) &&
                (Reserves.getAttribute("innerText").equals("Reserves")) &&
                (Traffic_Product_Allocation.getAttribute("innerText").equals("Traffic Product Allocation"));
        return result;
    }
    public void SetDateRange(String Start_Date,String End_Date) throws InterruptedException {
        Channel_Responsibilities_Start_Date.clear();
        Thread.sleep(500);
        Channel_Responsibilities_Start_Date.sendKeys(Start_Date);
        Thread.sleep(500);
        Channel_Responsibilities_Start_Date.sendKeys(Keys.TAB);
        Channel_Responsibilities_Start_Date.sendKeys(Keys.TAB);
        Channel_Responsibilities_End_Date.clear();
        Channel_Responsibilities_End_Date.sendKeys(End_Date);
        Thread.sleep(500);
        Channel_Responsibilities_End_Date.sendKeys(Keys.TAB);
        Channel_Responsibilities_End_Date.sendKeys(Keys.TAB);
        Thread.sleep(500);
    }
    public void ClickonViewButton(){
        javascripthelper.clickElement(Channel_Responsibilities_View);
        }
    public void ClickonAutogenerate() throws InterruptedException {
        WebElement Frame =driver.findElement(By.className("runtime-popup"));
        driver.switchTo().frame(Frame);
        javascripthelper.clickElement(Channel_Responsibilities_Auto_Generate_Button);
       // executor.executeScript("arguments[0].click();", Channel_Responsibilities_Auto_Generate_Button);
        Thread.sleep(500);
    }

    public void AcceptWaringMessage() throws InterruptedException {
        driver.switchTo().defaultContent();
        try{
            String WarningMessage ="This will reset the Channel Responsibilities data. Press \"OK\" to continue or press \"Cancel\" to cancel Auto-generation process.";
            String TextMessage = driver.findElement(By.xpath("//*[@id=\"PopupWin_1535527130083\"]/div[2]/div[2]/div/div/div/div/div[2]/div[2]/div")).getAttribute("innerText");
            Assert.assertEquals(WarningMessage,TextMessage);
        }
        catch (Exception e){
            System.out.println(e);
        }
        try{
            driver.findElement(By.linkText("OK")).click();
            Thread.sleep(500);
        }
        catch(Exception e1){
            System.out.println(e1);
        }
    }
    public void ClickonViewAll(){
        javascripthelper.clickElement(Channel_Responsibilities_ViewAll);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public int CountRecords( int Row_Count) throws InterruptedException {
        if (NextPage.isEnabled()) {
            System.out.println("Button is Enable");
            javascripthelper.clickElement(NextPage);
            Thread.sleep(10000);
            WebElement Pager = driver.findElement(By.xpath("//*[@id='9b1e4f63-e161-49e8-8e03-31afe87c38fb_4c48a59e-5d1e-ce6a-fc37-e5812c7d4437_bb8719f3-cd49-587d-9d12-8d127509fd44_389d5611-d759-47a3-aa4b-9b3e737bd133_pagingtxtbox']"));
            String Value12 = Pager.getAttribute("value");
            System.out.println("Click on Page :: " + Value12);
            List<WebElement> RowCount = driver.findElements(By.xpath("//*[@id='9b1e4f63-e161-49e8-8e03-31afe87c38fb_4c48a59e-5d1e-ce6a-fc37-e5812c7d4437_bb8719f3-cd49-587d-9d12-8d127509fd44_389d5611-d759-47a3-aa4b-9b3e737bd133']/div[3]/div[2]/div/div/table/tbody/tr"));
            System.out.println("Total Number of Row ::" + RowCount.size());
            Row_Count = RowCount.size();
            Thread.sleep(500);

        } else {
            System.out.println("Button is disable");
        }
        return Row_Count;
    }

    public String Channel_repsonsibilites_viewAll_title(){
        String Title =Channel_Responsibilities_ViewAll_Title.getAttribute("innerHTML");
        return Title;
    }

    public void SetUserName(String SelectUser) throws InterruptedException {
        WebElement Frame =driver.findElement(By.className("runtime-popup"));
        driver.switchTo().frame(Frame);
        WebElement Update=driver.findElement(By.xpath("//*[@id='_3e721c41-12d0-46e6-8836-ef59c9037c34']/div[2]/div[2]/div/div/table/tbody/tr[1]/td[3]"));
        Actions action = new Actions(driver).doubleClick(Update);
        action.build().perform();
        System.out.println("double Click happen");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        javascripthelper.clickElement(Dropdown_List);
        System.out.println("Total Count is "+Dropdown_List_Value.size());
        Dropdown_List.click();
        for ( WebElement UserListValues: Dropdown_List_Value) {
            Thread.sleep(500);
            if (SelectUser.equalsIgnoreCase(UserListValues.getAttribute("innerText"))){
                javascripthelper.clickElement(UserListValues);
                System.out.println("Record found and update");
                break;
            }
            else{
                System.out.println("Value is "+UserListValues.getAttribute("innerText"));

            }
        }
        Update_Row.click();
        Save_Record.click();
        javascripthelper.clickElement(Channel_Responsibilities_View);
        Thread.sleep(1000);
    }

    public String View_UserName(){
        String GetUsername=View_UserName.getText();
        return GetUsername;
    }
    public String ViewAll_UserName(){

        String GetUsername=ViewAll_UserName.getAttribute("innerText");
        return GetUsername;
    }
    public List<String> Verify_Channel_Channel_Responsibilty_Column_Name() throws InterruptedException {
        List<String> Channel_Channel_Responsibilty_Column_Name = new ArrayList<String>();
        for (WebElement ele : Column_Name) {
            String Column_Name = ele.getText();
            System.out.println("Column Name : " + Column_Name);
            Thread.sleep(500);
            Channel_Channel_Responsibilty_Column_Name.add(Column_Name);
        }
        return Channel_Channel_Responsibilty_Column_Name;
    }

}




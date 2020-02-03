package com.project.page;


import com.project.base.baseclass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ContentiousProgrammePage extends baseclass {

    @FindBy(xpath = "//*[@id=\"9b1e4f63-e161-49e8-8e03-31afe87c38fb_4e03e453-4f43-66ee-3ee8-0468c23af24d_d41ded53-6fbc-3d3d-517d-b883b38079a0_b0a3ee5d-9d7f-4014-be64-9fee79fd871f\"]/div[3]/div[1]/div/table/tbody/tr/td")
    List<WebElement> Column_Name;
    @FindBy(xpath = "//*[@id=\"d41ded53-6fbc-3d3d-517d-b883b38079a0_e3ee221e-fe07-e743-0b76-8698371b9c33_TextBox\"]")
    WebElement Contentious_Programme_Start_Date;
    @FindBy(xpath = "//*[@id=\"d41ded53-6fbc-3d3d-517d-b883b38079a0_a23289d9-26e4-b975-7077-86c89e078caf_TextBox\"]")
    WebElement Contentious_Programme_End_Date;
    @FindBy(xpath = "//*[@id=\"d41ded53-6fbc-3d3d-517d-b883b38079a0_e635e4a1-5bad-4837-5417-7578bf045027_ToolbarButton\"]/span[2]/span[2]")
    WebElement Contentious_Programme_View;
    @FindBy(xpath = "//*[@id=\"d41ded53-6fbc-3d3d-517d-b883b38079a0_321c17ef-d339-40a6-ad46-a0c4187758a7_ToolbarButton\"]/span[2]/span[2]")
    WebElement Contentious_Programme_View_All;
    @FindBy(xpath = "//*[@id=\"9b1e4f63-e161-49e8-8e03-31afe87c38fb_4e03e453-4f43-66ee-3ee8-0468c23af24d_d41ded53-6fbc-3d3d-517d-b883b38079a0_b0a3ee5d-9d7f-4014-be64-9fee79fd871f\"]/div[6]/div/div/div/a[3]/span[2]/span")
    WebElement NextPage;
    @FindBy(xpath = "//*[@id=\"9b1e4f63-e161-49e8-8e03-31afe87c38fb_4e03e453-4f43-66ee-3ee8-0468c23af24d_d41ded53-6fbc-3d3d-517d-b883b38079a0_b0a3ee5d-9d7f-4014-be64-9fee79fd871f\"]/div[3]/div[2]/div/div/table/tbody/tr[1]/td[4]/div/div/span")
    WebElement TransmisstionDate;
    @FindBy(xpath = "//*[@id=\"_3258a2a2-b38c-4c27-ba11-47e55a28d03a\"]/div[2]/div[2]/div/div/table/tbody/tr[1]/td[4]/div/div/span")
    WebElement TransmisstionDateValue;
    @FindBy(xpath = "//*[@id=\"_3258a2a2-b38c-4c27-ba11-47e55a28d03a\"]/div[2]/div[2]/div/div/table/tbody/tr")
    List<WebElement> ViewAllRecordCount;

    JavascriptExecutor executor = (JavascriptExecutor)driver;
    public ContentiousProgrammePage(){
        PageFactory.initElements(driver, this);
    }

    public List<String> Verify_Contentious_Programme_Column_Name() throws InterruptedException {
        List<String> Channel_Channel_Responsibilty_Column_Name = new ArrayList<String>();
        for (WebElement ele : Column_Name) {
            String Column_Name = ele.getText();
            Thread.sleep(500);
            Channel_Channel_Responsibilty_Column_Name.add(Column_Name);
        }
        return Channel_Channel_Responsibilty_Column_Name;
    }

    public void SetDateRange(String Start_Date,String End_Date) throws InterruptedException {
        Contentious_Programme_Start_Date.clear();
        Contentious_Programme_Start_Date.sendKeys(Start_Date);
        Thread.sleep(500);
        Contentious_Programme_Start_Date.sendKeys(Keys.TAB);
        Contentious_Programme_Start_Date.sendKeys(Keys.TAB);
        Contentious_Programme_End_Date.click();
        Contentious_Programme_End_Date.clear();
        Contentious_Programme_End_Date.sendKeys(End_Date);
        Thread.sleep(500);
        Contentious_Programme_End_Date.sendKeys(Keys.TAB);
        Contentious_Programme_End_Date.sendKeys(Keys.TAB);
        Thread.sleep(500);
    }
    public void ClickonViewButton(){
        executor.executeScript("arguments[0].click();", Contentious_Programme_View);
    }
    public void ClickonViewAll() throws InterruptedException {executor.executeScript("arguments[0].click();", Contentious_Programme_View_All);
    Thread.sleep(10000);
    }

    public int CountRecords( int Row_Count) throws InterruptedException {
        if (NextPage.isEnabled()) {
            System.out.println("Button is Enable");
            executor.executeScript("arguments[0].click();", NextPage);
            Thread.sleep(5000);
            WebElement Pager = driver.findElement(By.xpath("//*[@id='9b1e4f63-e161-49e8-8e03-31afe87c38fb_4c48a59e-5d1e-ce6a-fc37-e5812c7d4437_bb8719f3-cd49-587d-9d12-8d127509fd44_389d5611-d759-47a3-aa4b-9b3e737bd133_pagingtxtbox']"));
            String Value12 = Pager.getAttribute("value");
            System.out.println("Click on Page :: " + Value12);
            List<WebElement> RowCount = driver.findElements(By.xpath("//*[@id=\"9b1e4f63-e161-49e8-8e03-31afe87c38fb_4e03e453-4f43-66ee-3ee8-0468c23af24d_d41ded53-6fbc-3d3d-517d-b883b38079a0_b0a3ee5d-9d7f-4014-be64-9fee79fd871f\"]/div[3]/div[2]/div/div/table/tbody/tr"));
            System.out.println("Total Number of Row ::" + RowCount.size());
            Row_Count = RowCount.size();
            Thread.sleep(500);
        } else {
            System.out.println("Button is disable");
        }
        return Row_Count;
    }
    public String VerifyTransmissionDate(){
        String Value =TransmisstionDate.getAttribute("innerText");
        return Value;
    }
    public String VerifyTransmissionDateViewAll(){
        try {
            driver.switchTo().frame(driver.findElement(By.className("runtime-popup")));
        }
        catch (Exception e2){
            System.out.println(e2);
        }
        String TransmissionDateValue =TransmisstionDateValue.getAttribute("innerText");
        return TransmissionDateValue;
    }
    public int ContentiousProgrammeTotalCount(){
       int ValueCount = ViewAllRecordCount.size();
       return ValueCount;
    }
}

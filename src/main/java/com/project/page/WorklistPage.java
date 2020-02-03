package com.project.page;

import com.project.base.baseclass;
import com.project.helper.JavaScript.JavaScriptHelper;
import com.project.helper.Wait.WaitHelper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;



public class WorklistPage extends baseclass {

    public static final Logger log = Logger.getLogger(WorklistPage.class.getName());

    WebElement table = driver.findElement(By.xpath("//*[@id=\"9b1e4f63-e161-49e8-8e03-31afe87c38fb_4e03e453-4f43-66ee-3ee8-0468c23af24d_012c3e84-a014-a9eb-09d7-28abe808f6e9_73c59b4a-60c2-47a6-88d0-fd896f7b67a4\"]/div[3]/div[2]/div/div/table/tbody"));
    List<WebElement> WorklistMainViewRow = driver.findElements(By.xpath("//*[@id='9b1e4f63-e161-49e8-8e03-31afe87c38fb_4e03e453-4f43-66ee-3ee8-0468c23af24d_012c3e84-a014-a9eb-09d7-28abe808f6e9_73c59b4a-60c2-47a6-88d0-fd896f7b67a4']/div[3]/div[2]/div/div/table/tbody/tr"));
    @FindBy(xpath = "//*[@id=\"9b1e4f63-e161-49e8-8e03-31afe87c38fb_4e03e453-4f43-66ee-3ee8-0468c23af24d_012c3e84-a014-a9eb-09d7-28abe808f6e9_73c59b4a-60c2-47a6-88d0-fd896f7b67a4\"]/div[3]/div[1]/div/table/tbody/tr/td")
    List<WebElement> lstWorklistColumn;
    List<WebElement> column = driver.findElements(By.xpath("//*[@id='9b1e4f63-e161-49e8-8e03-31afe87c38fb_4e03e453-4f43-66ee-3ee8-0468c23af24d_012c3e84-a014-a9eb-09d7-28abe808f6e9_73c59b4a-60c2-47a6-88d0-fd896f7b67a4']/div[3]/div[1]/div/table/tbody/tr/td"));
    @FindBy(xpath = "//*[@id=\"012c3e84-a014-a9eb-09d7-28abe808f6e9_52e20421-97a5-6011-6051-b9c3f1c23b0f_ToolbarButton\"]/span[2]/span[2]")
    private WebElement btnAssignButton;
    @FindBy(xpath = "//*[@id=\"9b1e4f63-e161-49e8-8e03-31afe87c38fb_4e03e453-4f43-66ee-3ee8-0468c23af24d_012c3e84-a014-a9eb-09d7-28abe808f6e9_73c59b4a-60c2-47a6-88d0-fd896f7b67a4\"]/div[3]/div[2]/div/div/table/tbody/tr[3]/td[1]/div/div/span")
    private  WebElement SelectedRow;
    @FindBy(xpath = "//*[@id=\"9b1e4f63-e161-49e8-8e03-31afe87c38fb_4e03e453-4f43-66ee-3ee8-0468c23af24d_012c3e84-a014-a9eb-09d7-28abe808f6e9_73c59b4a-60c2-47a6-88d0-fd896f7b67a4\"]/div[3]/div[2]/div/div/table/tbody/tr[3]/td[13]/div/div/span")
    private  WebElement webAssigneeName;
    @FindBy(xpath = "//*[@id=\"012c3e84-a014-a9eb-09d7-28abe808f6e9_00c82610-de9c-c1a9-31b8-c0c082292794_ToolbarButton\"]/span[2]/span[2]")
    private  WebElement RemoveFromList;

    JavaScriptHelper javascripthelper = new JavaScriptHelper(driver);
    WaitHelper waithelper = new WaitHelper(driver);

    public WorklistPage() {
        PageFactory.initElements(driver, this);
    }

    public List<String> getWorklistRecord() throws InterruptedException {
        List<String> DataValue = new ArrayList<String>();
           for (int j = 0; j < WorklistMainViewRow.size(); j++) {
            Thread.sleep(1500);
            System.out.println(column.get(j).getText());
            DataValue.add(column.get(j).getText());
        }
        return DataValue;
    }
      public  void select_an_Assign_To_UserName(String UserName) throws Throwable {
        WebElement dropDown = driver.findElement( By.xpath( "//*[@id='012c3e84-a014-a9eb-09d7-28abe808f6e9_cd8bff4b-0c12-4e54-9373-fabaf142a68e']/div/div[1]/div[2]/div[2]/div/a" ));
        javascripthelper.clickElement(dropDown);
        List<WebElement> allOptions = dropDown.findElements(By.xpath("//*[@id='012c3e84-a014-a9eb-09d7-28abe808f6e9_cd8bff4b-0c12-4e54-9373-fabaf142a68e_droplist']/div[2]/div[2]/div/ul/li"));
        for ( WebElement dropdownvalues: allOptions) {
            dropDown.sendKeys( Keys.DOWN ); //simulate visual movement
            Thread.sleep(1000);
            if (UserName.equalsIgnoreCase(dropdownvalues.getText())){
            javascripthelper.clickElement(dropdownvalues);
            break;
            }
        }
    }

    public String AssigneeName() throws InterruptedException {
        String ActualAssign=webAssigneeName.getText();
        return ActualAssign;
    }
   public void ClickonAssign() throws InterruptedException {
       javascripthelper.clickElement(btnAssignButton);
       Thread.sleep(500);
          }
    public void Select_Third_Row(){
        waithelper.waitForElement(SelectedRow,40);
        javascripthelper.executeScript("arguments[0].click();", SelectedRow);
       }
    public void RemoveFromList(){
        RemoveFromList.click();
    }


    public List<String> worklistColumn() throws InterruptedException {
        List<String> columnData = new ArrayList<String>();
        for (WebElement WorklistColumn : lstWorklistColumn) {
            String Column_Name = WorklistColumn.getText();
            Thread.sleep(500);
            columnData.add(Column_Name);
        }
        return columnData;
    }

    }




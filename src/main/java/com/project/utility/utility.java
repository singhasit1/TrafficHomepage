package com.project.utility;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import com.project.base.baseclass;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;

public class utility   extends baseclass {
        public static long PAGE_LOAD_TIMEOUT = 20;
        public static long IMPLICIT_WAIT = 20;
        public static String TESTDATA_SHEET_PATH = "D:\\AutomateTrafficHomepage\\src\\TestData\\Testdata.xlsx";
        static Workbook book;
        static Sheet sheet;

    public void JavaScriptExecute(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement button =driver.findElement(By.name("btnLogin"));
        js.executeScript("arguments[0].click();", button);

    }


    @Rule
    public TestRule Listen=  new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            super.failed(e, description);
            try {
                takeScreenshotAtEndOfTest (description.getClassName()+","+description.getMethodName());
            }
             catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    };
    public static void takeScreenshotAtEndOfTest(String name) throws IOException {
        String DateName=new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //D:\AutomateTrafficHomepage\Automate-Traffic-Homepage\AutomationFramework-master\src\test\Screenshot
        String Destination=System.getProperty("user.dir")+"\\src\\main\\java\\com\\project\\Screenshot"+name+DateName+".png";
        FileUtils.copyFile(scrFile, new File(Destination));
    }

    public static void  DatabaseConnect() throws SQLException {
        Connection connection = null;
        try{
            System.out.println("-------- MySQL JDBC Connection Testing ------------");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@C-STPERF-DEVORA:1521:STREL","stowner","stowner");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("DELETE FROM  cmn_user_ldmmap WHERE  LEO_USER_CD ='ASINGH'");
            rs=stmt.executeQuery("INSERT INTO cmn_user_ldmmap VALUES ('ASINGH','KSAHA',SYSDATE,'*SYS',SYSDATE,'*SYS')");
            rs=stmt.executeQuery("select * from cmn_user_ldmmap WHERE  LEO_USER_CD ='ASINGH'");
            while(rs.next())
                System.out.println(rs.getString(1)+"/"+rs.getString(2)+"/"+rs.getString(3)+"/"+rs.getString(4)+"/"+rs.getString(5)+"/"+rs.getString(6));
            con.close();
        }catch(Exception e){
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }
        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }
    }
    }



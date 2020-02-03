package com.project.helper.DatabaseConffigure;
import com.project.base.baseclass;
import org.apache.log4j.Logger;
import java.sql.*;


public class DataBaseHelper  extends baseclass {

    public static final Logger log = Logger.getLogger(DataBaseHelper.class.getName());

    private static String ServerUrl = prop.getProperty("dburl");
    private static String DbDriver = prop.getProperty("dbdriverName");
    private static String DbUserName = prop.getProperty("dbuserName");
    private static String DbPassword = prop.getProperty("dbpassword");
    private static Connection connection;


}

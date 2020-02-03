package com.project;


import com.project.helper.DatabaseConffigure.DataBaseHelper;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AccountSetup  {

    public static final Logger log = Logger.getLogger(AccountSetup.class.getName());

    DataBaseHelper databasehelper = new DataBaseHelper();
    TeamViewTestCase teamviewtestCase = new TeamViewTestCase();




}

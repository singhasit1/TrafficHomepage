package com.project.page;

import com.project.base.baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserMaping extends baseclass {
    @FindBy(xpath="//*[contains(text(),'No Stellar User is mapped with')]")
    private WebElement WarningMessage;

    public void UsernotMappaingMessage(){
        WarningMessage.getText();
    }
}

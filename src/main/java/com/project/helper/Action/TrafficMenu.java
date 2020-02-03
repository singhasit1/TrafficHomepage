package com.project.helper.Action;

import com.project.base.baseclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Asit.Singh on 07-05-2019.
 */
public class TrafficMenu extends baseclass {

    public void MouseOver(WebElement Element) {
        Actions builder = new Actions(driver);
        Action mouseOverHome = builder
                .moveToElement(Element)
                .build();
        mouseOverHome.perform();
    }

}

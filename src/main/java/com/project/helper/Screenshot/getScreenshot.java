package com.project.helper.Screenshot;

import com.project.helper.Resource.ResourceHelper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static com.project.base.baseclass.driver;

public class getScreenshot {
    public static  void getscreeshot(WebElement element) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = ImageIO.read(screenshot);
        // Get the location of element on the page
        org.openqa.selenium.Point point = element.getLocation();
        // Get width and height of the element
        int eleWidth = element.getSize().getWidth();
        int eleHeight = element.getSize().getHeight();
        // Crop the entire page screenshot to get only element screenshot
        BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(),eleWidth, eleHeight);
        ImageIO.write(eleScreenshot, "png", screenshot);
        // Copy the element screenshot to disk
        File screenshotLocation = new File(ResourceHelper.getResourcePath("\\src\\test\\java\\ScreenshotFile"+ System.currentTimeMillis()+ ".png"));
        FileUtils.copyFile(screenshot, screenshotLocation);

    }
}


package org.auto.simple.SmartWebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.*;

import java.awt.image.BufferedImage;
import java.io.File;


/**
 * Created by Ruslan Makarov
 */
public interface SmartWebElement extends WebElement, FindsByLinkText, FindsById, FindsByName, FindsByTagName, FindsByClassName, FindsByCssSelector, FindsByXPath, WrapsDriver, WrapsElement, Locatable {

    void click();

    void clear();

    boolean isSelected();

    boolean isEnabled();

    SmartWebElement findElement(By var);

    SmartWebElement pressEnter();

    SmartWebElement enterText(String var);

    boolean isDisplayed();

    String text();

    String getSelectedValue();

    String getSelectedText();

    boolean isImage();

    File screenshot();

    BufferedImage screenshotAsImage();

}

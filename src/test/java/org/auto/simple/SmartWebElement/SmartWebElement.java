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

    SmartWebElement find(By var);

    SmartWebElement find(String var);

    SmartWebElement pressEnter();

    SmartWebElement text(String var);

    boolean isDisplayed();

    String enterText();

    String getSelectedValue();

    String getSelectedText();

    boolean isImage();

    File screenshot();

    BufferedImage screenshotAsImage();

}

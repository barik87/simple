package org.auto.simple.SmartWebElement;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;


public interface SmartWebElement extends WebElement, FindsByLinkText, FindsById, FindsByName, FindsByTagName, FindsByClassName, FindsByCssSelector, FindsByXPath, Locatable {

    void click();

    void clear();

    void submit();

    boolean isSelected();

    boolean isEnabled();

    boolean isDisplayed();

    SmartWebElement findElement(By var);

    SmartWebElement pressEnter();

    SmartWebElement enterText(CharSequence... var);

    String getTagName();

    String getText();
}

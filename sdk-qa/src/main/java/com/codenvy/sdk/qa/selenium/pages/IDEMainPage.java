/*
 * CODENVY CONFIDENTIAL
 * __________________
 *
 * [2014] Codenvy, S.A.
 * All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Codenvy S.A. and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to Codenvy S.A.
 * and its suppliers and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Codenvy S.A..
 */
package com.codenvy.sdk.qa.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * The main webdrive page object for driving Codenvy IDE
 */
public class IDEMainPage {

    protected WebDriver driver;

    public IDEMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getTab(String tabName) {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("gwt-debug-tabButton-" + tabName)));
    }

    public WebElement getMainMenuItem(String mainMenuItemName) {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("gwt-debug-MainMenu/"
                                                                                                     + mainMenuItemName)));
    }

    public WebElement getMainMenuAction(String menuPath) {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("topmenu/" + menuPath)));
    }
}

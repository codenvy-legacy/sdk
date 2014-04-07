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
package com.codenvy.sdk.qa.itests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.codenvy.sdk.qa.AbstractIntegrationTest;

/**
 * Codenvy SDK basic integration test, see specs reports in src/test/resources/com/codenvy/sdk/qa/itests/ServerStarted.html
 */
public class ServerStarted extends AbstractIntegrationTest {

    public String access(String url) {
        driver.get(url);
        return "access";
    }

    public String displayExplorerTab() {
        return new WebDriverWait(driver, 10)
                                            .until(ExpectedConditions.presenceOfElementLocated(
                                                                     By.id("gwt-debug-tabButton-Explorer")
                                                                     )).getText();
    }

    public String displayFileMenu() {
        return new WebDriverWait(driver, 10)
                                            .until(ExpectedConditions.presenceOfElementLocated(
                                                                     By.id("gwt-debug-MainMenu/FileGroup")
                                                                     )).getText();
    }

}

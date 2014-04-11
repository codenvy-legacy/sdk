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
package com.codenvy.sdk.qa.itests.datasource;

import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.codenvy.sdk.qa.AbstractIntegrationTest;

/**
 * Test datasource creation. See specs reports in src/test/resources/com/codenvy/sdk/qa/itests/datasource/NewDatasourceWizard.html
 */
public class NewDatasourceWizard extends AbstractIntegrationTest {

    public String access(String url) {
        driver.get(url);
        return "access";
    }


    public String displayDatasourceMenu() {
        return new WebDriverWait(driver, 20)
                                            .until(ExpectedConditions.presenceOfElementLocated(
                                                                     By.id("gwt-debug-MainMenu/DatasourceMainMenu")
                                                                     )).getText();
    }

    public String displayDatasourceNewDatasourceAction() {
        driver.findElement(By.id("gwt-debug-MainMenu/DatasourceMainMenu")).click();
        return new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(
                                                                     By.id("topmenu/Datasource/New Datasource Connection")
                                                                     )).getText();
    }

    public String clickOnNewDatasourceAction() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(
                                                              By.id("topmenu/Datasource/New Datasource Connection")
                                                              )).click();
        return "clicks";
    }


    public String displayNewDatasourceWizard() {
        return new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(
                                                                     By.id("gwt-debug-file-newOther-wizardDialog-caption")
                                                                     )).getText();
    }

    public String postgresDsTypeIsAvailable() {
        new WebDriverWait(driver, 10).until(gwtToogleButtonToBeEnable(
                                                              By.cssSelector("#gwt-debug-datasource-wizard-ds-type-postgres")
                                                              ));
        return "is enabled";
    }


    public String mySqlDsTypeIsAvailable() {
        new WebDriverWait(driver, 10).until(gwtToogleButtonToBeEnable(
                                                              By.cssSelector("#gwt-debug-datasource-wizard-ds-type-mysql")
                                                              ));
        return "is enabled";
    }

    public String msSQLServerDsTypeIsAvailable() {
        new WebDriverWait(driver, 10).until(gwtToogleButtonToBeEnable(
                                                              By.cssSelector("#gwt-debug-datasource-wizard-ds-type-sqlserver")
                                                              ));
        return "is enabled";
    }

    public String oracleDsTypeIsNotAvailable() {
        try {
            new WebDriverWait(driver, 3).until(gwtToogleButtonToBeEnable(
                                                                  By.cssSelector("#gwt-debug-datasource-wizard-ds-type-oracle")
                                                                  ));
            fail("Oracle shouldn't be enabled by default");
        } catch (Exception e) {
            // success
        }
        return "is disabled";
    }

}

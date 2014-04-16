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
package com.codenvy.sdk.qa.selenium.pages.datasource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.codenvy.sdk.qa.AbstractIntegrationTest;

/**
 * A webdriver page object for Datasource plugin creation/edit wizard box
 */
public class NewDatasourceWizardPage {

    protected WebDriver driver;

    @FindBy(id = "gwt-debug-file-newOther-wizardDialog-caption")
    WebElement          title;

    public NewDatasourceWizardPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getWizardTitle() {
        return title.getText();
    }

    public boolean isDatasourceTypeAvailable(String dbType) {
        new WebDriverWait(driver, 10).until(AbstractIntegrationTest.gwtToogleButtonToBeEnable(
                                                                   By.id("gwt-debug-datasource-wizard-ds-type-" + dbType)
                                                                   ));
        return true;
    }

}

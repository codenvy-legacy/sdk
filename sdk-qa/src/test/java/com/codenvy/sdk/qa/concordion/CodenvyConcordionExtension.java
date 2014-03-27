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
package com.codenvy.sdk.qa.concordion;

import org.concordion.api.extension.ConcordionExtender;
import org.concordion.ext.ScreenshotExtension;
import org.openqa.selenium.WebDriver;

/**
 * An concordion extension that set up screenshots and js resources for markdown.
 */
public class CodenvyConcordionExtension extends CodenvyConcordionResourceExtension {

    ScreenshotExtension ssextension = new ScreenshotExtension().setScreenshotOnAssertionSuccess(true);

    public CodenvyConcordionExtension setSeleniumDriver(WebDriver driver) {
        ssextension.setScreenshotTaker(new SeleniumScreenshotTaker(driver));
        return this;
    }

    public void addTo(ConcordionExtender concordionExtender) {
        ssextension.addTo(concordionExtender);
        super.addTo(concordionExtender);
    }
}

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

import org.concordion.api.Resource;
import org.concordion.api.extension.ConcordionExtender;
import org.concordion.api.extension.ConcordionExtension;

/**
 * An extension that add to the page JS scripts for converting markdown to html.
 */
public class CodenvyConcordionResourceExtension implements ConcordionExtension {

    public void addTo(ConcordionExtender concordionExtender) {
        concordionExtender.withLinkedJavaScript("/scripts/jquery-1.9.0.min.js",
                                                new Resource("/scripts/jquery-1.9.0.min.js"));
        concordionExtender.withLinkedJavaScript("/scripts/Markdown.ClassConvert.js",
                                                new Resource("/scripts/Markdown.ClassConvert.js"));
        concordionExtender.withLinkedJavaScript("/scripts/Markdown.Converter.js",
                                                new Resource("/scripts/Markdown.Converter.js"));

        // bootstrap
        concordionExtender.withLinkedJavaScript("/bootstrap/js/bootstrap.min.js", new Resource("/bootstrap/js/bootstrap.min.js"));
        concordionExtender.withLinkedCSS("/bootstrap/css/bootstrap.min.css", new Resource("/bootstrap/css/bootstrap.min.css"));
    }
}

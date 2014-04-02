/*
 * CODENVY CONFIDENTIAL
 * __________________
 * 
 *  [2012] - [2013] Codenvy, S.A. 
 *  All Rights Reserved.
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
package com.codenvy.api.deploy;

import com.codenvy.ide.env.SingleEnvironmentFilter;
import com.codenvy.ide.everrest.CodenvyEverrestWebSocketServlet;
import com.codenvy.inject.DynaModule;
import com.google.inject.servlet.ServletModule;

import org.everrest.guice.servlet.GuiceEverrestServlet;
import org.everrest.websockets.WSConnectionTracker;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

/** @author andrew00x */
@DynaModule
public class ApiServletModule extends ServletModule {
    @Override
    protected void configureServlets() {
        getServletContext().addListener(new WSConnectionTracker());
        bind(SingleEnvironmentFilter.class).in(Singleton.class);
        Map<String,String> params = new HashMap<>(2);
        params.put("ws-name", "default");
        params.put("ws-id", "1q2w3e");
        filter("/*").through(SingleEnvironmentFilter.class, params);
        serve("/ws/*").with(CodenvyEverrestWebSocketServlet.class);
        serve("/*").with(GuiceEverrestServlet.class);
    }
}

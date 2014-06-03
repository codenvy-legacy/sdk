/*******************************************************************************
 * Copyright (c) 2012-2014 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
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

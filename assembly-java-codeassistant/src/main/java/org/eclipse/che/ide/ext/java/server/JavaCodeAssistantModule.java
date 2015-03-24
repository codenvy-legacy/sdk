/*******************************************************************************
 * Copyright (c) 2012-2015 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.ide.ext.java.server;

import com.google.common.collect.ImmutableSet;
import com.google.inject.AbstractModule;

import org.eclipse.che.api.auth.CookiesTokenExtractor;
import org.eclipse.che.api.auth.TokenExtractor;
import org.eclipse.che.api.auth.TokenManager;
import org.eclipse.che.api.auth.UserProvider;
import org.eclipse.che.api.core.notification.WSocketEventBusClient;
import org.eclipse.che.api.local.SessionUserProvider;
import org.eclipse.che.commons.user.User;
import org.eclipse.che.commons.user.UserImpl;
import org.eclipse.che.everrest.CodenvyAsynchronousJobPool;
import org.eclipse.che.inject.DynaModule;
import org.eclipse.che.jdt.JavaNavigationService;
import org.eclipse.che.jdt.JavadocService;
import org.eclipse.che.jdt.RestNameEnvironment;
import org.eclipse.che.vfs.impl.fs.LocalFSMountStrategy;
import org.eclipse.che.vfs.impl.fs.WorkspaceHashLocalFSMountStrategy;
import org.everrest.core.impl.async.AsynchronousJobPool;
import org.everrest.core.impl.async.AsynchronousJobService;
import org.everrest.guice.PathKey;

/**
 * @author Evgen Vidolob
 */
@DynaModule
public class JavaCodeAssistantModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(RestNameEnvironment.class);
        bind(LocalFSMountStrategy.class).to(WorkspaceHashLocalFSMountStrategy.class);
        bind(JavadocService.class);
        bind(JavaNavigationService.class);
        bind(AsynchronousJobPool.class).to(CodenvyAsynchronousJobPool.class);
        bind(new PathKey<>(AsynchronousJobService.class, "/async/{ws-id}")).to(AsynchronousJobService.class);
        bind(WSocketEventBusClient.class).asEagerSingleton();
        bind(TokenExtractor.class).to(CookiesTokenExtractor.class);
        bind(UserProvider.class).toInstance(new UserProvider() {
            @Override
            public User getUser(String token) {
                return new UserImpl("codenvy@codenvy.com", "codenvy", token, ImmutableSet.of("user"), false);
            }
        });
        bind(TokenManager.class).toInstance(new TokenManager() {
            @Override
            public String createToken(String userId) {
                throw new UnsupportedOperationException();
            }

            @Override
            public String getUserId(String token) {
                return "codenvy";
            }

            @Override
            public boolean isValid(String token) {
                return true;
            }

            @Override
            public String invalidateToken(String token) {
                throw new UnsupportedOperationException();
            }
        });
    }
}

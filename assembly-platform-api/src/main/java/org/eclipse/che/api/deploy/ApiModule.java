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
package org.eclipse.che.api.deploy;

import com.google.inject.AbstractModule;

import org.eclipse.che.api.analytics.AnalyticsModule;
import org.eclipse.che.api.auth.AuthenticationService;
import org.eclipse.che.api.auth.CookiesTokenExtractor;
import org.eclipse.che.api.auth.InMemoryTokenManager;
import org.eclipse.che.api.auth.LocalSessionInvalidationHandler;
import org.eclipse.che.api.auth.SecureRandomTokenGenerator;
import org.eclipse.che.api.auth.TokenExtractor;
import org.eclipse.che.api.auth.TokenGenerator;
import org.eclipse.che.api.auth.TokenInvalidationHandler;
import org.eclipse.che.api.auth.TokenManager;
import org.eclipse.che.api.auth.UserProvider;
import org.eclipse.che.api.auth.oauth.OAuthTokenProvider;
import org.eclipse.che.api.builder.BuilderAdminService;
import org.eclipse.che.api.builder.BuilderSelectionStrategy;
import org.eclipse.che.api.builder.BuilderService;
import org.eclipse.che.api.builder.LastInUseBuilderSelectionStrategy;
import org.eclipse.che.api.builder.internal.BuilderModule;
import org.eclipse.che.api.builder.internal.SlaveBuilderService;
import org.eclipse.che.api.core.notification.WSocketEventBusServer;
import org.eclipse.che.api.core.rest.ApiInfoService;
import org.eclipse.che.api.core.rest.CoreRestModule;
import org.eclipse.che.api.factory.FactoryModule;
import org.eclipse.che.api.local.SessionUserProvider;
import org.eclipse.che.api.project.server.BaseProjectModule;
import org.eclipse.che.api.runner.LastInUseRunnerSelectionStrategy;
import org.eclipse.che.api.runner.RunnerAdminService;
import org.eclipse.che.api.runner.RunnerSelectionStrategy;
import org.eclipse.che.api.runner.RunnerService;
import org.eclipse.che.api.runner.internal.RunnerModule;
import org.eclipse.che.api.runner.internal.SlaveRunnerService;
import org.eclipse.che.api.user.server.UserProfileService;
import org.eclipse.che.api.user.server.UserService;
import org.eclipse.che.api.vfs.server.VirtualFileSystemModule;
import org.eclipse.che.api.workspace.server.WorkspaceService;
import org.eclipse.che.docs.DocsModule;
import org.eclipse.che.everrest.CodenvyAsynchronousJobPool;
import org.eclipse.che.everrest.ETagResponseFilter;
import org.eclipse.che.generator.archetype.ArchetypeGeneratorModule;
import org.eclipse.che.ide.ext.java.jdi.server.DebuggerService;
import org.eclipse.che.ide.ext.java.server.format.FormatService;
import org.eclipse.che.ide.ext.ssh.server.KeyService;
import org.eclipse.che.ide.ext.ssh.server.SshKeyStore;
import org.eclipse.che.ide.ext.ssh.server.UserProfileSshKeyStore;
import org.eclipse.che.inject.DynaModule;
import org.eclipse.che.security.oauth.OAuthAuthenticationService;
import org.eclipse.che.security.oauth.OAuthAuthenticatorProvider;
import org.eclipse.che.security.oauth.OAuthAuthenticatorProviderImpl;
import org.eclipse.che.security.oauth.OAuthAuthenticatorTokenProvider;
import org.eclipse.che.vfs.impl.fs.LocalFileSystemRegistryPlugin;
import org.eclipse.che.vfs.impl.fs.VirtualFileSystemFSModule;
import org.everrest.core.impl.async.AsynchronousJobPool;
import org.everrest.core.impl.async.AsynchronousJobService;
import org.everrest.guice.PathKey;

/** @author andrew00x */
@DynaModule
public class ApiModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ApiInfoService.class);

        bind(AuthenticationService.class);
        bind(WorkspaceService.class);
        bind(ETagResponseFilter.class);

        bind(UserService.class);
        bind(UserProfileService.class);

        bind(LocalFileSystemRegistryPlugin.class);

        bind(BuilderSelectionStrategy.class).to(LastInUseBuilderSelectionStrategy.class);
        bind(BuilderService.class);
        bind(BuilderAdminService.class);
        bind(SlaveBuilderService.class);

        bind(RunnerSelectionStrategy.class).to(LastInUseRunnerSelectionStrategy.class);
        bind(RunnerService.class);
        bind(RunnerAdminService.class);
        bind(SlaveRunnerService.class);

        bind(DebuggerService.class);
        bind(FormatService.class);

        bind(KeyService.class);
        bind(SshKeyStore.class).to(UserProfileSshKeyStore.class);

        bind(OAuthAuthenticationService.class);
        bind(OAuthTokenProvider.class).to(OAuthAuthenticatorTokenProvider.class);
        bind(OAuthAuthenticatorProvider.class).to(OAuthAuthenticatorProviderImpl.class);


        bind(UserProvider.class).to(SessionUserProvider.class);
        bind(TokenExtractor.class).to(CookiesTokenExtractor.class);
        bind(AuthenticationService.class);
        bind(TokenManager.class).to(InMemoryTokenManager.class);
        bind(TokenInvalidationHandler.class).to(LocalSessionInvalidationHandler.class);
        bind(TokenGenerator.class).to(SecureRandomTokenGenerator.class);


        bind(AsynchronousJobPool.class).to(CodenvyAsynchronousJobPool.class);
        bind(new PathKey<>(AsynchronousJobService.class, "/async/{ws-id}")).to(AsynchronousJobService.class);

        bind(WSocketEventBusServer.class);

        install(new ArchetypeGeneratorModule());

        install(new CoreRestModule());
        install(new AnalyticsModule());
        install(new BaseProjectModule());
        install(new BuilderModule());
        install(new RunnerModule());
        install(new VirtualFileSystemModule());
        install(new VirtualFileSystemFSModule());
        install(new FactoryModule());
        install(new DocsModule());
    }
}

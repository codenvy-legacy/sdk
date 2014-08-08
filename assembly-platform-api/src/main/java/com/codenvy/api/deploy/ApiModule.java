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

import com.codenvy.api.auth.oauth.OAuthTokenProvider;
import com.codenvy.api.builder.BuilderAdminService;
import com.codenvy.api.builder.BuilderSelectionStrategy;
import com.codenvy.api.builder.BuilderService;
import com.codenvy.api.builder.LastInUseBuilderSelectionStrategy;
import com.codenvy.api.builder.internal.SlaveBuilderService;
import com.codenvy.api.core.rest.ApiExceptionMapper;
import com.codenvy.api.core.rest.ApiInfoService;
import com.codenvy.api.project.server.ProjectService;
import com.codenvy.api.project.server.ProjectTypeDescriptionService;
import com.codenvy.api.runner.LastInUseRunnerSelectionStrategy;
import com.codenvy.api.runner.RunnerAdminService;
import com.codenvy.api.runner.RunnerSelectionStrategy;
import com.codenvy.api.runner.RunnerService;
import com.codenvy.api.runner.internal.SlaveRunnerService;
import com.codenvy.api.user.server.TokenValidator;
import com.codenvy.api.user.server.UserProfileService;
import com.codenvy.api.user.server.UserService;
import com.codenvy.api.vfs.server.ContentStreamWriter;
import com.codenvy.api.vfs.server.RequestValidator;
import com.codenvy.api.vfs.server.VirtualFileSystemFactory;
import com.codenvy.api.vfs.server.search.SearcherProvider;
import com.codenvy.ide.env.TokenValidatorImpl;
import com.codenvy.ide.everrest.CodenvyAsynchronousJobPool;
import com.codenvy.ide.ext.git.server.GitConnectionFactory;
import com.codenvy.ide.ext.git.server.nativegit.NativeGitConnectionFactory;
import com.codenvy.ide.ext.git.server.rest.BranchListWriter;
import com.codenvy.ide.ext.git.server.rest.CommitMessageWriter;
import com.codenvy.ide.ext.git.server.rest.GitService;
import com.codenvy.ide.ext.git.server.rest.MergeResultWriter;
import com.codenvy.ide.ext.git.server.rest.RemoteListWriter;
import com.codenvy.ide.ext.git.server.rest.StatusPageWriter;
import com.codenvy.ide.ext.git.server.rest.TagListWriter;
import com.codenvy.ide.ext.github.server.oauth.GitHubOAuthAuthenticatorProvider;
import com.codenvy.ide.ext.github.server.rest.GitHubService;
import com.codenvy.ide.ext.java.jdi.server.DebuggerService;
import com.codenvy.ide.ext.java.server.format.FormatService;
import com.codenvy.ide.ext.ssh.server.KeyService;
import com.codenvy.ide.ext.ssh.server.SshKeyStore;
import com.codenvy.ide.ext.ssh.server.UserProfileSshKeyStore;
import com.codenvy.ide.security.oauth.server.LocalOAuthTokenProvider;
import com.codenvy.ide.security.oauth.server.OAuthAuthenticationService;
import com.codenvy.ide.security.oauth.server.OAuthAuthenticatorProvider;
import com.codenvy.inject.DynaModule;
import com.codenvy.vfs.impl.fs.CleanableSearcherProvider;
import com.codenvy.vfs.impl.fs.LocalFSMountStrategy;
import com.codenvy.vfs.impl.fs.LocalFileSystemRegistryPlugin;
import com.codenvy.vfs.impl.fs.WorkspaceHashLocalFSMountStrategy;
import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import com.google.inject.util.Providers;

import org.everrest.core.impl.async.AsynchronousJobPool;
import org.everrest.core.impl.async.AsynchronousJobService;
import org.everrest.guice.PathKey;

/** @author andrew00x */
@DynaModule
public class ApiModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ApiInfoService.class);
        bind(ProjectService.class);
        bind(ProjectTypeDescriptionService.class);
        bind(com.codenvy.api.project.server.ProjectImportersService.class);
        bind(LocalFileSystemRegistryPlugin.class);
        bind(LocalFSMountStrategy.class).to(WorkspaceHashLocalFSMountStrategy.class);
        bind(SearcherProvider.class).to(CleanableSearcherProvider.class);
        bind(RequestValidator.class).toProvider(Providers.<RequestValidator>of(null));
        bind(ContentStreamWriter.class);
        bind(VirtualFileSystemFactory.class);
        bind(ApiExceptionMapper.class);
        bind(BuilderSelectionStrategy.class).to(LastInUseBuilderSelectionStrategy.class);
        bind(BuilderService.class);
        bind(com.codenvy.api.auth.AuthenticationService.class);
        bind(com.codenvy.api.workspace.server.WorkspaceService.class);
        bind(BuilderAdminService.class);
        bind(SlaveBuilderService.class);
        bind(RunnerSelectionStrategy.class).to(LastInUseRunnerSelectionStrategy.class);
        bind(RunnerService.class);
        bind(RunnerAdminService.class);
        bind(SlaveRunnerService.class);
        bind(UserService.class);
        bind(UserProfileService.class);
        bind(DebuggerService.class);
        bind(AsynchronousJobPool.class).to(CodenvyAsynchronousJobPool.class);
        bind(new PathKey<>(AsynchronousJobService.class, "/async/{ws-id}")).to(AsynchronousJobService.class);
        bind(GitService.class);
        bind(BranchListWriter.class);
        bind(CommitMessageWriter.class);
        bind(MergeResultWriter.class);
        bind(RemoteListWriter.class);
        bind(StatusPageWriter.class);
        bind(TagListWriter.class);
        bind(FormatService.class);
        bind(GitHubService.class);
        bind(GitConnectionFactory.class).to(NativeGitConnectionFactory.class);
        bind(KeyService.class);
        bind(SshKeyStore.class).to(UserProfileSshKeyStore.class);
        bind(OAuthAuthenticationService.class);
        bind(OAuthTokenProvider.class).to(LocalOAuthTokenProvider.class);
        // Initialize empty set of OAuthAuthenticatorProvider.
        Multibinder<OAuthAuthenticatorProvider> oAuthAuthenticatorMultibinder =
                Multibinder.newSetBinder(binder(), OAuthAuthenticatorProvider.class);
        oAuthAuthenticatorMultibinder.addBinding().to(GitHubOAuthAuthenticatorProvider.class);
        bind(OAuthAuthenticationService.class);
        bind(TokenValidator.class).to(TokenValidatorImpl.class);

        bind(com.codenvy.api.core.notification.WSocketEventBusServer.class);

        install(new com.codenvy.api.analytics.AnalyticsModule());
        install(new com.codenvy.api.project.server.BaseProjectModule());
        install(new com.codenvy.api.builder.internal.BuilderModule());
        install(new com.codenvy.api.runner.internal.RunnerModule());
        install(new com.codenvy.api.vfs.server.VirtualFileSystemModule());
        install(new com.codenvy.docs.DocsModule());
    }
}

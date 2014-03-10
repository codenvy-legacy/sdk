package com.codenvy.ide.client;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.codenvy.ide.collections.StringMap;
import com.codenvy.ide.collections.Collections;
/**
 * THIS CLASS WILL BE OVERRIDDEN BY MAVEN BUILD. DON'T EDIT CLASS, IT WILL HAVE NO EFFECT.
 */
@Singleton
@SuppressWarnings("rawtypes")
public class ExtensionManager
{

   /** Contains the map will all the Extension Providers <FullClassFQN, Provider>. */
   protected final StringMap<Provider> extensions = Collections.createStringMap();

   /** Constructor that accepts all the Extension found in IDE package */
   @Inject
   public ExtensionManager(
      Provider<com.codenvy.ide.ext.java.client.JavaExtension> javaextension,
      Provider<com.codenvy.ide.ext.github.client.GitHubExtension> githubextension,
      Provider<com.codenvy.ide.ext.git.client.GitExtension> gitextension,
      Provider<com.codenvy.ide.extension.runner.client.RunnerExtension> runnerextension,
      Provider<com.codenvy.ide.ext.tutorials.client.TutorialsExtension> tutorialsextension,
      Provider<com.codenvy.ide.ext.ssh.client.SshExtension> sshextension,
      Provider<com.codenvy.ide.ext.web.WebExtension> webextension,
      Provider<com.codenvy.ide.extension.builder.client.BuilderExtension> builderextension,
      Provider<com.codenvy.ide.ext.java.jdi.client.JavaRuntimeExtension> javaruntimeextension,
      Provider<com.codenvy.ide.ext.extensions.client.ExtRuntimeExtension> extruntimeextension
   )
   {
      this.extensions.put("com.codenvy.ide.ext.java.client.JavaExtension",javaextension);
      this.extensions.put("com.codenvy.ide.ext.github.client.GitHubExtension",githubextension);
      this.extensions.put("com.codenvy.ide.ext.git.client.GitExtension",gitextension);
      this.extensions.put("com.codenvy.ide.extension.runner.client.RunnerExtension",runnerextension);
      this.extensions.put("com.codenvy.ide.ext.tutorials.client.TutorialsExtension",tutorialsextension);
      this.extensions.put("com.codenvy.ide.ext.ssh.client.SshExtension",sshextension);
      this.extensions.put("com.codenvy.ide.ext.web.WebExtension",webextension);
      this.extensions.put("com.codenvy.ide.extension.builder.client.BuilderExtension",builderextension);
      this.extensions.put("com.codenvy.ide.ext.java.jdi.client.JavaRuntimeExtension",javaruntimeextension);
      this.extensions.put("com.codenvy.ide.ext.extensions.client.ExtRuntimeExtension",extruntimeextension);
   }

   /** Returns  the map will all the Extension Providers <FullClassFQN, Provider>. */
   public StringMap<Provider> getExtensions()
   {
      return extensions;
   }
}

package com.codenvy.ide.client.inject;

import com.codenvy.ide.client.BootstrapController;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

/**
 * THIS CLASS WILL BE OVERRIDDEN BY MAVEN BUILD. DON'T EDIT CLASS, IT WILL HAVE NO EFFECT.
 * 
 * Interface for GIN Injector, that provides access to the top level
 * application components. Implementation of Injector is generated
 * on compile time.
 */
@GinModules({
   com.codenvy.ide.ext.java.client.inject.JavaGinModule.class ,
   com.codenvy.ide.ext.extensions.client.inject.ExtensionsGinModule.class ,
   com.codenvy.ide.ext.git.client.inject.GitGinModule.class ,
   com.codenvy.ide.extension.builder.client.inject.BuilderGinModule.class ,
   com.codenvy.ide.core.inject.CoreGinModule.class ,
   com.codenvy.ide.ext.github.client.inject.GitHubGinModule.class ,
   com.codenvy.ide.client.inject.IDEClientModule.class ,
   com.codenvy.ide.ext.java.jdi.client.inject.JavaRuntimeGinModule.class ,
   com.codenvy.ide.ext.ssh.client.inject.SshGinModule.class ,
   com.codenvy.ide.extension.runner.client.inject.RunnerGinModule.class 
})
public interface IDEInjector extends Ginjector
{

   /**
    * @return the instance of BootstrapController
    */
   BootstrapController getBootstrapController();

}

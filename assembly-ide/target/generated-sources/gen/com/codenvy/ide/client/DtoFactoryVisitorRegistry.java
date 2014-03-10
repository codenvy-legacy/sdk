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
public class DtoFactoryVisitorRegistry
{

   /** Contains the map will all the DtoFactoryVisitor Providers <FullClassFQN, Provider>. */
   protected final StringMap<Provider> providers = Collections.createStringMap();

   /** Constructor that accepts all found DtoFactoryVisitor Providers. */
   @Inject
   public DtoFactoryVisitorRegistry(
      Provider<com.codenvy.api.user.client.dto.DtoClientImpls> provider_2,
      Provider<com.codenvy.api.vfs.client.dto.DtoClientImpls> provider_8,
      Provider<com.codenvy.ide.ext.github.client.dto.DtoClientImpls> provider_5,
      Provider<com.codenvy.ide.ext.git.client.dto.DtoClientImpls> provider_7,
      Provider<com.codenvy.ide.ext.ssh.dto.client.DtoClientImpls> provider_11,
      Provider<com.codenvy.api.core.client.dto.DtoClientImpls> provider_6,
      Provider<com.codenvy.ide.api.user.dto.DtoClientImpls> provider_4,
      Provider<com.codenvy.api.builder.client.dto.DtoClientImpls> provider_1,
      Provider<com.codenvy.ide.ext.java.jdi.client.dto.DtoClientImpls> provider_10,
      Provider<com.codenvy.api.project.client.dto.DtoClientImpls> provider_3,
      Provider<com.codenvy.ide.core.client.DtoClientImpls> provider_0,
      Provider<com.codenvy.api.runner.client.dto.DtoClientImpls> provider_9
   )
   {
      this.providers.put("com.codenvy.api.user.client.dto.DtoClientImpls", provider_2);
      this.providers.put("com.codenvy.api.vfs.client.dto.DtoClientImpls", provider_8);
      this.providers.put("com.codenvy.ide.ext.github.client.dto.DtoClientImpls", provider_5);
      this.providers.put("com.codenvy.ide.ext.git.client.dto.DtoClientImpls", provider_7);
      this.providers.put("com.codenvy.ide.ext.ssh.dto.client.DtoClientImpls", provider_11);
      this.providers.put("com.codenvy.api.core.client.dto.DtoClientImpls", provider_6);
      this.providers.put("com.codenvy.ide.api.user.dto.DtoClientImpls", provider_4);
      this.providers.put("com.codenvy.api.builder.client.dto.DtoClientImpls", provider_1);
      this.providers.put("com.codenvy.ide.ext.java.jdi.client.dto.DtoClientImpls", provider_10);
      this.providers.put("com.codenvy.api.project.client.dto.DtoClientImpls", provider_3);
      this.providers.put("com.codenvy.ide.core.client.DtoClientImpls", provider_0);
      this.providers.put("com.codenvy.api.runner.client.dto.DtoClientImpls", provider_9);
   }

   /** Returns  the map will all the DtoFactoryVisitor Providers <FullClassFQN, Provider>. */
   public StringMap<Provider> getDtoFactoryVisitors()
   {
      return providers;
   }
}

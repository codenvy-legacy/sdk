The Codenvy SDK is a free and open Java framework for building Web client applications that are beautiful, fast, and modular. The Codenvy IDE is an application built using the Codenvy SDK, its embedded APIs, and executes on the Codenvy Web Client Platform (WCP).  The WCP is a thin servlet-based application that loads and manages plug-ins against the API set.  The WCP can be run in any servlet container.  The checkout and build process on this page grabs the WCP, IDE, and SDK and creates an assembly for Tomcat.  Tomcat is also included in the distribution to make startup configuration simpler. 

Codenvy SDK can be installed on any operating system that supports Java 1.7 - desktop, server or cloud. It has been extensively tested on Ubuntu, Linux, MacOS and Windows.  Java, GWT, GIN and Javascript are the core technologies underlying the SDK.

The Codenvy SDK is currently licensed on a proprietary Codenvy license. We will provide an open license for the SDK once it has hit a stabilization point.

![image] (http://docs.codenvy.com/wp-content/uploads/editor1.png)

### Clone Codenvy SDK Repository

```sh
git clone https://github.com/codenvy/sdk.git
```

The Codenvy SDK is an assembly of other public Codenvy projects including the IDE, Platform API, a suite of plug-ins, and commons.

### Build the Project
```sh
cd /sdk
mvn clean install
```

### Run the Codenvy SDK
```sh
cd assembly-sdk/target/tomcat-ide/bin
./codenvy
```

The hosted IDE will be available at ```localhost:8080```

### Add Your Extensions (Plug-Ins) to the SDK

1. Package your extension as a JAR either offline or in the IDE.  If in the IDE, go to **Project** menu and build your extension. After the build is finished you will see a link in the Output console that points to a location to download your artifacts.  

2. Copy the JAR artifact from the previous step to ```/ext``` directory of the SDK.  

3. Execute ```extInstall``` script in the root of the SDK to load this plug-in. The project will be re-compiled.

4. Restart the SDK to have the changes take affect permanently.

You may need to empty browser’s cache (if you haven’t set appropriate HTTP headers) to see the extension.

### Helping Codenvy

**Contribute**: Codenvy accepts pull requests, so if you feel like contributing to the project, you are definitely welcome to do so.

**Report Bugs**: Our JIRA is private at the moment but we are working to open it up. In the mean time we accept bug and enhancement requests by posting on our Google Group at https://groups.google.com/a/codenvy.com/forum/#!forum/codenvy.

### Documentation  & Tutorials
Browse SDK docs - http://docs.codenvy.com/sdk/
API JavaDoc - http://docs.codenvy.com/ide/apidocs/

### Contact Information

* **Website:** [www.codenvy.com](https://www.codenvy.com)
* **Twitter:** [@CodenvyHQ](https://twitter.com/CoenvyHQ)
* **Blog:** [blog.codenvy.com](http://blog.codenvy.com)
* **Google Group:** [helpdesk.codenvy.com] (https://groups.google.com/a/codenvy.com/forum/#!forum/codenvy)

Feel free to contact us with questions, comments, bug reports and feedback.

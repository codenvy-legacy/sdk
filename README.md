![image] (http://docs.codenvy.com/wp-content/uploads/editor1.png)

The Codenvy SDK (now Eclipse Che and an incubation project from the Eclipse Foundation!) is a free and open Java framework for building Web client applications that are beautiful, fast, and modular. An IDE is included with Eclipse Che, packaged as a GWT Java application that compiles to optimized JavaScript with support for most modern browsers.

The SDK contains:
* A browser-based IDE
* A kernel for loading, managing, and operating extensions authored as plug-ins
* A set of platform APIs for developer microservices (e.g., 'build project')
* Implementations of the APIs for desktop and cloud deployment
* Plug-ins for multiple programming languages, source code systems, builders and runners
* Everrest open source utility for mapping Java to Web Services
* A CLI for interacting with platform APIs
* An Eclipse plug-in for editing, building and running Che projects from within Eclipse
* Developer tooling for building and packaging plug-ins

The IDE is a browser client application that contains a variety of plug-ins, makes use of the platform APIs, and runs on the Eclipse Che kernel.  The kernel is a thin servlet-based framework that loads and manages plug-ins.  The kernel can be run in any servlet container.  The build process for the SDK combines all of these components into an assembly readied for Tomcat.  Tomcat is also included in the distribution to make startup configuration simpler. 

The SDK can be installed on any operating system that supports Java 1.7 - desktop, server or cloud. It has been extensively tested on Ubuntu, Linux, MacOS and Windows.  Java, GWT, GIN and Javascript are the core technologies used to build the SDK.

The SDK is licensed with the Eclipse Public License 1.0.

### Clone the Repository & Checkout Latest Stable Branch

```sh
git clone https://github.com/codenvy/sdk.git
cd sdk
git checkout 3.0.0-M20
```

If you do not perform the checkout, you will be in the master branch.  We develop directly onto this branch and you may encounter intermediate errors.  Checkout the latest stable branch before compiling.

GitHub projects for each of the sub-projects:
* **CLI**:                     [CLI for accessing APIs] (http://github.com/codenvy/cli)
* **CMF**                      [Framework for creating diagram editors] (http://github.com/codenvy/cmf)
* **Commons**:                 [Shared libraries] (http://github.com/codenvy/commons)
* **Eclipse Plug-In**          [An Eclipse plug-in for running Che projects] (http://github.com/codenvy/eclipse-plugin)
* **Everrest**:                [A shell and command abstraction for Web services] (http://github.com/codenvy/everrest)
* **IDE**:                     [IDE] (http://github.com/codenvy/ide)
* **Maven Dep POM**            [Maven dependencies] (http://github.com/codenvy/maven-depmgt-pom)
* **Maven Parent POM**         [Mane parent] (http://github.com/codenvy/maven-parent-pom)
* **Platform API**:            [REST APIs for platform services] (http://github.com/codenvy/platform-api)
* **Platform API GWT Client**: [Java client for APIs] (http://github.com/codenvy/platform-api-client-gwt)
* **AngularJS Plugin**:        [AngularJS autocomplete and editor] (http://github.com/codenvy/plugin-angularjs)
* **Bower Plugin**:            [Bower package management] (http://github.com/codenvy/plugin-bower)
* **Database Plugin**:         [Schema browser and SQL editor plugin] (http://github.com/codenvy/plugin-datasource)
* **CodeMirror Plugin**:       [Embeds CodeMirror editor] (http://github.com/codenvy/plugin-editor-codemirror)
* **Orion Plugin**:            [Embeds Orion editor] (http://github.com/codenvy/plugin-editor-orion)
* **Git Plugin**:              [User interface for git client] (http://github.com/codenvy/plugin-git)
* **Grunt Plugin**:            [Grunt server integrated into IDE] (http://github.com/codenvy/plugin-grunt)
* **Gulp Plugin**:             [Gulp builder] (http://github.com/codenvy/plugin-gulp)
* **Java Plugin**:             [Ant, maven, debugger, and code assistant] (http://github.com/codenvy/plugin-java)
* **NPM Plugin**:              [Manage npm packages within the IDE] (http://github.com/codenvy/plugin-npm)
* **Subversion Plugin**:       [User interface for subversion client] (http://github.com/codenvy/plugin-svn)


### Build the SDK and IDE
```sh
cd /sdk
mvn clean install
```

### Run Eclipse Che
```sh
./codenvy_sdk [start|stop]
```

The hosted IDE will be available at ```localhost:8080```

### AngularJS Configuration

In order to be able to use this plugin, some of tools needs to be available on the system.

These tools include : npm and Yeoman stack (with bower and Grunt)

* npm setup guide : https://github.com/npm/npm
npm is bundled with nodejs which can be downloaded from there : http://nodejs.org/download/


* Yeoman (and dependencies can be installed with the command line : npm install -g yo)
   more details on http://yeoman.io/gettingstarted.html

### Add Your Extensions (Plug-Ins) to the SDK

1. Package your extension as a JAR either offline or in the IDE.  If in the IDE, go to **Project** menu and build your extension. After the build is finished you will see a link in the Output console that points to a location to download your artifacts.  

2. Copy the JAR artifact from the previous step to ```/ext``` directory of the SDK.  

3. Execute ```extInstall``` script in the root of the SDK to load this plug-in. The project will be re-compiled.

4. Restart the SDK to have the changes take affect permanently.

You may need to empty browser’s cache (if you haven’t set appropriate HTTP headers) to see the extension.

### Helping Eclipse Che

**Contribute**: We accept pull requests, so if you feel like contributing to the project, you are definitely welcome to do so.

**Report Bugs**: You can report bugs, contribute, and post on the Eclipse Che forums at [https://www.eclipse.org/forums/index.php/t/787421/] (https://www.eclipse.org/forums/index.php/t/787421/). 

### Documentation & Tutorials
* **SDK Binaries** [docs.codenvy.com/sdk/download] (http://docs.codenvy.com/sdk/download/)
* **SDK Getting Started** [http://docs.codenvy.com/sdk/introduction/] (http://docs.codenvy.com/sdk/introduction/)
* **SDK JavaDoc** [docs.codenvy.com/ide/apidocs/] (http://docs.codenvy.com/ide/apidocs/)
* **SDK Extension Tutorials** [http://docs.codenvy.com/sdk/writing-your-first-codenvy-extension/] (http://docs.codenvy.com/sdk/writing-your-first-codenvy-extension/)


### Contact Information
* **Website:** [www.codenvy.com](https://www.codenvy.com)
* **Twitter:** [@CodenvyHQ](https://twitter.com/CodenvyHQ)
* **Blog:** [blog.codenvy.com](http://blog.codenvy.com)
* **Google Group:** [helpdesk.codenvy.com] (https://groups.google.com/a/codenvy.com/forum/#!forum/codenvy)

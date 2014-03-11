The Codenvy SDK is a free and open Java framework for building Web client applications that are beautiful, fast, and modular. The Codenvy IDE is an application built using the Codenvy SDK, its embedded APIs, and executes on the Codenvy Web Client Platform (WCP).

Codenvy SDK can be installed on any Unix based system - desktop, server or cloud. It has been extensively tested on Ubuntu, Linux and MacOS. GWT, GIN and Javascript are core technologies underlying the SDK.

![image] (http://docs.codenvy.com/wp-content/uploads/extension4.png)

### Clone Repository

Clone Codenvy SDK to your local machine:

```git clone git@github.com:codenvy/sdk.git``` or ```git clone https://github.com/codenvy/sdk.git```

### Build the Project


Go to **sdk** directory and run:
```sh
mvn clean install
```
### Run Codenvy SDK

Go to ```sdk/assembly-sdk/target/tomcat-ide/bin``` and execute:
```sh
./codenvy
```
Codenvy SDK will be available at ```localhost:8080```

### Add Own Extensions to SDK

Go to **Project** menu and build your extension. After the build is finished you will see a link in the Output console that points to a location to download your artifacts. Skip this step if you already have your plugin packaged as JAR.

#### Add Plug-In to SDK Runtime

Copy the JAR artifact from the previous step to ```/ext``` directory of the SDK.

Execute ```extInstall``` script in the root of the SDK to load this plug-in. The project will be re-compiled.

Restart the SDK to have the changes take affect permanently.

You may need to empty browser’s cache (if you haven’t set appropriate HTTP headers) to see the extension.

### Helping Codenvy

**Contribute**: Codenvy accepts pull requests, so if you feel like contributing to the project, you are definitely welcome to do so.

**Report Bugs**: Our JIRA is private at the moment but we are thinking of opening it up. You can report bugs directly to our dedicated support email (see Contact Information)

### Documentation  & Tutorials

Browse SDK docs - http://docs.codenvy.com/sdk/

API JavaDoc - http://docs.codenvy.com/ide/apidocs/

### Contact Information

Feel free to contact us with questions, comments, bug reports and feedback.

Tech support- support@codenvy.com

Codenvy Group Discussion - helpdesk.codenvy.com

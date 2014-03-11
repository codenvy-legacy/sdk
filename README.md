## Clone repository

Clone Codenvy SDK to your local machine:

```git clone git@github.com:codenvy/sdk.git``` or ```it clone https://github.com/codenvy/sdk.git```

## Build the Project


Go to **sdk** directory and run:
```sh
mvn clean install
```
## Run Codenvy SDK

Go to **sdk/assembly-sdk/target/tomcat-ide/bin**
```sh
./codenvy.sh run
```
Codenvy SDK will be available at **localhost:8080**

## Add Own Extensions to SDK

Go to **Project** menu and build your extension. After the build is finished you will see a link in the Output console that points to a location to download your artifacts. Skip this step if you already have your plugin packaged as JAR.

#### Add Plug-In to SDK Runtime

Copy the JAR artifact from the previous step to **/ext** directory of the SDK.

Execute **extInstall.sh** script in the root of the SDK to load this plug-in. The project will be re-compiled.

Restart the SDK to have the changes take affect permanently.

You may need to empty browser’s cache (if you haven’t set appropriate HTTP headers) to see the extension.
## Documentation  & Tutorials

Browse SDK docs - http://docs.codenvy.com/sdk/


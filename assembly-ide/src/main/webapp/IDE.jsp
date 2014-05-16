<!--
    CODENVY CONFIDENTIAL
    __________________

    [2012] - [2014] Codenvy, S.A.
    All Rights Reserved.

    NOTICE:  All information contained herein is, and remains
    the property of Codenvy S.A. and its suppliers,
    if any.  The intellectual and technical concepts contained
    herein are proprietary to Codenvy S.A.
    and its suppliers and may be covered by U.S. and Foreign Patents,
    patents in process, and are protected by trade secret or copyright law.
    Dissemination of this information or reproduction of this material
    is strictly forbidden unless prior written permission is obtained
    from Codenvy S.A..
-->

<%@ page import="com.codenvy.commons.env.EnvironmentContext" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Codenvy IDE</title>
    <link rel="shortcut icon" href="/ide/_app/favicon.ico"/>

    <script type="text/javascript" language="javascript">

        /**
         * Base IDE object
         */

        window.IDE = {};

        /**
         * Initial configuration
         */

        window.IDE.config = {

            "workspaceName": <%= EnvironmentContext.getCurrent().getWorkspaceName() == null ? null : "\"" + EnvironmentContext.getCurrent().getWorkspaceName() + "\"" %>,

            "workspaceId": <%= EnvironmentContext.getCurrent().getWorkspaceId() == null ? null : "\"" + EnvironmentContext.getCurrent().getWorkspaceId() + "\"" %>,

            "projectName": window.location.pathname.split("/")[3] ? window.location.pathname.split("/")[3] : null,

            "startupParams": location.search ? location.search.substring(1) : null,

            "hiddenFiles": ".*",

            "facebookLikeURL": "/ide/_app/facebook-like.html",

            "googleLikeURL": "/ide/_app/google-like.html"

        };

        /**
         * Event handlers
         */

        window.IDE.eventHandlers = {};

        window.IDE.eventHandlers.switchToDashboard = function() {
            window.location.href="/dashboard";
        };

        /*
        window.IDE.eventHandlers.initializationFailed = function(message) {
            if (message) {
                window.alert(message);
            } else {
                window.alert("Unable to initialize IDE");
            }
        };
        */

        /**
         * Make URL pretty
         */

        window.history.pushState("", window.document.title, "/ide/" + window.IDE.config.workspaceName);

    </script>

    <script type="text/javascript" src="/ide/_app/greetings/greetings.js"></script>
    <script type="text/javascript" language="javascript" src="/ide/_app/browserNotSupported.js"></script>
    <script type="text/javascript" language="javascript" src="/ide/_app/_app.nocache.js"></script>
</head>
</html>

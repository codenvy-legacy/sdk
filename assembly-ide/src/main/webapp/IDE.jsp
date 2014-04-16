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
        var hiddenFiles = ".*";
        var wsName =<%= EnvironmentContext.getCurrent().getWorkspaceName() == null
                ? null : "\"" + EnvironmentContext.getCurrent().getWorkspaceName() + "\"" %>;
        var wsId =<%= EnvironmentContext.getCurrent().getWorkspaceId() == null
                ? null : "\"" + EnvironmentContext.getCurrent().getWorkspaceId() + "\"" %>;
        var project = null;
        var facebook_like_url = "/ide/_app/facebook-like.html";
        var google_like_url = "/ide/_app/google-like.html";

        var startUpParams = null;
        if(location.search) {
            startUpParams = location.search.substring(1);
        }

        path = window.location.pathname;
        path = path.substring(("/ide/" + wsName).length);
        if (path.substring(0,1) == "/") {
            path = path.substring(1);
        }
        if (path.indexOf("/") != -1) {
            project = path.substring(0, path.indexOf('/'));
        } else if (path != "") {
            project = path;
        }
        newPath = location.pathname;
        if (project != null) {
            newPath = newPath.substring(0, newPath.indexOf("/" +project));
            window.history.pushState("", "Codenvy", newPath);
        }
    </script>

    <script type="text/javascript" language="javascript" src="/ide/_app/browserNotSupported.js"></script>
    <script type="text/javascript" language="javascript" src="/ide/_app/_app.nocache.js"></script>
</head>
</html>

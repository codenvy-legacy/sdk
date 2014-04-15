<%@ page import="com.codenvy.commons.env.EnvironmentContext" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <link rel="shortcut icon" href="_app/favicon.ico"/>
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
        path = window.location.pathname;
        if(location.search){
            startUpParams = location.search.substring(1);
        }
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
</head>
<body>
<script type="text/javascript" language="javascript" src="/ide/_app/browserNotSupported.js"></script>
<script type="text/javascript" language="javascript" src="/ide/_app/_app.nocache.js"></script>
</body>
</html>
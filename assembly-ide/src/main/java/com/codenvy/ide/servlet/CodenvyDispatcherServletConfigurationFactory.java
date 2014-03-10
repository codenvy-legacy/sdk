/*
 * CODENVY CONFIDENTIAL
 * __________________
 *
 * [2012] - [2013] Codenvy, S.A.
 * All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Codenvy S.A. and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to Codenvy S.A.
 * and its suppliers and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Codenvy S.A..
 */
package com.codenvy.ide.servlet;

import com.codenvy.commons.servlet.Action;
import com.codenvy.commons.servlet.Condition;
import com.codenvy.commons.servlet.DispatcherServletConfiguration;
import com.codenvy.commons.servlet.DispatcherServletConfigurationFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/** @author andrew00x */
public class CodenvyDispatcherServletConfigurationFactory extends DispatcherServletConfigurationFactory {
    @Override
    public DispatcherServletConfiguration newDispatcherServletConfiguration() {
        return DispatcherServletConfiguration.create()
                                             .when(new Condition() {
                                                 @Override
                                                 public boolean matches(HttpServletRequest request, HttpServletResponse response) {
                                                     return request.getPathInfo().startsWith("/_app/");
                                                 }
                                             })
                                             .execute(new Action() {
                                                 @Override
                                                 public void perform(HttpServletRequest request, HttpServletResponse response)
                                                         throws ServletException, IOException {
                                                     String path = request.getPathInfo();
                                                     final String query = request.getQueryString();
                                                     if (query != null) {
                                                         path += ('?' + query);
                                                     }
                                                     request.getRequestDispatcher(path).forward(request, response);
                                                 }
                                             })
                                             .priority(100)
                                             .done()
                                             .when(new Condition() {
                                                 @Override
                                                 public boolean matches(HttpServletRequest request, HttpServletResponse response) {
                                                     return request.getAttribute("wsName") == null || request.getAttribute("wsId") == null;
                                                 }
                                             })
                                             .execute(new Action() {
                                                 @Override
                                                 public void perform(HttpServletRequest request, HttpServletResponse response) {
                                                     throw new IllegalStateException("workspace is not set");
                                                 }
                                             })
                                             .priority(200)
                                             .done()
                                             .when(Condition.MATCH)
                                             .execute(new Action() {
                                                 @Override
                                                 public void perform(HttpServletRequest request, HttpServletResponse response)
                                                         throws ServletException, IOException {
                                                     final String wsName = (String)request.getAttribute("wsName");
                                                     final String wsId = (String)request.getAttribute("wsId");
                                                     String path = request.getPathInfo();
                                                     String project = null;
                                                     String filePath = null;
                                                     path = path.substring(('/' + wsName).length());
                                                     if (path.startsWith("/")) {
                                                         path = path.substring(1);
                                                     }
                                                     if (path.contains("/")) {
                                                         project = path.substring(0, path.indexOf('/'));
                                                         filePath = path.substring(path.indexOf('/'));
                                                     } else if (!path.isEmpty()) {
                                                         project = path;
                                                     }
                                                     if (filePath != null) {
                                                         final String query = request.getQueryString();
                                                         if (query != null) {
                                                             filePath += ('?' + query);
                                                         }
                                                     }
                                                     response.setContentType("text/html;charset=UTF-8");
                                                     response.setCharacterEncoding("UTF-8");
                                                     final PrintWriter writer = response.getWriter();
                                                     String redirectUrl = null;
                                                     if (project != null) {
                                                         StringBuilder redirectUrlBuilder = new StringBuilder();
                                                         String scheme = request.getScheme();
                                                         redirectUrlBuilder.append(scheme);
                                                         redirectUrlBuilder.append("://");
                                                         redirectUrlBuilder.append(request.getServerName());
                                                         int port = request.getServerPort();
                                                         if (!(port == 80 || (port == 443 && "https".equals(scheme)))) {
                                                             redirectUrlBuilder.append(':');
                                                             redirectUrlBuilder.append(port);
                                                         }
                                                         redirectUrlBuilder.append('/');
                                                         redirectUrlBuilder.append(request.getContextPath());
                                                         redirectUrlBuilder.append('/');
                                                         redirectUrlBuilder.append(wsName);
                                                         redirectUrl = redirectUrlBuilder.toString();
                                                     }
                                                     writer.write("<html>\n");
                                                     writer.write("  <head>\n");
                                                     if (redirectUrl != null) {
                                                         writer.write(String.format("    <script>window.location.replace(\"%s\");</script>\n",
                                                                                    redirectUrl));
                                                     }
                                                     writer.write("    <script type=\"text/javascript\" language=\"javascript\">\n");
                                                     writer.write("      var hiddenFiles = \".*\";\n");
                                                     writer.write(String.format("      var wsName = \"%s\";\n", wsName));
                                                     writer.write(String.format("      var wsId = \"%s\";\n", wsId));
                                                     if (project != null) {
                                                         writer.write(String.format("      var project = \"%s\";\n", project));
                                                     } else {
                                                         writer.write("      var project = null;\n");
                                                     }
                                                     if (filePath != null) {
                                                         writer.write(String.format("      var path = \"%s\";\n", filePath));
                                                     } else {
                                                         writer.write("      var path = null;\n");
                                                     }
                                                     
                                                     writer.write("      var facebook_like_url = \"/ide/_app/facebook-like.html\";\n");
                                                     writer.write("      var google_like_url = \"/ide/_app/google-like.html\";\n");
                                                     
                                                     writer.write("    </script>\n");
                                                     writer.write("    <link rel=\"shortcut icon\" href=\"_app/favicon.ico\"/>\n");
                                                     writer.write("  </head>\n");
                                                     writer.write("  <body>\n");
                                                     writer.write(
                                                             "    <script type=\"text/javascript\" language=\"javascript\" src=\"_app/browserNotSupported.js\"></script>\n");
                                                     writer.write(
                                                             "    <script type=\"text/javascript\" language=\"javascript\" src=\"_app/_app.nocache.js\"></script>\n");
                                                     writer.write("  </body>\n");
                                                     writer.write("</html>\n");
                                                 }
                                             })
                                             .priority(300)
                                             .done()
                                             .when(new Condition() {
                                                 @Override
                                                 public boolean matches(HttpServletRequest request, HttpServletResponse response) {
                                                     final String host = request.getParameter("h");
                                                     final String port = request.getParameter("p");
                                                     return host != null && port != null;
                                                 }
                                             })
                                             .execute(new Action() {
                                                 @Override
                                                 public void perform(HttpServletRequest request, HttpServletResponse response)
                                                         throws ServletException, IOException {
                                                     request.getRequestDispatcher("/_app/main").forward(request, response);
                                                 }
                                             })
                                             .priority(400)
                                             .done();
    }
}

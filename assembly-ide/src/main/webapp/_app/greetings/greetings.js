/*
 * CODENVY CONFIDENTIAL
 * __________________
 *
 * [2012] - [2014] Codenvy, S.A.
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

/*
   Predefined greeting pages
*/

if (window['IDE'] && window['IDE']['config']) {
    window.IDE.config.greetings = {
      // user anonymous
      "anonymous": null,

      // user authenticated
      "authenticated": "/ide/_app/greetings/rightpane-authenticated.html",

      // anonymous user in temporary workspace
      "anonymous-workspace-temporary": "/ide/_app/greetings/temporary-workspace-rightpane-not-authenticated.html",

      // anonymous user in temporary private workspace
      "anonymous-workspace-temporary-private": "/ide/_app/greetings/temporary-private-workspace-rightpane-not-authenticated.html",

      // authenticated user in temporary workspace
      "authenticated-workspace-temporary": "/ide/_app/greetings/temporary-workspace-rightpane-authenticated.html",

      // authenticated user in temporary private workspace
      "authenticated-workspace-temporary-private": "/ide/_app/greetings/temporary-private-workspace-rightpane-authenticated.html",

      // anonymous user, temporary workspace, google-mbs-client-android project
      "anonymous-workspace-temporary-google-mbs-client-android": "/ide/_app/greetings/temporary-workspace-androidMBS-rightpane-not-authenticated.html",

      // authenticated user, temporary workspace, google-mbs-client-android project
      "authenticated-workspace-temporary-google-mbs-client-android": "/ide/_app/greetings/temporary-workspace-androidMBS-rightpane-authenticated.html"
    };
}

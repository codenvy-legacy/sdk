#
# CODENVY CONFIDENTIAL
# __________________
#
# [2012] - [2013] Codenvy, S.A.
# All Rights Reserved.
#
# NOTICE:  All information contained herein is, and remains
# the property of Codenvy S.A. and its suppliers,
# if any.  The intellectual and technical concepts contained
# herein are proprietary to Codenvy S.A.
# and its suppliers and may be covered by U.S. and Foreign Patents,
# patents in process, and are protected by trade secret or copyright law.
# Dissemination of this information or reproduction of this material
# is strictly forbidden unless prior written permission is obtained
# from Codenvy S.A..
#

IDE_OPTS="          -Dorg.exoplatform.logreader.logpath=${CATALINA_HOME}/logs/logreader"

LOG_OPTS="          -Dorg.apache.commons.logging.Log=org.apache.commons.logging.impl.SimpleLog"

CODENVY_CONFIG_OPTS="   -Xshare:auto -Xms512m -Xmx1024m -XX:MaxPermSize=256m"

JAVA_SRC="          $JAVA_HOME/src.zip"

CODENVY_OPTS="      -Djavasrc=$JAVA_HOME/src.zip \
                    -Djre.lib=$JAVA_HOME/jre/lib \
                    -Dorg.exoplatform.mimetypes=conf/mimetypes.properties \
                    -Dorg.exoplatform.ide.git.server=git \
                    -Dorg.exoplatform.ide.server.fs-root-path=${CATALINA_HOME}/temp/fs-root \
                    -Dtenant.masterhost=localhost \
                    -Dorganization.application.server.url=http://localhost:8080/userdb/ \
                    -Dmailsender.application.server.url=http://localhost:8080/mail/ \
                    -Dcodenvy.local.conf.dir=${CATALINA_HOME}/conf"

#REMOTE_DEBUG="-Xdebug -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n"

JAVA_OPTS="$JAVA_OPTS $LOG_OPTS $CODENVY_CONFIG_OPTS $CODENVY_OPTS $REMOTE_DEBUG $IDE_OPTS"

export JAVA_OPTS
export CLASSPATH="${CATALINA_HOME}/conf/:${CATALINA_HOME}/lib/jul-to-slf4j.jar:${CATALINA_HOME}/lib/slf4j-api.jar:${CATALINA_HOME}/lib/logback-classic.jar:${CATALINA_HOME}/lib/logback-core.jar:${JAVA_HOME}/lib/tools.jar"

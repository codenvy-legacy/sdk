#!/bin/sh

# -------------------------------------------------------------------
# Script to integrate 3rd-party extensions to existing Codenvy IDE.
# -------------------------------------------------------------------

# Specifies the location of the directory that contains 3rd-party extensions
EXT_DIR_REL_PATH="ext"

# Specifies the location of the directory that contains resource files to re-build Codenvy IDE
EXT_RES_DIR_REL_PATH="sdk-resources"
EXT_RES_WORK_DIR_REL_PATH="sdk-resources/temp"

# Install every 3rd-party extension into local Maven repository
for file in $EXT_DIR_REL_PATH/*.jar
do
    if [ -f $file ]; then
        mvn org.apache.maven.plugins:maven-install-plugin:2.5.1:install-file -Dfile=$file
    fi
done

# Prepare to re-build Codenvy IDE
java -cp "sdk-tools/codenvy-sdk-tools.jar" com.codenvy.ide.sdk.tools.InstallExtension --extDir=$EXT_DIR_REL_PATH --extResourcesDir=$EXT_RES_DIR_REL_PATH

# Re-build Codenvy IDE
cd $EXT_RES_WORK_DIR_REL_PATH
mvn clean package
cd ../..
cp $EXT_RES_WORK_DIR_REL_PATH/target/*.war webapps/ide.war
rm -rf webapps/ide

echo Restart Codenvy IDE if it is currently running

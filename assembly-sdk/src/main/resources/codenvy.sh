#!/bin/sh

path=$(pwd)

TOMCAT="$path/tomcat"

if [ ! -d "$TOMCAT" ]

then

echo "$(tput setaf 2)INFO: No Tomcat found for runners"$(tput sgr0)

echo "$(tput setaf 2)INFO: Downloading Apache Tomcat for runners"$(tput sgr0)
sleep 2
tomcatVersion="7.0.52"
tomcatDir="apache-tomcat-"${tomcatVersion}
curl http://apache-mirror.telesys.org.ua/tomcat/tomcat-7/v${tomcatVersion}/bin/apache-tomcat-${tomcatVersion}.zip > $tomcatDir.zip
unzip $tomcatDir
rm apache-tomcat-${tomcatVersion}.zip
mv $tomcatDir tomcat
rm -rf $tomcatDir
echo "$(tput setaf 2)INFO: Tomcat $tomcatVersion for runners successfully downloaded"$(tput sgr0)
fi

echo "$(tput setaf 2)INFO: Launching Codenvy SDK"$(tput sgr0)
sleep 1

  cd bin
  ./codenvy.sh $1 $2 $3 $4 $5 $6 $7 $8 $9 $10 $11 $12 $13 $14 $15 $16 $17 $18 $19 $20



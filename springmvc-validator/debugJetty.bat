set MAVEN_BATCH_PAUSE=on
set MAVEN_OPTS=-Xdebug -Xnoagent -Djava.compiler=NONE -Dfile.encoding=UTF-8 -Xrunjdwp:transport=dt_socket,address=8787,suspend=n,server=y -Xms256m -Xmx512m -XX:MaxPermSize=128m 
mvn clean jetty:run
FROM maven:latest as target
COPY basicmavenwebapp/settings-docker.xml /usr/share/maven/ref/
COPY basicmavenwebapp/pom.xml /basicmavenwebapp/pom.xml
COPY basicmavenwebapp/src/ /basicmavenwebapp/src
RUN mvn -B -f /basicmavenwebapp/pom.xml -s /usr/share/maven/ref/settings-docker.xml dependency:resolve 
RUN mvn -B -f /basicmavenwebapp/pom.xml -s /usr/share/maven/ref/settings-docker.xml package

# FROM maven:latest as target
# WORKDIR /basicmavenwebapp
# COPY /basicmavenwebapp /basicmavenwebapp
# RUN mvn dependency:resolve && mvn package

FROM tomcat:jdk15
COPY --from=target /basicmavenwebapp/target /usr/local/tomcat/webapps/
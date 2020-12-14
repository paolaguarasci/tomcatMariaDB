FROM maven:3.6.3-openjdk-16 AS MAVEN_BUILD
COPY ./basicmavenwebapp ./
RUN mvn package

FROM tomcat:jdk15
COPY --from=MAVEN_BUILD /target/basicmavenwebapp.war /usr/local/tomcat/webapps/
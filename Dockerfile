# the first stage of our build will use a maven 3.6.1 parent image
FROM maven:3.6.3-openjdk-16 AS MAVEN_BUILD

# copy the pom and src code to the container
COPY ./basicmavenwebapp ./

# package our application code
RUN mvn clean package

# # the second stage of our build will use open jdk 8 on alpine 3.9
# FROM openjdk:8-jre-alpine3.9

# # copy only the artifacts we need from the first stage and discard the rest
# COPY --from=MAVEN_BUILD /docker-multi-stage-build-demo/target/demo-0.0.1-SNAPSHOT.jar /demo.jar

# # set the startup command to execute the jar
# CMD ["java", "-jar", "/demo.jar"]

# we are extending everything from tomcat:8.0 image ...
FROM tomcat:jdk15
# COPY path-to-your-application-war path-to-webapps-in-docker-tomcat
COPY --from=MAVEN_BUILD /target/basicmavenwebapp.war /usr/local/tomcat/webapps/
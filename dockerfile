# we are extending everything from tomcat:8.0 image ...
FROM tomcat:10.0.0
# COPY path-to-your-application-war path-to-webapps-in-docker-tomcat
COPY ./basicmavenwebapp/target/basicmavenwebapp.war /usr/local/tomcat/webapps/
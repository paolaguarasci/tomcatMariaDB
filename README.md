# Maria DB + Tomcat + MVN
### In docker container

### Connessione al pod con mariadb
```bash
$ oc get pods
$ oc rsh <pods name>
$ mysql -u$MYSQL_USER -p$MYSQL_PASSWORD -h$HOSTNAME $MYSQL_DATABASE
```
# Maria DB + Tomcat + MVN
### In docker container

### Connessione al pod con mariadb e init (solo ephimeral)
```bash
$ oc get pods
$ oc rsync ./crete.sql <pod_name>:/
$ oc rsh <pods name>
$ mysql -u$MYSQL_USER -p$MYSQL_PASSWORD -h$HOSTNAME $MYSQL_DATABASE < /create.sql
```
### Upload/Download file dal pod
container -> locale
```bash
$ oc rsync <pods name>:/ .
```

locale -> container
```bash
$ oc rsync . <pods name>:/
```
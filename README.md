# Maria DB + Tomcat + MVN
### In docker container

### Deploy da zero

1. Crea un Dockerfile
2. Pusha su un repository pubblico di GitHub
3. Crea un nuovo progetto openshift
4. Clicca su +Add -> **From Dockerfile**
   - Inserisci nel campo Git Repo URL il link al repository del punto 2
   - Il Nome dell'applicazione deve essere unico
   - Togli la spunta alla casella "Create a route to the application" (la rotta la creeremo manualmente dopo perche' questa di default e' su http, a noi serve su https)
5. In Project -> Pods c'e' la lista di pods al momento attivi.
6. Ora aggiungi **mariadb** cliccando su +Add -> database -> mariadb ephimeral -> instanziate template
7. Compila i campi per come si aspetta il **tomcat**, in questo caso:
   - **Database Service Name**: mariadb
   - **MariaDB Connection Username**: paola
   - **MariaDB Connection Password**: paola
   - **MariaDB root Password**: paola
   - **MariaDB Database Name**: provaDB
8. Da Topology, trascinare il db sul tomcat tenendo premuto SHIFT (li si mette nella stessa sottorete)
9.  Collegare la freccia (Visual Connector) da Tomcat a MariaDB
10. Da Topology cloccare con il destro sul tomcat e scegliere "Edit Deployment"
11. Nella tab Enviropment aggiungere le seguenti variabili d'ambiente scegliendo per ognuna
    - **MYSQL_USER** in database/database-user
    - **MYSQL_PASSWORD** in database/database-password
    - **MYSQL_DATABASE** in database/database-name
    - **MYSQL_ROOTPASSWORD** in database/database-rootpass
12.  Rifare la build del tomcat
13.  In visione ADMINISTRATOR > networking > routes, creiamo una nuova rotta per il nostro tomcat, ricordandoci di 
    - spuntare "Secure route"
    - TLS termination = Edge 
    - Insecure traffic = Redirect 
14.  Se ora usiamo la rotta appena creata vediamo un tomcat che accede al db ma il db e' vuoto.
15.  Apriamo il terminale con il cli oc installato e popoliamo il db
16.  login tramite token 
17. spostiamoci nella cartella sul computer locale che contiene il file .sql con il database
18. assicurarsi di stare operando sul progetto desiderato usando ```oc project```
19. digitare ```oc get pods``` per ottenere la lista di pods del progetto
20. prendere nota del pods con nome che inizia con mariadb e che e' in stato ready
21. ASSICURATI DI AVER SEGUITO IL PUNTO 16
22. esegui ```oc rsync . <pod_name>:/var/lib/mysql``` per caricare l'**intero** contenuto della posizione locale corrente sulla macchina virtuale
23. accedi alla shell remota con ```oc rsh <pod_name>```
24. spostati nella cartella corretta ```cd /var/lib/mysql```
25. popola il db ```mysql -u$MYSQL_USER -p$MYSQL_PASSWORD -h$HOSTNAME $MYSQL_DATABASE < ./create.sql```
26. Ora dovrebbe essere tutto ok quindi controlla usando il link del punto 13!



### Connessione al pod con mariadb e init (solo ephimeral)
```bash
$ oc get pods
$ oc rsync ./create.sql <pod_name>:/var/lib/mysql
$ oc rsh <pod_name>
$ cd /var/lib/mysql
$ mysql -u$MYSQL_USER -p$MYSQL_PASSWORD -h$HOSTNAME $MYSQL_DATABASE < ./create.sql
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
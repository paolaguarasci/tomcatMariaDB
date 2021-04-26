CREATE TABLE IF NOT EXISTS `utente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `cognome` varchar(100) DEFAULT NULL,
  `dataDiNascita` varchar(100) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;


INSERT INTO provaDB.utente (nome,cognome,dataDiNascita,username) VALUES
	 ('paola','rossi','12/11/2002','p.rossi'),
	 ('michele','bianchi','13/02/1986','m.bianchi'),
	 ('giuseppe ','rossi','19/06/1980','g.rossi'),
	 ('antonio','verdi','03/09/1973','a.verdi');

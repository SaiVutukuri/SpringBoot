CREATE TABLE userdb.user (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `role` varchar(15) NOT NULL,
  `email` varchar(45) NOT NULL UNIQUE,
  `password` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
);
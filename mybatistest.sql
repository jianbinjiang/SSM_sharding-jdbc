    drop database if exists demodb00;  
    CREATE database demodb00 DEFAULT CHARACTER SET utf8;  
      
    CREATE TABLE demodb00.user (  
      id int(11) NOT NULL AUTO_INCREMENT,  
      name varchar(100) DEFAULT NULL,  
      age int(11) DEFAULT NULL,  
      PRIMARY KEY (id),  
      UNIQUE KEY id_UNIQUE (id)  
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;  
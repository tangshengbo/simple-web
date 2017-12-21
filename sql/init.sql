CREATE TABLE customer (
  id INT NOT NULL AUTO_INCREMENT,
  NAME VARCHAR (255) DEFAULT NULL,
  contact VARCHAR (255) DEFAULT NULL,
  email VARCHAR (255) DEFAULT NULL,
  telephone VARCHAR (255) DEFAULT NULL,
  remark TEXT,
  PRIMARY KEY (id)
) ENGINE = INNODB DEFAULT CHARSET = utf8 ;
INSERT INTO customer (NAME, contact, telephone, email, remark) VALUES ('customer1', 'Jack', '13112345678', 'jack@gmail.com', NULL);
INSERT INTO customer (NAME, contact, telephone, email, remark) VALUES ('customer2', 'Rose', '13612345678', 'rose@gmail.com', NULL);
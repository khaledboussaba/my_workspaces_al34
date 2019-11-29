
DROP TABLE IF EXISTS T_PRODUIT;

CREATE TABLE  T_PRODUIT (ref INTEGER NOT NULL PRIMARY KEY auto_increment, 
                         designation VARCHAR(255), 
                         prix_ht DOUBLE , 
                         taux_tva DOUBLE default 20.0);
                         
                 
INSERT INTO T_PRODUIT(designation,prix_ht)  VALUES ('cahier',3.3);
INSERT INTO T_PRODUIT(designation,prix_ht)  VALUES ('stylo bille',1.35);
INSERT INTO T_PRODUIT(designation,prix_ht)  VALUES ('crayon',1.3);                               

show tables;
select * from T_PRODUIT;


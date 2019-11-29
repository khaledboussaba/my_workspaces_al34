Préparations préliminaires:
==========================
* lancer si besoin sous eclipse un "maven / update project" pour récupérer les ".jar"
* modifier la valeur de la variable MVN_REPOSITORY du fichier src/main/config/database/set_env.bat
  selon la configuration de l'ordinateur (adapter le chemin selon le système de fichiers)
* lancer le script "create_h2_database.bat" via "open with..." / "system Editor"
* lancer le test unitaire "tp.test.MyAppTest" (dans src/test/java)
* regarder la structure globale du code (tp.entity , tp.dao , ...)

TP1
===
partie A / Singleton
--------------------
Programmer le design pattern "Singleton" sur la classe tp.dao.ProduitDaoFactory
et tester celui-ci en adaptant les méthodes "testSingleton" et "subTestSingleton" de "MyAppTest"

partie B / Factory Method
-------------------------
Programmer le design pattern "factoty method" sur la classe tp.dao.ProduitDaoFactory
et tester celui-ci en adaptant la méthode "setUp" de "MyAppTest"


TP2 Design pattern strategie / DataSource
=========================================
L'objectif du TP2 consiste à "sortir" de la classe "ProduitDaoJdbc" le code de connection à la base de données
de façon à ce que la connexion puisse prendre pluieurs formes différentes (plusieurs STRATEGIES possibles).

Le nouveau composant responsable d'établir la connexion jdbc est de type prédéfini "javax.sql.DataSource"
et "tp.ds.MyJndiDataSource" est une implementation qui ne fonctionne qu'avec un serveur JEE
et "tp.ds.MyParamDataSource" est un début d'implémentation utilisable en test/développement .

La classe "DataSourceFactory" (avec un Singleton) comporte une méthode
de fabrication "getDataSource()" qui tente d'abord la version tp.ds.MyJndiDataSource
et qui se replie vers la version tp.ds.MyParamDataSource si la première ne fonctionne pas.

Les fichiers à modifier (en tenant compte des commentaires) pour le TP2 sont :
* tp.ds.MyParamDataSource.java
* tp.dao.ProduitDaoJdbc.java

TP3 IOC / Injection de dépendance simple (en java un peu rigide)
===============================================================
La liaison entre le DAO (jdbc ou autre) et le composant "DataSource" en version "Param" ou "Jndi"
est maintenant gérée par le design pattern injection de dépendance (alias IOC).
Cette première version simple de "IOC" au niveau du TP3 ressemble un peu à l'esprit "Java Config" de Spring4
Première étape du TP3 = comprendre la nouvelle structure du code:
---------------------------------------------------------------
- certains fichiers de configurations ne sont plus utilisés : 
   myDB.properties.withoutIoc.txt , produitDao.properties.withoutIoc.txt
- certaines classes (petites fabriques) ne sont plus utilisées:
   ProduitDaoFactory.java.withoutIoc.txt , DataSourceFactory.java.withoutIoc.txt
- la classe MyParamDataSource n'analyse plus en direct myDB.properties
- la classe ProduitDaoJdbc n'initialise plus le dataSource via DataSourceFactory
- la nouvelle classe MySimpleJavaConfigIOC est au coeur de la nouvelle structure/configuration.
   

Deuxième étape du TP3 = coder les parties "A FAIRE en TP" dans les 2 classes suivantes:
-------------------------------------------------------------------------------------
* tp.dao.ProduitDaoJdbc
* tp.ioc.MySimpleJavaConfigIOC
Puis effectuer différents tests en SWITCHANT de ligne dao = new ProduitDaoXyz()


TP3B : Analyser le code et la configuration IOC en version XML
==============================================================
Cette etape du TP vise à  montrer une configuration XML
possible de l'injection de dépendance (quasiment la même que Spring)
Partie du code à analyser:
   - src/main/resources/myIocConfig.xml
   - nouvelle version de la méthode setUp() de MyAppTestWithIoc
   - (en diagonale , dans les grandes lignes) : tp.ioc.MyIocBeanConf , tp.ioc.MyIocConfig
                                                tp.ioc.MyXmlBeanFactory
                                                
TP4 (Service et DTO):
====================
A faire en se basant sur la base du TP4_debut

* Analyser le code (déjà écrit)  
    - de la nouvelle classe tp.dto.ProduitDto
    - du Service tp.service.GestionProduits / GestionProduitsImpl 
* configurer le service (et l'injection du DAO) dans myIocConfig.xml
* tester

Suite facultative pour tp 4:
 - ajouter une méthode public void updateProduitViaDto(ProduitDto p)
   au sein du service , la programmer et la tester

TP5: Facade pour ensemble de Services
=====================================
A faire en se basant sur la base du TP5_debut

* Analyser le code des services élémentaires suivants:
   - GestionTva/GestionTvaImpl avec un calcul de Tva avec ht et tauxPct
   - GestionConv/GestionConvUmpl avec euroToFrancs , francToEuros , 6.5597
* Analyser la configuration de ces nouveaux services  dans myIocConfig.xml 
* Coder une facade de services (éventuellement "agnostique vis à vis de IOC/XML") et la tester
  Concrètement : terminer la programmation des classes tp.services.MyFacadeImpl
                                                    et tp.test.MyAppFacadeTest
                                               


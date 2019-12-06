depuis la version 3.2 Hibernate peut se configurer et se programmer de multiples facons:
========================================================================================

* la configuration du mapping "objet-relationnel" peut etre formulee/parametree 
       - par des fichiers xyz.hbm.xml proprietaires "hibernate" (ancien style des annees 2003-2007)
       - par des annotations normalisées "JPA" (@Entity , @Id, ...)
       - par des fichiers xyz.orm (normalises "JPA" mais souvent utilises que pour 
         redefinir des configurations deja precisees par des annotations , xml plus precis)
         
* le code java donnant des ordres a la technologie "Hibernate" a 2 entrees possibles:
       - "SessionFactory" et "Session" (specifique "Hibernate") 
       - "EntityManagerFactory" et "EntityManager" (interface normalisee de "JPA"        
          sachant que Hibernate >= 3.2 implemente JPA1
                      Hibernate >= 3.5 implemente JPA2
                      
       - l'utilisation de "EntityManager" va toujours avec une configuration JPA du mappping (annotations et/ou orm.xml)
       - l'utilisation de "SessionFactory" , "Session" peut soit
         s'effectuee avec une configuration JPA (@Entity , @Id) , soit s'effectue avec de vieux fichiers "...hbm.xml".
         
       - A l'epoque de JPA 1 , il y avait encore pas mal de fonctionnalites "Hibernate" qui
         etaient accessibles via "Session" mais pas via "EntityManager".
       - A l'epoque de JPA 2, il n'y a plus beaucoup de fonctionnalites "Hibernate" qui ne sont pas
         accessibles via "EntityManager" et la configuration associee
         
       - D'autre part en codant "Session session = (Session) entityManager.getDelegate(); " 
         on peut ecrire 85% du code en s'appuyant sur le standard "JPA/EntityManager" 
            et 15% du code en s'appuyant en direct sur l'implementation interne d'Hibernate
            
* Finalement ,  Hibernate et/ou JPA peuvent etre utilises "Tout seul" ou bien 
  avec un framework JEE gerant les transactions ("Spring" ou "EJB3" )
        - Lorsque JPA/Hibernate est utilise seul , il faut programmer le declenchement des transactions (.begin() , .commit() / .rollback() )
        - Lorsque JPA/Hibernate est integre dans Spring ou les EJB3 , les transactions sont gerees de manieres declaratives (ex: @Trnasactional)
          et le framework "Spring" ou "EJB3" declenche automatiquement des ".commit()" quand tout va bien
                                                                    et des ".rollback()" lorqu'une "runtimeException" remonte    
                                                                    
CONCLUSION ==> PLEIN DE VARIANTES POSSIBLES dans l'UTILISATION d'HIBERNATE.

Autour de la partie "Devise/Pays" , Toutes ces variantes ont ete configurees dans le point de depart du projet (de TP) "tpHibernateJpa"
--> CONTINUER LES "TP" selon le STYLE FAVORI  ("Session" ou "EntityManager" , avec ou sans "Spring" , ...) .                                                                         

                                               
         
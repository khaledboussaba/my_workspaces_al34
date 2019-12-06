export MVN_REPOSITORY=${HOME}/.m2/repository

export MY_H2_DB_URL=jdbc:h2:~/devise_db

export H2_VERSION=1.4.191
export H2_CLASSPATH=${MVN_REPOSITORY}/com/h2database/h2/${H2_VERSION}/h2-${H2_VERSION}.jar

java -classpath ${H2_CLASSPATH} org.h2.tools.RunScript -url ${MY_H2_DB_URL}  -user sa -script init_devise_db.sql -showResults

cd /d %~dp0
call set_env.bat

java -classpath %H2_CLASSPATH% org.h2.tools.RunScript -url %MY_H2_DB_URL%  -user sa -script create_test_designPatterns_db.sql -showResults

pause
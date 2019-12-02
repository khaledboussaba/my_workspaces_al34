cd /d "%~dp0"
set POSTGRESQL_HOME=D:\Prog\PostgreSQL\9.6
REM POSTGRESQL_HOME=C:\Program Files\PostgreSQL\9.6
"%POSTGRESQL_HOME%\bin\psql" -U postgres -f create-db.sql
REM password may be root or ...
pause
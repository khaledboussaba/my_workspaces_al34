cd /d "%~dp0"
set WSDL_URL=http://localhost:8080/servEjb/CalculTvaImpl?wsdl
set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_231
REM wsimport est dans jdk../bin
"%JAVA_HOME%\bin\wsimport" -d src/main/java -keep %WSDL_URL%
pause
REM refresh eclipse
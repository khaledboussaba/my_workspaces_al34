cd /d "%~dp0"
set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_231

REM xjc va analyser commande.xsd et generer des classes Java dans le package fr.al34.tp.data2
"%JAVA_HOME%\bin\xjc" -d src/main/java -p fr.al34.tp.data2 src/main/resources/commande.xsd
pause
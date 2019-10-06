REM SET JAVA14_HOME=C:\Program Files\Java\jdk-14+35
SET JAVA14_HOME=C:\Program Files\Java\jdk-14+49

SET JAVA_HOME=%JAVA14_HOME%
SET PATH=%JAVA14_HOME%\bin;%PATH%

del *.class

javac Main.java

del OptionalService.class

java Main
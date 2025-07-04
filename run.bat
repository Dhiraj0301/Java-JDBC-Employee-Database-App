@echo off
echo Compiling Java files...
javac -cp "lib/mysql-connector-j-9.0.0.jar" *.java

echo Running EmployeeCRUD...
java -cp "lib/mysql-connector-j-9.0.0.jar;." EmployeeCRUD

pause

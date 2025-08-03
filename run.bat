@echo off
echo Compiling Java Timer App...
javac TimerApp.java -d build

if %ERRORLEVEL% NEQ 0 (
    echo Compilation failed!
    pause
    exit /b 1
)

echo Compilation successful!
echo Running Java Timer App...
java TimerApp

pause

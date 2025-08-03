#!/bin/bash

echo "Compiling Java Timer App..."

javac "./TimerApp.java" -d "build"
javac_result=$?

if ((javac_result != 0)); then
    print "Compilation failed! javac returned '${javac_result}'"
    exit 1
fi

echo "Compilation successful!"

cd build
echo "Running Java Timer App..."
java TimerApp

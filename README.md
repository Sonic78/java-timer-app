# java-timer-app

A simple timer application built with Java Swing that provides start, stop, and reset functionality.

## Features

- **Timer Display**: Shows time in HH:MM:SS format
- **Start Button**: Starts the timer countdown
- **Stop Button**: Pauses the timer (can be resumed with Start)
- **Reset Button**: Resets the timer back to 00:00:00

## How to Run

### Method 1: Using the batch file (Windows)
1. Double-click `run.bat` to compile and run the application

### Method 2: Manual compilation
1. Open Command Prompt or PowerShell in this directory
2. Compile: `javac TimerApp.java`
3. Run: `java TimerApp`

## Requirements

- Java Development Kit (JDK) 8 or higher
- Windows, macOS, or Linux operating system

## Usage

1. Click **Start** to begin the timer
2. Click **Stop** to pause the timer
3. Click **Reset** to reset the timer to 00:00:00
4. The timer will continue running until you stop or reset it

## Technical Details

- Built with Java Swing for the GUI
- Uses javax.swing.Timer for accurate timing
- Updates every second (1000ms intervals)
- Displays time in hours:minutes:seconds format


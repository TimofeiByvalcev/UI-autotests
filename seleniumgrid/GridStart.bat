@echo off

:: Start Selenium Grid Hub
start cmd /k java -jar selenium-server-4.15.0.jar hub

:: Start Selenium Grid Node
start cmd /k  java -jar selenium-server-4.15.0.jar node --port 5556 --selenium-manager true
start cmd /k  java -jar selenium-server-4.15.0.jar node --port 5557 --selenium-manager true
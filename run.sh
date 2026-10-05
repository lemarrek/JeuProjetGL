#!/bin/bash
echo "=== Compilation Maven ==="
mvn clean compile

echo "=== Lancement du jeu ==="
java -cp target/classes fr.polytech.jeu.Main

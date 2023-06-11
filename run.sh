#!/bin/bash

# Build the Maven project
mvn clean install -DskipTests

# Check if the build was successful
if [ $? -ne 0 ]; then
  echo "Build failed. Exiting..."
  exit 1
fi

# Collect the arguments passed to the script
arguments="$@"

# Run the Maven application with arguments
mvn exec:java -Dexec.mainClass="fr.esgi.todolist.Main" -Dexec.args="$arguments"

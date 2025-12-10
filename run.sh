chmod +x run.sh
#!/bin/bash
set -e

mkdir -p out
echo "Compilando..."
javac -d out src/Main.java

if [ "$1" = "run" ] || [ -z "$1" ]; then
  echo "Executando..."
  java -cp out Main
fi

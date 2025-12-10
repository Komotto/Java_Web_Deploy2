chmod +x run.sh


## **3) `run.sh` (script para compilar e executar)**

```bash
#!/bin/bash

mkdir -p out

if [ "$1" = "compile" ]; then
    echo "Compilando..."
    javac -d out src/Main.java
    exit
fi

if [ "$1" = "run" ]; then
    echo "Executando..."
    java -cp out Main
    exit
fi

echo "Compilando e executando..."
javac -d out src/Main.java && java -cp out Main




bash run.sh run


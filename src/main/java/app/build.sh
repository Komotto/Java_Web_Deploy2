#!/bin/bash
set -e

echo "Limpando build antigo..."
rm -rf build app.war

echo "Criando estrutura..."
mkdir -p build/WEB-INF/classes

echo "Compilando servlet (Jakarta)..."
javac \
  -cp /usr/share/java/tomcat-servlet-6.0-api.jar \
  -d build/WEB-INF/classes \
  src/main/java/app/HelloServlet.java

echo "Copiando web.xml..."
cp web/WEB-INF/web.xml build/WEB-INF/

echo "Gerando WAR..."
cd build
jar cvf ../app.war .
cd ..

echo "WAR criado com sucesso"


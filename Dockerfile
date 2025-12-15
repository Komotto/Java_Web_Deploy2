FROM tomcat:10.1

# Remove aplicações padrão
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copia o WAR para o Tomcat
COPY app.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]


FROM maven:3.8.4-jdk-8 as build

# Trazendo todos os arquivos da aplicação

# Dentro do container vai ter uma pasta app
# E dentro da pasta app vai ter um src

# Copiando os arquivos de src para dentro do container
COPY src /app/src
COPY pom.xml /app

# Entrando no diretorio app
WORKDIR /app
# Instalando as dependencias do projeto
RUN mvn clean install

FROM openjdk:8-jre-alpine

# Vai dar erro por que não achei o jar dessa aplicação lixo
COPY --from=build /app/target/spring-boot-1-demo-0.0.1-SNAPSHOT.jar /app/app.jar

WORKDIR /app

# Expondo a porta 8080
EXPOSE 8080

CMD ["java","-jar","app.jar"]
# Essa imagem do maven é a imagem base para criação de um container
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

# Estamos utilizando essa imagem para rodar uma aplicação java ou kotlin
FROM openjdk:8-jre-alpine

COPY --from=build /target/demo-0.0.1-SNAPSHOT.jar /app/app.jar

WORKDIR /app

# Expondo a porta 8080
EXPOSE 8080

CMD ["java","-jar","app.jar"]
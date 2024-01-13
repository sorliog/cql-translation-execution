FROM eclipse-temurin:17-jdk-alpine
LABEL authors="sorliog"
VOLUME /tmp
COPY cqltestserver/target/*.jar /home/server.jar
COPY clinical_quality_language-3.5.1/Src/java/cql-to-elm-cli/build/install/cql-to-elm-cli/ /home/cql-to-elm-cli
ENV CQL_TO_ELM_CLI_PATH=/home/cql-to-elm-cli

ENTRYPOINT ["java","-jar","/home/server.jar"]

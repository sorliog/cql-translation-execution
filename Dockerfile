FROM eclipse-temurin:17-jdk-alpine
LABEL authors="cdss4pcp"
ARG clinicalQualityLanguageVersion=3.2.0
ARG CQL_TEST_SERVER_VERSION=1.0.0

#VOLUME /tmp
COPY cqltestserver/target/cqltestserver-$CQL_TEST_SERVER_VERSION.jar /home/server.jar
COPY cql-to-elm-cli/cql-to-elm-cli-$clinicalQualityLanguageVersion/ /home/cql-to-elm-cli
ENV CQL_TO_ELM_CLI_PATH=/home/cql-to-elm-cli

ENTRYPOINT ["java","-jar","/home/server.jar"]

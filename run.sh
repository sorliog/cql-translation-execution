#!/bin/sh
CQL_TEST_SERVER_VERSION="1.0.0"

# First compile server
if [ ! -e "./cqltestserver/target/cqltestserver-$CQL_TEST_SERVER_VERSION.jar" ];
then
  echo "Could not find ./cqltestserver/target/cqltestserver-$CQL_TEST_SERVER_VERSION.jar"
  echo "Attempting to compile server jar"
  cd cqltestserver
  mvn clean package

  if [ $? -ne 0 ]; then
      exit $?
  fi

  cd ../
else
    echo "Found File ./cqltestserver/target/cqltestserver-$CQL_TEST_SERVER_VERSION.jar"
    echo "Will not attempt to compile server jar"
fi


# Build and Run the container
docker build -t cdss4pcp/cql-testing-server .
docker run --rm -d --name cql-testing-server -p 7777:8080 -t cdss4pcp/cql-testing-server

echo "Server is running at http://localhost:7777"
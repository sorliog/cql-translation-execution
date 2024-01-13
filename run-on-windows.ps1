$CQL_TEST_SERVER_VERSION = "1.0.0"



$jarExists = Test-Path -Path "$( Get-Location )\cqltestserver\target\cqltestserver-$CQL_TEST_SERVER_VERSION.jar"
# First compile server
if ($jarExists -eq $false)
{
    echo "Could not find $( Get-Location )\cqltestserver\target\cqltestserver-$CQL_TEST_SERVER_VERSION.jar"
    echo "Attempting to compile server jar"
    cd cqltestserver
    mvn clean package
    if ($LastExitCode -ne 0)
    {
        exit $LastExitCode
    }

}
else
{
    echo "Found File ./cqltestserver/target/cqltestserver-$CQL_TEST_SERVER_VERSION.jar"
    echo "Will not attempt to compile server jar"
}

# Build and Run the container
docker build -t cdss4pcp/cql-testing-server .
docker run --rm -d --name cql-testing-server -p 7777:8080 -t cdss4pcp/cql-testing-server

echo "Server is running at http://localhost:7777"



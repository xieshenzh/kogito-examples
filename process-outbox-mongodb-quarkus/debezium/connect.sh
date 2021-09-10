set -eu

until $(curl --output /dev/null --silent --head --fail $HOSTNAME:8083); do
    echo "Wait for Debezium"
    sleep 3
done

echo "Start MongoDB connector"

curl -i -X POST -H "Accept:application/json" -H  "Content-Type:application/json" $HOSTNAME:8083/connectors/ -d @/register-mongodb.json

echo "MongoDB connector started"
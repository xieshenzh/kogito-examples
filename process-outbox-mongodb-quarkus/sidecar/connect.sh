set -eu

until $(curl --output /dev/null --silent --head --fail $CONNECT_HOSTNAME:$CONNECT_PORT); do
    echo "Wait for Debezium"
    sleep 3
done

echo "Start MongoDB connector"

curl -i -X POST -H "Accept:application/json" -H  "Content-Type:application/json" $CONNECT_HOSTNAME:$CONNECT_PORT/connectors/ -d @/usr/local/bin/register-mongodb.json

echo "MongoDB connector started"
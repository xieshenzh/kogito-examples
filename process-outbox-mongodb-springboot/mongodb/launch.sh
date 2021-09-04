bash -c '/usr/local/bin/init-kogito.sh' &
mongod --replSet rs0 --auth --keyFile /usr/local/bin/keyfile

# K

docker run -d --name mongo-k -e MONGO_INITDB_ROOT_USERNAME=mongoadmin -e MONGO_INITDB_ROOT_PASSWORD=secret -p 27017:27017 mongo


docker run --net=host --rm --name=kquotes -e MONGO_HOST=localhost -e MONGO_PORT=27017 -e MONGO_USER=mongoadmin -e MONGO_PWD=secret k-snapshot:1.0-SNAPSHOT

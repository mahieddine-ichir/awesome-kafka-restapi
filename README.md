# Awesome simple Kafka Rest API
Kafka simple Rest API written in Spring (Boot) that a exposes endpoints, to write data (binary)
to a Kafka cluster.

## Exposed endpoints

* POST, `/api`: to post any binary data to be written to kafka
* POST, `/api/{key}`: to post any binary data written to kafka

## Example usages

### Sending JSON Data
````sh
    curl http://localhost:8080/api -d '{"id": "anyId"}'
````

### Sending JSON Data with a key
````sh
    curl http://localhost:8080/api/[key] -d '{"id": "anyId"}'
````

### Sending any binary/string data with a key
````sh
    curl http://localhost:8080/api/[key] -d 'Hello world!'
````

```bash
$ confluent start

This CLI is intended for development only, not for production
https://docs.confluent.io/current/cli/index.html

control-center is [UP]
ksql-server is [UP]
connect is [UP]
kafka-rest is [UP]
schema-registry is [UP]
kafka is [UP]
zookeeper is [UP]

```

Confluent Control Center

```
http://localhost:9021
```


```bash
echo '{
        "city": "Bern",
        "postCode": "3011",
        "streetName": "Seilerstrasse",
        "streetNr": "6"
    }' | http patch :8080/customers/1/address
```


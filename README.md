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
http :8080/customers/1
```

```json
{
    "_links": {
        "update-address": {
            "href": "http://localhost:8080/customers/1/address"
        }
    },
    "address": {
        "canton": "Zurich",
        "city": "Zurich",
        "postCode": "8045",
        "streetName": "Manessestrasse",
        "streetNr": "87"
    },
    "birthDate": "1983-03-08",
    "contract": {
        "products": [
            "Basic health insurance FAMILY_DOCTOR_MODEL --- CHF 295.6",
            "Supplementary outpatient insurance PLUS --- CHF 19.6",
            "Supplementary hospital insurance HOSPITA_FLEX --- CHF 9.4",
            "Supplementary dental insurance DENTAL --- CHF 26.0",
            "Legal expenses insurance in health matters PROTECT --- CHF 1.5"
        ],
        "validFrom": "2017-01-03"
    },
    "email": "johndoe@gmail.com",
    "gender": "MALE",
    "mobile": "+4111223344",
    "name": "John Doe"
}
```

Messaging example

```bash
echo '{
        "city": "Bern",
        "postCode": "3011",
        "streetName": "Seilerstrasse",
        "streetNr": "6",
        "canton":"Bern"
    }' | http patch :8080/customers/1/address
```

```bash
echo '{
        "city": "Zurich",
        "postCode": "8045",
        "streetName": "Manessestrasse",
        "streetNr": "87"
    }' | http patch :8080/customers/1/address
```


```yaml
stubrunner:
  stubsMode: LOCAL
  ids:
    - com.mimacom.lunchandlearn:contract-service:+:9876
```

```bash
$ spring cloud stubrunner
```

```bash
$ http :8750/stubs

{
  com.mimacom.lunchandlearn:contract-service:0.0.1-SNAPSHOT:stubs: 9876
}
```

```bash
$ http :9876/ping
OK
```

```bash
$ http :9876/contracts?customerId=1
```



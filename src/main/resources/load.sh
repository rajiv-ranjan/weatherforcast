#! /bin/bash

for counter in $(seq 1 1 $1)
do
    echo "Query for city Singapore$counter";
    curl http://cache-quickstart-demo.apps.cluster-6c91.6c91.sandbox1073.opentlc.com/weather?city=Sinagpore$counter
    echo
done
#!/bin/bash

rm -rf santa_db/
codeql database create santa_db --language=java
codeql database analyze santa_db ql-queries/FindPresents.ql --format=csv --output=santa.csv
#!/bin/bash

set -e -u -x

export BUILD_FOLDER=$( pwd )

M2_HOME="${HOME}/.m2"
M2_CACHE="${BUILD_FOLDER}/maven"

echo "Generating the /.m2 symbolic link for /maven cache"
[[ -d "${M2_CACHE}" && ! -d "${M2_HOME}" ]] && ln -s "${M2_CACHE}" "${M2_HOME}"

cd source-code/product-service
./mvnw clean deploy
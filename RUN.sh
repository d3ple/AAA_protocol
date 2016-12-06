#!/usr/bin/env bash
# add -x for debug output
# to suppress log add > /dev/null
source ./CONFIG.sh

java -cp "$CP" $MAIN $@ > /dev/null
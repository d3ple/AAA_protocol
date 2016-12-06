#!/usr/bin/env bash
result=0

test () {
    arr=($1)
    ./RUN.sh ${arr[*]}
    status=$?
    if [[ $status -ne $2 ]]; then
        echo TESTING FAIL [$1] $status "!=" $2
        ((result+=1))
    else
        echo TESTING OK [$1] $status "==" $2
    fi
    return $status
}

./BUILD.sh

test "" 0
test "-h" 0

test "-l XXX -p XXX" 1
test "-l jdoe -p XXX" 2
test "-l jdoe -p sup3rpaZZ" 0

test "-l jdoe -p sup3rpaZZ -role READ -res \"a\"" 0
test "-l jdoe -p sup3rpaZZ -role READ -res \"a.b\"" 0
test "-l jdoe -p sup3rpaZZ -role XXX -res \"a.b\"" 3
test "-l jdoe -p sup3rpaZZ -role READ -res XXX" 4
test "-l jdoe -p sup3rpaZZ -role WRITE -res \"a\"" 4
test "-l jdoe -p sup3rpaZZ -role WRITE -res \"a.bc\"" 4

test "-l jdoe -p sup3rpaZZ -role READ -res a -ds \"2015-05-01\" -de \"2015-05-02\" -vol 100" 0
test "-l jdoe -p sup3rpaZZ -role READ -res a -ds XXX -de XXX -vol XXX" 5
test "-l jdoe -p sup3rpaZZ -role READ -res a -ds \"2015-05-01\" -de \"2015-05-02\" -vol XXX" 5
test "-l XXX -p XXX -role READ -res XXX -ds \"2015-05-01\" -de \"2015-05-02\" -vol XXX" 1
test "-l XXX -p XXX -role READ -res XXX" 1

echo
if [[ $result -gt 0 ]]; then
    echo $result tests failed
else
    echo Successfully Completed
fi

exit ${result}
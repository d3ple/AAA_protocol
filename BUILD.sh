source ./CONFIG.sh

rm -rf "$OUT"

mkdir -p $OUT_LIB
cp -r $LIB $OUT_LIB

mkdir -p $OUT_CLS

find . -name "*.java" | xargs javac -classpath "$LIB" -d $OUT_CLS -sourcepath $SRC

jar -cfe $OUT_JAR $MAIN -C $OUT_CLS .

if [ $? == 0 ] ; then
    echo "Successfully compilated."
    exit 0
else
    echo "Unsuccessfully. Something wrong"
    exit 1
fi

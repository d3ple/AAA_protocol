MAIN="com.d3rty.aaaprotocol.Main"
LIB="lib/*"
RES="src/resources/*"
SRC=".src/"
OUT="out"
OUT_JAR="$OUT/AAA_app.jar"
OUT_CLS="$OUT/classes/"
OUT_LIB="$OUT/lib/"

if [[ "$OSTYPE" == "linux" ]]; then
        CP="$LIB:$OUT_JAR:$SRC"
elif [[ "$OSTYPE" == "darwin"* ]]; then
        # Mac OSX
        CP="$LIB:$OUT_JAR:$SRC"
elif [[ "$OSTYPE" == "cygwin" ]]; then
        # POSIX compatibility layer and Linux environment emulation for Windows
        CP="$LIB;$OUT_JAR;$SRC"
elif [[ "$OSTYPE" == "msys" ]]; then
        # Lightweight shell and GNU utilities compiled for Windows (part of MinGW)
        CP="$LIB;$OUT_JAR;$SRC"
elif [[ "$OSTYPE" == "win32" ]]; then
        # I'm not sure this can happen.
        CP="$LIB;$OUT_JAR;$SRC"
elif [[ "$OSTYPE" == "freebsd"* ]]; then
        CP="$LIB:$OUT_JAR:$SRC"
else
        CP="$LIB:$OUT_JAR:$SRC"
fi
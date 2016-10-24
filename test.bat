@echo off
java -cp "out\artifacts\software_engineering_repo_jar\software_engineering_repo.jar" d3rty.AAA_app.Main > NUL
echo !!! %errorlevel%
java -cp "out\artifacts\software_engineering_repo_jar\software_engineering_repo.jar" d3rty.AAA_app.Main -h > NUL
echo !!! %errorlevel%

java -cp "out\artifacts\software_engineering_repo_jar\software_engineering_repo.jar" d3rty.AAA_app.Main -l XXX -p XXX > NUL
echo !!! %errorlevel%
java -cp "out\artifacts\software_engineering_repo_jar\software_engineering_repo.jar" d3rty.AAA_app.Main -l jdoe -p XXX > NUL
echo !!! %errorlevel%
java -cp "out\artifacts\software_engineering_repo_jar\software_engineering_repo.jar" d3rty.AAA_app.Main -l jrow -p Qweqrty12 > NUL
echo !!! %errorlevel%

java -cp "out\artifacts\software_engineering_repo_jar\software_engineering_repo.jar" d3rty.AAA_app.Main -l jdoe -p sup3rpaZZ -role READ -res a > NUL
echo !!! %errorlevel%
java -cp "out\artifacts\software_engineering_repo_jar\software_engineering_repo.jar" d3rty.AAA_app.Main -l jdoe -p sup3rpaZZ -role READ -res a.b > NUL
echo !!! %errorlevel%
java -cp "out\artifacts\software_engineering_repo_jar\software_engineering_repo.jar" d3rty.AAA_app.Main -l jdoe -p sup3rpaZZ -role XXX -res a.b > NUL
echo !!! %errorlevel%
java -cp "out\artifacts\software_engineering_repo_jar\software_engineering_repo.jar" d3rty.AAA_app.Main -l jdoe -p sup3rpaZZ -role READ -res XXX > NUL
echo !!! %errorlevel%
java -cp "out\artifacts\software_engineering_repo_jar\software_engineering_repo.jar" d3rty.AAA_app.Main -l jdoe -p sup3rpaZZ -role WRITE -res a > NUL
echo !!! %errorlevel%
java -cp "out\artifacts\software_engineering_repo_jar\software_engineering_repo.jar" d3rty.AAA_app.Main -l jdoe -p sup3rpaZZ -role WRITE -res a.bc > NUL
echo !!! %errorlevel%

java -cp "out\artifacts\software_engineering_repo_jar\software_engineering_repo.jar" d3rty.AAA_app.Main -l jdoe -p sup3rpaZZ -role READ -res a.b -ds 2015-01-01 -de 2015-12-31 -vol 100 > NUL
echo !!! %errorlevel%
java -cp "out\artifacts\software_engineering_repo_jar\software_engineering_repo.jar" d3rty.AAA_app.Main -l jdoe -p sup3rpaZZ -role READ -res a.b -ds 01-01-2015 -de 2015-12-31 -vol 100 > NUL
echo !!! %errorlevel%
java -cp "out\artifacts\software_engineering_repo_jar\software_engineering_repo.jar" d3rty.AAA_app.Main -l jdoe -p sup3rpaZZ -role READ -res a.b -ds 2015-01-01 -de 2015-12-31 -vol XXX > NUL
echo !!! %errorlevel%
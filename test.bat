@echo off
java -cp "out\artifacts\software_engineering_repo_jar\software_engineering_repo.jar" d3rty.AAA_app.Main > NUL
echo !!! %errorlevel%
java -cp "out\artifacts\software_engineering_repo_jar\software_engineering_repo.jar" d3rty.AAA_app.Main -h > NUL
echo !!! %errorlevel%

java -cp "out\artifacts\software_engineering_repo_jar\software_engineering_repo.jar" d3rty.AAA_app.Main -l QQQQ -p QQQQ > NUL
echo !!! %errorlevel%
java -cp "out\artifacts\software_engineering_repo_jar\software_engineering_repo.jar" d3rty.AAA_app.Main -l jdoe -p QQQQ > NUL
echo !!! %errorlevel%
java -cp "out\artifacts\software_engineering_repo_jar\software_engineering_repo.jar" d3rty.AAA_app.Main -l jdoe -p sup3rpaZZ > NUL
echo !!! %errorlevel%

java -cp "out\artifacts\software_engineering_repo_jar\software_engineering_repo.jar" d3rty.AAA_app.Main -l jdoe -p sup3rpaZZ -ro READ -re a > NUL
echo !!! %errorlevel%
java -cp "out\artifacts\software_engineering_repo_jar\software_engineering_repo.jar" d3rty.AAA_app.Main -l jdoe -p sup3rpaZZ -ro READ -re a.b > NUL
echo !!! %errorlevel%
java -cp "out\artifacts\software_engineering_repo_jar\software_engineering_repo.jar" d3rty.AAA_app.Main -l jdoe -p sup3rpaZZ -ro QQQQ -re a.b > NUL
echo !!! %errorlevel%
java -cp "out\artifacts\software_engineering_repo_jar\software_engineering_repo.jar" d3rty.AAA_app.Main -l jdoe -p sup3rpaZZ -ro READ -re QQQQ > NUL
echo !!! %errorlevel%
java -cp "out\artifacts\software_engineering_repo_jar\software_engineering_repo.jar" d3rty.AAA_app.Main -l jdoe -p sup3rpaZZ -ro WRITE -re a > NUL
echo !!! %errorlevel%
java -cp "out\artifacts\software_engineering_repo_jar\software_engineering_repo.jar" d3rty.AAA_app.Main -l jdoe -p sup3rpaZZ -ro WRITE -re a.bc > NUL
echo !!! %errorlevel%
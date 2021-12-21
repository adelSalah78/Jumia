# Jumia

All you need to run the application is to execute deploy.bat file on the root of the repo

Some pre-requsite before executing deploy.bat

1- Java must be installed and JAVA_HOME environment variable must be set
2- Maven must be installed and maven home environment variable must be set (M2_HOME)
3- docker desktop must be installed
4- Node package manager must be installed.


The deploy.bat tasks:-
1- navigating to the angular source code where package.json resides (angular source code home)
2- Install angular globaly.
3- run npm install in the folder containing package.json file
4- run "ng build --prod" to build the angular app 
5- navigate to the backend source code where pom.xml resides.
6- run mvn clean install
7- navigate to a folder called "Deployment\Jumia\demo" where the docker-compose file resides.
8- in this folder, maven command which has run previuosly in step 4 has formed the heirarchy of this folder to make the docker compose able to build the images from Dockerfile
9- finally, run docker-compose up -d to deploy everything



Access the app via http://localhost:4200

deploy.bat must be run on windows OS only
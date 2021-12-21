cd angular\NumbersCategorization
CALL ng build --prod
cd ..\..\demo
CALL mvn clean install
cd ..\Deployment\Jumia\demo
CALL docker-compose up -d
git pull
mvn clean install
app_id=$(ps -ef | grep 'ipinfo-0.0.1-SNAPSHOT.jar' | grep -v 'grep' | awk '{ printf $2 }')
sudo kill $app_id
echo Killed IP Info and Starting New
echo --------------------------------------------------------------------------------------------------------------
nohup java -jar "target/ipinfo-0.0.1-SNAPSHOT.jar" &
echo ----------------------------------------Started Successfully---------------------------------------------
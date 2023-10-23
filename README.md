# microservice app
run program
1. axon(cmd)(port: 8024): java -jar axonserver.jar
2. run class DiscoverserverApplication 
3. run h2_drive
4. run class BookserviceApplication, port 9001
5. run class EmployeeserviceApplication, port 9002
6. run class ApigatewayApplication, port 9000
7. C:\kafka_2.13-3.6.0\bin\windows => cmd 
     cmd => zookeeper-server-start.bat C:\kafka_2.13-3.6.0\config\zookeeper.properties
     cmd => kafka-server-start.bat C:\kafka_2.13-3.6.0\config\server.properties
     cmd => kafka-topics.bat --create --topic your-name-topic --bootstrap-server localhost:9092
     cmd => kafka-topics.bat --list --bootstrap-server localhost:9092
    khi chạy code thì bật kafka-server-start.bat C:\kafka_2.13-3.6.0\config\server.properties
 

khi mà hàm addBook gửi cái command trong BookCommandController đc gọi thì nó sẽ nhảy qua CommandHandler bên class BookAggregate,
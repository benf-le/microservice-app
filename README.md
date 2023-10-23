# microservice app
run program
1. axon(cmd)(port: 8024): java -jar axonserver.jar
2. run class DiscoverserverApplication 
3. run h2_drive
4. run class BookserviceApplication, port 9001
5. run class EmployeeserviceApplication, port 9002
6. run class ApigatewayApplication, port 9000


khi mà hàm addBook gửi cái command trong BookCommandController đc gọi thì nó sẽ nhảy qua CommandHandler bên class BookAggregate,
# microservice app
run program
1. axon(cmd)(port: 8024): java -jar axonserver.jar
2. run class DiscoverserverApplication 
3. run h2_drive: port 9001
4. . run class BookserviceApplication


khi mà hàm addBook gửi cái command trong BookCommandController đc gọi thì nó sẽ nhảy qua CommandHandler bên class BookAggregate,
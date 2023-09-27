# microservice app
run program
1. axon: java -jar axonserver.jar
2. run class DiscoverserverApplication 
3. run class BookserviceApplication


khi mà hàm addBook gửi cái command trong BookCommandController đc gọi thì nó sẽ nhảy qua CommandHandler bên class BookAggregate,
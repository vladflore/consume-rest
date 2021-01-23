# Consuming a Web Service from a Java Maven Project

This small project exemplifies how to consume a REST Web Service by using Java 11 and the required dependencies  managed by Maven.

This is the old way of doing things, and should not be encouraged anymore. Instead Java-based frameworks - read Spring(Boot) should be used.

If, for some reason, you have to stick with this kind of way, be assured it's still a valid one, maybe a bit more convoluted. 

It exemplifies:

* calling a REST Web Service using [Java 11 HTTP Client](https://openjdk.java.net/groups/net/httpclient/intro.html)
* a way of structuring the application by using composition, delegation, abstraction
* how to test and mock a dependency of which the test depends 
* how to make an executable jar together with a fat jar (contains all it needs to run)

```
mvn clean package
java -jar target/consume-rest-java-1.0-SNAPSHOT-jar-with-dependencies.jar https://jsonplaceholder.typicode.com/users
```
The code is licensed under [LICENSE](../LICENSE)

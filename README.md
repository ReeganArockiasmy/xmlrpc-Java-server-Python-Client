# xmlrpc-Java-server-Python-Client
##Java Server

```sh
	mvn archetype:create -DgroupId=xmlrpc.server -DartifactId=JavaServer
```
And open the *pom.xml* file in

```
	gedit JavaServer/pom.xml
```
Add this dependency in

```xml
<dependencies>
    ....

	<dependency>
            <groupId>xmlrpc-helma</groupId>
            <artifactId>xmlrpc-helma</artifactId>
            <version>1.0</version>
        </dependency>

        <dependency>
            <groupId>xerces</groupId>
            <artifactId>xerces</artifactId>
            <version>1.4.0</version>
        </dependency>
    .....
<dependencies>
```

And open your Java application file add those function

```sh
	gedit JavaServer/src/main/java/xmlrpc/server/App.java
```
```java
package xmlrpc.server;


import helma.xmlrpc.WebServer;
import java.util.Hashtable;

/**
 * Hello world!
 *
 */
public class App 
{
    
     // This public method will be exposed to XML-RPC client
     public Hashtable sumAndDifference(int x, int y) {
        Hashtable result = new Hashtable();
        result.put("sum", new Integer(x + y));
        result.put("difference", new Integer(x - y));
        return result;
    }

    public void print() {
        System.out.println("Print Systems");
    }

    public static void main( String[] args ) {
        try {
            WebServer server = new WebServer(8080);
            // Our handler is a regular java object
            server.addHandler("sample", new App());
        } catch (Exception exception) {
            System.err.println("JavaServer" + exception.toString());
        }
    }
}
```
```sh
	cd JavaServer
	mvn package
	mvn dependency:copy-dependencies -DoutputDirectory=jar-dir
	java -cp jar-dir/xmlrpc-helma-1.0.jar:.:jar-dir/xerces-1.4.0.jar:.:target/JavaServer-1.0-SNAPSHOT.jar xmlrpc.server.App

```






##Python Client

open new terminal
```python
>>> import xmlrpclib
>>> proxy=xmlrpclib.ServerProxy("http://localhost:8080/")
# sample is object is  create in java
>>> proxy.sample.sumAndDifference(100,50)
{'sum': 150, 'difference': 50}

```


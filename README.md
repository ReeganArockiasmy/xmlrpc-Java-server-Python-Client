# xmlrpc-Java-server-Python-Client
```sh
	mvn archetype:create -DgroupId=xmlrpc.server -DartifactId=JavaServer
```
And open the *pom.xml* file in

```
	gedit JavaServer/pom.xml
```
Add this dependency in

```xml
	<dependency>
            <groupId>xmlrpc-helma</groupId>
            <artifactId>xmlrpc-helma</artifactId>
            <version>1.0</version>
        </dependency>

        <dependency>
            <groupId>org.apache.xmlrpc</groupId>
            <artifactId>xmlrpc-client</artifactId>
            <version>3.1.3</version>
        </dependency>

        <dependency>
            <groupId>xerces</groupId>
            <artifactId>xerces</artifactId>
            <version>1.4.0</version>
        </dependency>
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
            server.addHandler("sample", new App());
        } catch (Exception exception) {
            System.err.println("JavaServer" + exception.toString());
        }
    }
}
```
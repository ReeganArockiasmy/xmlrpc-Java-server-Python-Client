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

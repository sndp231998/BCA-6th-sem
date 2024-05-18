import java.io.IOException;
import java.net.*;

public class ProxyExample {
  public static void main(String[] args) throws Exception {
    // Create a Proxy object with the desired proxy settings
    Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.example.com", 8080));
    
    // Set the default proxy for all connections to use the above proxy
    ProxySelector.setDefault(new ProxySelector() {
      @Override
      public java.util.List<Proxy> select(URI uri) {
        return java.util.Collections.singletonList(proxy);
      }
      
      @Override
      public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
        System.out.println("Connection to proxy failed");
      }
    });
    
    // Make a HTTP request using the default proxy
    URL url = new URL("http://www.example.com");
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");
    
    System.out.println("Response code: " + connection.getResponseCode());
  }
}

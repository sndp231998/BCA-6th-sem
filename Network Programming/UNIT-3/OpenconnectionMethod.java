import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

class OpenconnectionMethod {
    public static void main(String[] args) {
        try {
            String location = "http://www.sandipchapagain.com.np";
            URI uri = new URI(location);
            URL url = uri.toURL();
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            br.lines().forEach(System.out::println);
            br.close();
        } catch (IOException | URISyntaxException e) {
            System.out.println(e);
        }
    }
}

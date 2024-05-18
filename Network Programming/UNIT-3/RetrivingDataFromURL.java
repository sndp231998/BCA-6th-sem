import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

class RetrievingDataFromURL {
    public static void main(String[] args) {
        try {
            String location = "https://sandipchapagain.com.np/";
            URL url = new URL(location);
            InputStream is = url.openStream();
            int c;
            while ((c = is.read()) != -1) {
                char data = (char) c;
                System.out.print(data);
            }
            is.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

class BufferedReaderMethod{
    public static void main(String[] args) {
        
      try {
        String location ="https://www.sandipchapagain.com.np";
        URL url=new URL(location);
        InputStream is= url.openStream();
        BufferedReader br=new BufferedReader(new InputStreamReader(is));
        String line;
        while((line=br.readLine())!=null){
            System.out.println(line);
        }

      } catch (IOException e) {
        System.out.println(e);
      }
    }
}

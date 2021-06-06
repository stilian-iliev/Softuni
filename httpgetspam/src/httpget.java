import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class httpget {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://softuni.secariolabs.com/lecture4/homework/page");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        String cookie = "eyJhY2Nlc3MiOjEsInNlY3JldF9rZXl3b3JkIjoiaGF3YWlpIiwidXNlcm5hbWUiOiJhZGFtIn0.YLj5fA.GPusUMx_qmUcgsawWWzftq5K3LA";
        con.setRequestProperty("Cookie", "session=eyJhY2Nlc3MiOjEsInNlY3JldF9rZXl3b3JkIjoiaGF3YWlpIiwidXNlcm5hbWUiOiJhZGFtIn0.YLj5fA.GPusUMx_qmUcgsawWWzftq5K3LA; somecookiename=cHJldmlvdXNfcGFnZV9pZD0x");

        for (int i = 1; i < 1001; i++) {
            // This line makes the request
            InputStream responseStream = con.getInputStream();
            
// Manually converting the response body InputStream to APOD using Jackson
            ObjectMapper mapper = new ObjectMapper();
            APOD apod = mapper.readValue(responseStream, APOD.class);

// Finally we have the response
            System.out.println(apod.title);
        }
    }
}

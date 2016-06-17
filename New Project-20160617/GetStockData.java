import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetStockData{

     public static void main(String []args){
        System.out.println("starting");
        try {
        
            URL url = new URL("http://finance.yahoo.com/d/quotes.csv?s=AAPL+GOOG+MSFT&f=nab");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept" , "application/json");
            if (conn.getResponseCode() != 200) {
    			throw new RuntimeException("Failed : HTTP error code : "
    					+ conn.getResponseCode());
    		}
    
    		BufferedReader br = new BufferedReader(new InputStreamReader(
    			(conn.getInputStream())));
    
    		String output;
    		System.out.println("Output from Server .... \n");
    		while ((output = br.readLine()) != null) {
    			System.out.println(output);
    		}
    
    		conn.disconnect();
        } 
        catch (MalformedURLException e) {

		    e.printStackTrace();

	    } 
	    catch (IOException e) {

		e.printStackTrace();

	    }
        
     }
}

package multithreadclient;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;

/**
 *
 * @author Architect
 */
public class MultithreadClient {

    public static void main(String[] args) {
        
        String hostName = "localhost";
        Integer portNumber = 4444;
        ArrayList<HashMap> pokemonList = new ArrayList<>();
        JSONInputStream inFromServer;
        
        try (Socket toServer = new Socket(hostName, portNumber);){
            
            inFromServer = new JSONInputStream(toServer.getInputStream());
            pokemonList = (ArrayList)inFromServer.readObject();
            
        }
        
        catch (IOException | JSONException e) {
            
            e.printStackTrace();
            
        }
        
        System.out.println(pokemonList);
        
    }
    
}

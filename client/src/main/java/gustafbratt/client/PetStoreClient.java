package gustafbratt.client;

import com.google.gson.Gson;
import gustafbratt.generated.ApiClient;
import gustafbratt.client.ClientConfig;

import java.io.*;

public class PetStoreClient extends ApiClient {

    public static final String CLIENTCONFIG_JSON = "clientconfig.json";

    public PetStoreClient()  {
        super();
        ClientConfig clientConfig;
        try {
            clientConfig = getClientConfig();
        }catch (IOException e) {
            System.err.println("Could not find file " + CLIENTCONFIG_JSON);
            e.printStackTrace();
            return;
        }
        if (clientConfig == null) return;
        setBasePath(clientConfig.basePath);
        setDebugging(clientConfig.debugging);
    }

    private ClientConfig getClientConfig() throws IOException {
        File file = new File(
                getClass().getClassLoader().getResource(CLIENTCONFIG_JSON).getFile()
        );
        Gson gson = new Gson();
        Reader reader = new FileReader(file);
        ClientConfig clientConfig = gson.fromJson(reader, ClientConfig.class);
        return clientConfig;
    }
}
package gustafbratt.client;

import com.google.gson.Gson;
import gustafbratt.ApiClient;
import gustafbratt.model.Pet;
import ca.mimic.oauth2library;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

class PetStoreClient extends ApiClient {
    public PetStoreClient()  {
        super();
        File file = new File(
                getClass().getClassLoader().getResource("clientconfig.json").getFile()
        );
        Gson gson = new Gson();
        Reader r = null;
        try {
            r = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        ClientConfig clientConfig = gson.fromJson(r, ClientConfig.class);
        setBasePath(clientConfig.basePath);
        setDebugging(true);
        doOauth2Stuff();
    }

    private void doOauth2Stuff() {
        OAuth2Client client = new OAuth2Client.Builder("username", "password", "client-id", "client-secret", "site").build();
        OAuthResponse response = client.requestAccessToken();

        if (response.isSuccessful()) {
            String accessToken = response.getAccessToken();
            String refreshToken = response.getRefreshToken();
        } else {
            OAuthError error = response.getOAuthError();
            String errorMsg = error.getError();
        }

        response.getCode();
    }
}
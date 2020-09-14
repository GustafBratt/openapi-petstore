package gustafbratt.systemtests.pet;

import gustafbratt.generated.ApiClient;
import gustafbratt.generated.api.PetApi;

public class TestBase {

        static ApiClient apiClient = new ApiClient()
                .setBasePath("http://localhost:8080/v3")
                .setDebugging(true);
        public static PetApi petApi = new PetApi(apiClient);

}

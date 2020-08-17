package gustafbratt.systemtests.pet;

import com.squareup.okhttp.*;
import gustafbratt.ApiClient;
import gustafbratt.ApiException;
import gustafbratt.api.PetApi;
import gustafbratt.api.StoreApi;
import gustafbratt.api.UserApi;
import gustafbratt.model.Category;
import gustafbratt.model.Pet;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

class PetTest {
    @Test
    public void testAddPet() throws ApiException {
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath("http://localhost:8080/v3");
        apiClient.setDebugging(true);
        PetApi petApi = new PetApi(apiClient);

        petApi.addPet(new Pet().name("random string").category(new Category().name("rabbits")).status(Pet.StatusEnum.AVAILABLE));
        List<Pet> findRsp = petApi.findPetsByStatus(Arrays.asList("available"));
        System.out.println(findRsp);
    }
}
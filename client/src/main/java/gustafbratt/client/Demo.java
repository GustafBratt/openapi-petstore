package gustafbratt.client;

import gustafbratt.ApiClient;
import gustafbratt.ApiException;
import gustafbratt.api.PetApi;
import gustafbratt.model.Pet;

import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) throws ApiException {
        PetApi petApi = new PetApi(new PetStoreClient());
        List<Pet> findRsp = petApi.findPetsByStatus(Arrays.asList("available"));
        System.out.println(findRsp);
    }
}

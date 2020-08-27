package gustafbratt.tools;

import gustafbratt.generated.ApiException;
import gustafbratt.generated.api.PetApi;
import gustafbratt.client.PetStoreClient;
import gustafbratt.generated.model.Pet;

import java.util.Arrays;
import java.util.List;

public class ListPets {
    public static void main(String[] args) throws ApiException {
        PetApi petApi = new PetApi(new PetStoreClient());
        List<Pet> findRsp = petApi.findPetsByStatus(Arrays.asList("available"));
        for(Pet pet :findRsp){
            System.out.println(pet.getId() + ", " + pet.getName() + " " + pet.getCategory().getName());
        }
    }
}

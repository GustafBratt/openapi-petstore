package gustafbratt.systemtests.pet;

import gustafbratt.ApiException;
import gustafbratt.model.Pet;
import gustafbratt.systemtests.TestUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class PetTest extends TestBase {
    @Test
    public void testAddPet() throws ApiException {
        Pet petReq = new Pet();
        petReq.setName(TestUtils.randomString());
        petReq.category(TestUtils.CATEGORY_LIONS);
        petReq.status(Pet.StatusEnum.AVAILABLE);
        petApi.addPet(petReq);
        List<Pet> findRsp = petApi.findPetsByStatus(Arrays.asList("available"));
        boolean found = false;
        for(Pet pet : findRsp){
            if(TestUtils.CATEGORY_LIONS.equals(pet.getCategory()) && petReq.getName().equals(pet.getName())){
                found = true;
            }
        }
        if(!found){
            Assert.fail("Pet not found in findPetsByStatus");
        }
    }
}
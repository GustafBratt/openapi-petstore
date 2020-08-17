package gustafbratt.systemtests;
import gustafbratt.model.Category;

import java.util.UUID;

public class TestUtils {
    static String randomString(){
        return UUID.randomUUID().toString().replace("-","");
    }

    static Category CATEGORY_DOGS = new Category().id(1L).name("Dogs");
    static Category CATEGORY_CATS = new Category().id(2L).name("Cats");
    static Category CATEGORY_RABBITS = new Category().id(3L).name("Rabbits");
    static Category CATEGORY_LIONS = new Category().id(4L).name("Lions");

}

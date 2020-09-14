package gustafbratt.systemtests;
import gustafbratt.generated.model.Category;

import java.util.UUID;

public class TestUtils {
    public static String randomString(){
        return UUID.randomUUID().toString().replace("-","");
    }

    public static Category CATEGORY_DOGS = new Category().id(1L).name("Dogs");
    public static Category CATEGORY_CATS = new Category().id(2L).name("Cats");
    public static Category CATEGORY_RABBITS = new Category().id(3L).name("Rabbits");
    public static Category CATEGORY_LIONS = new Category().id(4L).name("Lions");

}

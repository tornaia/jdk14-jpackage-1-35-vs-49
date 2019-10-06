import java.lang.reflect.Field;
import java.util.Optional;

public class Main {

    private Optional<Service> service;

    public static void main(String[] args) throws Exception {
        System.out.println(Runtime.version());
        Class<?> class0 = Main.class.getClassLoader().loadClass("Main");
        Field field0 = class0.getDeclaredField("service");
        field0.getGenericType();
    }

}

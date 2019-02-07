package L16SmartArray;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        initTests();
    }

    @SuppressWarnings("SameParameterValue")
    private static void initTests() throws InvocationTargetException, IllegalAccessException {
        SmartArrayUnitTests smartArrayUnitTests = new SmartArrayUnitTests();
        Method[] methods = SmartArrayUnitTests.class.getDeclaredMethods();
        for (final Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                method.setAccessible(true);
                method.invoke(smartArrayUnitTests);
            }
        }
    }
}

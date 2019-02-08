package L17Generics.Ex01JarOfT;

public class Main {
    public static void main(String[] args) {
        Jar<String> jarOfStrings = new Jar<>();

        jarOfStrings.add("one");
        jarOfStrings.add("two");
        jarOfStrings.add("three");

        System.out.println(jarOfStrings.remove());
    }
}

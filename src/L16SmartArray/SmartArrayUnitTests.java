package L16SmartArray;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SmartArrayUnitTests {

    private static void assertion(boolean isCorrect, String test) {
        if (isCorrect) {
            System.out.println(String.format("- %s PASSED!", test));
        } else {
            System.out.println(String.format("- %s FAILED!!!", test));
        }
        System.out.println();
    }

    @Test
    private void addSingleElementShouldIncreaseCount() {
        SmartArray<Integer> list = new SmartArrayImpl<>();

        list.add(1);
        boolean isSizeCorrect = list.size() == 1;
        assertion(isSizeCorrect, "addSingleElementShouldIncreaseCount");
    }

    @Test
    private void addMultipleElementShouldIncreaseCount() {
        SmartArray<Integer> list = new SmartArrayImpl<>();

        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        boolean isSizeCorrect = list.size() == 100;
        assertion(isSizeCorrect, "addMultipleElementShouldIncreaseCount");
    }

    @Test
    private void addAndContainsSingleElement() {
        SmartArray<Integer> list = new SmartArrayImpl<>();

        list.add(5);
        boolean isNotPresent = ! list.contains(0);
        assertion(isNotPresent, "addAndContainsSingleElement");
    }

    @Test
    private void addAndGetSingleElement() {
        SmartArray<Integer> list = new SmartArrayImpl<>();

        list.add(5);
        int element = list.get(0);
        boolean isElement = element == 5;
        assertion(isElement, "addAndGetSingleElement");
    }


    @Test
    private void addAndGetMultipleElements() {
        SmartArray<Integer> list = new SmartArrayImpl<>();

        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        boolean isCorrect = false;
        for (int i = 0; i < 100; i++) {
            int element = list.get(i);
            if (i == element) {
                isCorrect = true;
            } else {
                isCorrect = false;
                break;
            }
        }

        assertion(isCorrect, "addAndGetMultipleElements");
    }

    @Test
    private void removeSingleElementShouldHaveCorrectCount() {
        SmartArray<Integer> list = new SmartArrayImpl<>();

        list.add(0);
        list.removeAt(0);
        boolean isEmpty = list.size() == 0;
        assertion(isEmpty, "removeSingleElementShouldHaveCorrectCount");
    }

    @Test
    public void removeSingleElementShouldHaveCorrectElements() {
        SmartArray<Integer> list = new SmartArrayImpl<>();

        list.add(0);
        list.add(1);
        list.add(2);
        list.removeAt(0);

        int firstElement = list.get(0);
        int secondElement = list.get(1);

        boolean isFirstElement = firstElement == 1;
        boolean isSecondElement = secondElement == 2;
        assertion(isFirstElement && isSecondElement, "removeSingleElementShouldHaveCorrectElements");
    }

    @Test
    public void removeMultipleElements() {
        SmartArray<Integer> list = new SmartArrayImpl<>();

        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

        for (int i = 0; i < 50; i++) {
            list.removeAt(0);
        }

        boolean isCorrectCount = list.size() == 50;


        for (int i = 0; i < 50; i++) {
            int element = list.get(i);
            boolean isCorrectElement = element == i + 50;
            if (! isCorrectElement) {
                assertion(false, "removeMultipleElements");
                return;
            }
        }

        assertion(isCorrectCount, "removeMultipleElements");
    }

    @Test
    public void getInvalidPositionShouldThrow() {
        SmartArray<Integer> list = new SmartArrayImpl<>();

        try {
            list.get(5);
            assertion(false, "getInvalidPositionShouldThrow");
        } catch (IndexOutOfBoundsException iobe) {
            assertion(true, "getInvalidPositionShouldThrow");
        }
    }

    @Test
    public void removeAtInvalidPositionShouldThrow() {
        SmartArray<Integer> list = new SmartArrayImpl<>();

        try {
            list.removeAt(3);
            assertion(false, "removeAtInvalidPositionShouldThrow");
        } catch (IndexOutOfBoundsException iobe) {
            assertion(true, "removeAtInvalidPositionShouldThrow");
        }
    }

    @Test
    public void removeSingleElementShouldHaveCorrectElementsWhenPrinted() {
        SmartArray<Integer> list = new SmartArrayImpl<>();

        IntStream.rangeClosed(1, 5).forEach(list::add);
        list.removeAt(4);
        String afterDeletion = Arrays.toString(list.toArray());

        assertion("[1, 2, 3, 4]".endsWith(afterDeletion), "removeSingleElementShouldHaveCorrectElementsWhenPrinted");
    }

    @Test
    public void insertAtSingleElementShouldWorkCorrect() {
        SmartArray<Integer> list = new SmartArrayImpl<>();

        IntStream.rangeClosed(1, 5).forEach(list::add);
        list.insertAt(2, 12);

        String afterDeletion = Arrays.toString(list.toArray());

        assertion("[1, 2, 12, 3, 4, 5]".endsWith(afterDeletion), "insertAtSingleElementShouldWorkCorrect");
    }
}

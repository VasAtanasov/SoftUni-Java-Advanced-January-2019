package L18GenericsExercises.Ex10Tuple;

public class Tuple<ITEM_ONE, ITEM_TWO> {
    private ITEM_ONE itemOne;
    private ITEM_TWO itemTwo;

    public Tuple(ITEM_ONE itemOne, ITEM_TWO itemTwo) {
        this.itemOne = itemOne;
        this.itemTwo = itemTwo;
    }

    public ITEM_ONE getItemOne() {
        return this.itemOne;
    }

    public void setItemOne(ITEM_ONE itemOne) {
        this.itemOne = itemOne;
    }

    public ITEM_TWO getItemTwo() {
        return this.itemTwo;
    }

    public void setItemTwo(ITEM_TWO itemTwo) {
        this.itemTwo = itemTwo;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", itemOne, itemTwo);
    }
}

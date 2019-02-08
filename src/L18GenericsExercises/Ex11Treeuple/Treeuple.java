package L18GenericsExercises.Ex11Treeuple;

public class Treeuple<ITEM_ONE, ITEM_TWO, ITEM_THREE> {
    private ITEM_ONE itemOne;
    private ITEM_TWO itemTwo;
    private ITEM_THREE itemThree;

    public Treeuple(ITEM_ONE itemOne, ITEM_TWO itemTwo, ITEM_THREE itemThree) {
        this.itemOne = itemOne;
        this.itemTwo = itemTwo;
        this.itemThree = itemThree;
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

    public ITEM_THREE getItemThree() {
        return this.itemThree;
    }

    public void setItemThree(ITEM_THREE itemThree) {
        this.itemThree = itemThree;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s", itemOne, itemTwo, itemThree);
    }
}

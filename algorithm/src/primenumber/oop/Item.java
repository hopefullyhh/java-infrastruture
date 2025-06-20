package primenumber.oop;

public abstract class Item {
    Item item;

    Item() {

    }

    Item(Item item) {
        this.item = item;
    }

    public abstract int out();
}

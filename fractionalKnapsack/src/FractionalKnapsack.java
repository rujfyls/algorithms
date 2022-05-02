import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String[] args) {
        Item i1 = new Item(4, 20);
        Item i2 = new Item(3, 18);
        Item i3 = new Item(2, 14);
        Item[] items = {i1, i2, i3};

        int W = 7;

        Arrays.sort(items,
                Comparator.comparingDouble(Item::valuePerUnionOfWeight)
                        .reversed());
        int weightSoFar = 0;
        double valueSoFar = 0;
        int currentItem = 0;

        while (currentItem < items.length && weightSoFar != W) {
            if (weightSoFar + items[currentItem].getWeight() < W) {
                //берем объекты целиком
                valueSoFar += items[currentItem].getValue();
                weightSoFar += items[currentItem].getWeight();
            } else {
                // берем только часть объекта
                valueSoFar += ((W - weightSoFar) / (double) items[currentItem].getWeight()) *
                        items[currentItem].getValue();
                weightSoFar = W; //полный рюкзак
            }
            currentItem++;
        }
        System.out.println("Ценность наилучшего набора: " + valueSoFar);
    }
}

class Item {
    private final int weight;
    private final int value;

    Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public double valuePerUnionOfWeight() {
        return (double) value / weight;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }
}

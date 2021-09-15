package ru.geekbrains.javacore.lesson3;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    private List<T> data = new ArrayList<>();

    public void put(T fruit){
        this.data.add(fruit);
    }

    public float getWeight(){
        float totalWeight = 0f;
        for (T t: this.data){
            totalWeight+=t.getWeight();
        }
        return totalWeight;
    }

    public boolean compare(Box outBox) {
        return outBox.getWeight() == this.getWeight();
    }

    public void moveFruits(Box<T> otherBox){
        for (T t: this.data){
            otherBox.put(t);
        }
        this.data.clear();
    }

    @Override
    public String toString() {
        return "Box{" +
                "data=" + data +
                '}';
    }
}

package ru.geekbrains.javacore.lesson3;

public abstract class Fruit {

    private float weight;

    protected Fruit(float weight){
        this.weight = weight;
    }

    public float getWeight(){
        return  this.weight;
    }
}

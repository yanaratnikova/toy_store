package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

public class ToyProject {
    private String id;
    private String name;
    private int frequency;

    public ToyProject(String id, String name, int frequency) {
        this.id = id;
        this.name = name;
        this.frequency = frequency;
    }
    public static void main(String[] args) {

        ToyProject toy1 = new ToyProject("001", "Машинка", 5);
        ToyProject toy2 = new ToyProject("002", "Кукла", 6);
        ToyProject toy3 = new ToyProject("003", "Конструктор", 7);
        PriorityQueue<ToyProject> toyQueue = new PriorityQueue<>((a, b) -> b.frequency - a.frequency);
        toyQueue.add(toy1);
        toyQueue.add(toy2);
        toyQueue.add(toy3);
        try {
            FileWriter writer = new FileWriter("result.txt");
            for(int i = 0; i < 10; i++){
                ToyProject toy = toyQueue.peek();
                if(toy != null){
                    writer.write(toy.id + " "+ toy.name + "\n");
                    toy.frequency--;
                    if(toy.frequency == 0){
                        toyQueue.remove(toy);
                    }
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Heap {

    ArrayList<Integer> arr = new ArrayList<>();

    public static void main(String[] args){

        Heap h = new Heap();
        h.insertMinHeapElement(3);
        h.insertMinHeapElement(2);
        h.insertMinHeapElement(7);
        h.insertMinHeapElement(15);
        h.insertMinHeapElement(5);
        h.insertMinHeapElement(4);
        h.insertMinHeapElement(45);
        System.out.println(h.arr.toString());
        h.arr.set(0,45);
        h.arr.remove(h.arr.size() -1);
        h.heapify(0);
        System.out.println(h.arr.toString());
        System.out.println(h.arr.stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        }).collect(Collectors.toList()).toString());


    }

    private void heapify(int i) {

        int smallest = i;
        int l = left(smallest);
        int r = right(smallest);
        if(l < arr.size() && arr.get(l) < arr.get(smallest)){
            smallest = l;
        }
        if(r < arr.size() && arr.get(r) < arr.get(smallest)){
            smallest = r;
        }
        if(smallest != i){

            int temp = arr.get(smallest);
            arr.set(smallest,arr.get(i));
            arr.set(i,temp);
            heapify(smallest);

        }
    }

    public int parent(int i){
        return (i-1)/2;
    }
    public int right(int i){
        return (2*i + 2);
    }
    public int left(int i){
        return (2*i + 1);
    }

    private void insertMinHeapElement(int i) {

        int size = arr.size();
        if(size == 0){
            arr.add(i);

        }else{
            arr.add(i);
            while(size != 0 && (arr.get(size) < arr.get(parent(size)))){

                int temp = arr.get(size);
                arr.set(size,arr.get(parent(size)));
                arr.set(parent(size),temp);
                size = parent(size);

            }
        }

    }

}

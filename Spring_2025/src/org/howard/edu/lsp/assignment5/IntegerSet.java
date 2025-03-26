package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.List;

public class IntegerSet  {
    // Store the set elements in an ArrayList.
    private List<Integer> set = new ArrayList<Integer>();

    // Default Constructor
    public IntegerSet() {

    }

    // Constructor if you want to pass in already initialized
    public IntegerSet(ArrayList<Integer> set) {
        this.set = set;
    }

    // Clears the internal representation of the set. 5 pts.
    public void clear() {
        this.set.clear();
    };

    // Returns the length of the set. 5 pts.
    public int length() {
        return this.set.size();
    }; // returns the length

    /*
     * Returns true if the 2 sets are equal, false otherwise;
     * Two sets are equal if they contain all of the same values in ANY order.  This overrides
     * the equal method from the Object class. 10 pts.
     */
    public boolean equals(Object o) {
        if (o==null){
            return false;
        }
        if (!(o instanceof IntegerSet)){
            return false;
        }
            IntegerSet integerSetB = (IntegerSet) o;
        if (this.length() != integerSetB.length()) {
            return false;
        }
        for (int i = 0; i < this.length(); i++){
            if (!integerSetB.contains(this.set.get(i))){
                return false;
            }
        }
        return true;

    };

    // Returns true if the set contains the value, otherwise false. 5 pts.
    public boolean contains(int value) {
        return this.set.contains(value);
    };
    // Returns  the largest item in the set. 5 pts.
    public int largest()  {
        if (this.set.isEmpty()){
            return -1;
        }
        int largest = this.set.get(0);
        for (int i = 1; i < this.set.size(); i++){
            if (this.set.get(i) > largest){
                largest = this.set.get(i);
            }
        }
        return largest;
    };

    // Returns the smallest item in the set. 5 pts.
    public int smallest()  {
        if (this.set.isEmpty()){
            return -1;
        }
        int smallest = this.set.get(0);
        for (int i = 1; i < this.set.size(); i++){
            if (this.set.get(i) < smallest){
                smallest = this.set.get(i);
            }
        }
        return smallest;

    };

    // Adds an item to the set or does nothing it already there. 5 pts.
    public void add(int item) {
        if (this.set.contains(item)){
            return;
        }
        this.set.add(item);
    }; // adds item to the set or does nothing if it is in set

    // Removes an item from the set or does nothing if not there. 5 pts.
    public void remove(int item) {
        Integer i = item;
        this.set.remove(i);
    };

    // Set union. 11 pts.
    public void union(IntegerSet intSetb) {
         if (intSetb==null){    // if intSetb is null, return
             return;
         }

            for (int i = 0; i < intSetb.length(); i++){
                int item = intSetb.set.get(i);
                if (!this.set.contains(item)){
                    this.set.add(item);
                }
            }
    };

    // Set intersection, all elements in s1 and s2. 12 pts.
    public void intersect(IntegerSet intSetb) {
        if (intSetb == null) {
            return;
        }

        // Create a new list to avoid ConcurrentModificationException
        List<Integer> toRemove = new ArrayList<>();
        for (int item : this.set) {
            if (!intSetb.contains(item)) {
                toRemove.add(item);
            }
        }

        // Remove items not in the other set
        this.set.removeAll(toRemove);
    }

    // Set difference, i.e., s1 –s2. 12 pts.
    public void diff(IntegerSet intSetb) {
        if (intSetb == null) {
            return;
        }

        // Create a new list to remove elements that are in intSetb
        List<Integer> toRemove = new ArrayList<>();
        for (int item : this.set) {
            if (intSetb.contains(item)) {
                toRemove.add(item);
            }
        }

        // Remove common elements
        this.set.removeAll(toRemove);
    }
// set difference, i.e. s1 - s2

    // Set complement, all elements not in s1. 11 pts.
    public void complement(IntegerSet intSetb) {
        if(intSetb==null){
            return;
        }

        for (int i = 0; i < intSetb.length(); i++){
            int item = intSetb.set.get(i);
            if (this.set.contains(item)){
                this.remove(i);
            }
        }
    }

    // Returns true if the set is empty, false otherwise. 5 pts.
    public boolean isEmpty(){
        return this.set.isEmpty();
    }

    // Return String representation of your set.  This overrides the equal method from
// the Object class. 5 pts.
    public String toString() {
        return this.set.toString();
    };	// return String representation of your set
}

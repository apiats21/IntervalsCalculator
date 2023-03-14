package com.piatsevich;
git
public class Main {
    public static void main(String[] args) {

        String[] input = new String[]{"M2", "C"};
        String[] input1 = new String[]{"P5", "B"};
        String[] input2 = new String[]{"m2", "Fb"};
        String[] input3 = new String[]{"m2", "D#"};
        String[] input4 = new String[]{"M7", "G"};
        System.out.println(Intervals.intervalConstruction(input));
        Intervals.intervalConstruction(input1);
        Intervals.intervalConstruction(input2);
        Intervals.intervalConstruction(input3);
        Intervals.intervalConstruction(input4);
// D F# Gbb E F#

    }
}

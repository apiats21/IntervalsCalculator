package com.piatsevich;

public class Main {
    public static void main(String[] args) {

        String[] input = new String[]{"M2", "C"};
        String[] input1 = new String[]{"P5", "B"};
        String[] input2 = new String[]{"m2", "Fb"};
        String[] input3 = new String[]{"m2", "D#"};
        String[] input4 = new String[]{"M7", "G"};
        System.out.println(Intervals.intervalConstruction(input));
        System.out.println(Intervals.intervalConstruction(input1));
        System.out.println(Intervals.intervalConstruction(input2));
        System.out.println(Intervals.intervalConstruction(input3));
        System.out.println(Intervals.intervalConstruction(input4));
// D F# Gbb E F#
        String[] input5 = new String[]{"m2", "Bb", "dsc"};
        String[] input6 = new String[]{"M3", "Cb", "dsc"};
        String[] input7 = new String[]{"P4", "G#", "dsc"};
        String[] input8 = new String[]{"m3", "B", "dsc"};
        String[] input9 = new String[]{"M2", "E#", "dsc"};
        String[] input10 = new String[]{"P4", "E", "dsc"};
        System.out.println(Intervals.intervalConstruction(input5));
        System.out.println(Intervals.intervalConstruction(input6));
        System.out.println(Intervals.intervalConstruction(input7));
        System.out.println(Intervals.intervalConstruction(input8));
        System.out.println(Intervals.intervalConstruction(input9));
        System.out.println(Intervals.intervalConstruction(input10));

    }
}

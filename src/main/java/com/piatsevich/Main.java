package com.piatsevich;

public class Main {
    public static void main(String[] args) {

        String[] input = new String[]{"C", "D"};
        String[] input1 = new String[]{"B", "F#", "asc"};
        String[] input2 = new String[]{"Fb", "Gbb"};
        String[] input3 = new String[]{"G", "F#", "asc"};
        String[] input4 = new String[]{"Bb", "A", "dsc"};
        String[] input5 = new String[]{"Cb", "Abb", "dsc"};
        String[] input6 = new String[]{"G#", "D#", "dsc"};
        String[] input7 = new String[]{"E", "B", "dsc"};
        String[] input8 = new String[]{"E#", "D#", "dsc"};
        String[] input9 = new String[]{"B", "G#", "dsc"};

        System.out.println(Intervals.intervalIdentification(input));
        System.out.println(Intervals.intervalIdentification(input1));
        System.out.println(Intervals.intervalIdentification(input2));
        System.out.println(Intervals.intervalIdentification(input3));
        System.out.println(Intervals.intervalIdentification(input4));
        System.out.println(Intervals.intervalIdentification(input5));
        System.out.println(Intervals.intervalIdentification(input6));
        System.out.println(Intervals.intervalIdentification(input7));
        System.out.println(Intervals.intervalIdentification(input8));
        System.out.println(Intervals.intervalIdentification(input9));






        //|['C', 'D']|M2|
        //|['B', 'F#', 'asc']|P5|
        //|['Fb', 'Gbb']|m2|
        //|['G', 'F#', 'asc']|M7|
        //|['Bb', 'A', 'dsc']|m2|
        //|['Cb', 'Abb', 'dsc']|M3|
        //|['G#', 'D#', 'dsc']|P4|
        //|['E', 'B', 'dsc']|P4|
        //|['E#', 'D#', 'dsc']|M2|
        //|['B', 'G#', 'dsc']|m3|




//        String[] input = new String[]{"M2", "C"};
//        String[] input1 = new String[]{"P5", "B"};
//        String[] input2 = new String[]{"m2", "Fb"};
//        String[] input3 = new String[]{"m2", "D#"};
//        String[] input4 = new String[]{"M7", "G"};
//        System.out.println(Intervals.intervalConstruction(input));
//        System.out.println(Intervals.intervalConstruction(input1));
//        System.out.println(Intervals.intervalConstruction(input2));
//        System.out.println(Intervals.intervalConstruction(input3));
//        System.out.println(Intervals.intervalConstruction(input4));
//        String[] input5 = new String[]{"m2", "Bb", "dsc"};
//        String[] input6 = new String[]{"M3", "Cb", "dsc"};
//        String[] input7 = new String[]{"P4", "G#", "dsc"};
//        String[] input8 = new String[]{"m3", "B", "dsc"};
//        String[] input9 = new String[]{"M2", "E#", "dsc"};
//        String[] input10 = new String[]{"P4", "E", "dsc"};
//        System.out.println(Intervals.intervalConstruction(input5));
//        System.out.println(Intervals.intervalConstruction(input6));
//        System.out.println(Intervals.intervalConstruction(input7));
//        System.out.println(Intervals.intervalConstruction(input8));
//        System.out.println(Intervals.intervalConstruction(input9));
//        System.out.println(Intervals.intervalConstruction(input10));

    }
}

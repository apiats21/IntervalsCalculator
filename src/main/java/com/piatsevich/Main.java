package com.piatsevich;


import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        String[] input = new String[]{"M7", "G"};
        Intervals.intervalConstruction(input);


        // looking for right degree index for accenting/descending orders
        int degreeStepsCount = Integer.parseInt(input[0].substring(1));
        int rightDegreeIndex = 0;
        int rightDegreeIndexDsc = 0;
        String[] degrees = new String[]{"C", "D", "E", "F", "G", "A", "B"};

        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i].equals("E")) {
                rightDegreeIndex = (i + degreeStepsCount) % degrees.length - 1;
                rightDegreeIndexDsc = ((i - degreeStepsCount + 1) + degrees.length) % degrees.length;
                break;
            }
        }
        int semitonesCount = 0;


        String[] intervals = new String[]
                {"", "m2", "M2", "m3", "M3", "P4", "", "P5", "m6", "M6", "m7", "M7", "P8"};

        int semCount = IntStream
                .range(0, intervals.length)
                .filter(i -> intervals[i].equals("m2"))
                .findFirst().orElse(-1);

        System.out.println(semCount);


        // semitones count in intervals
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i].equals(input[0])) {
                semitonesCount = i;
            }
        }

    }
}

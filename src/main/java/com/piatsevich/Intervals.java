package com.piatsevich;

import java.util.stream.IntStream;

public class Intervals {
    // interval's index corresponds to number of semitones in interval
    private  static final String[] intervals = new String[]
            {"", "m2", "M2", "m3", "M3", "P4", "", "P5", "m6", "M6", "m7", "M7", "P8"};

    // all possible notes combinations
    private  static final String[] notes = new String[]{"C/Dbb/B#", "C#/Db/B##", "D/C##/Ebb", "D#/Eb/Fbb",
            "E/D##/Fb", "F/E#/Gbb", "F#/Gb/E##", "G/F##/Abb", "G#/Ab", "A/G##/Bbb", "A#/Bb/Cbb", "B/Cb/A##"};

    private  static final String[] degrees = new String[]{"C", "D", "E", "F", "G", "A", "B"};


    public static String intervalConstruction(String[] args) {

        //  - If there are more or fewer elements in the input array, an exception should be thrown: "Illegal number of elements in input array"

        int semitonesCount = 0;
        int degreeStepsCount = Integer.parseInt(args[0].substring(1));

        int endDegreeIndex = 0;
        int endDegreeIndexDsc = 0;

        boolean descending = args.length == 3 && args[2].equals("dsc");

        // Looking for degree end index.
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i].equals(args[1].substring(0, 1))) {
                endDegreeIndex = (i + degreeStepsCount) % degrees.length - 1;
                endDegreeIndexDsc = ((i - degreeStepsCount + 1) + degrees.length) % degrees.length;
                break;
            }
        }

        // semitones count in intervals(return index of interval=SemitonesCount)
        semitonesCount = IntStream
                .range(0, intervals.length)
                .filter(i -> intervals[i].equals(args[0]))
                .findFirst().orElse(-1);


        int intervalStartIndex = 0;

        // left note index lookup
        for (int i = 0; i < notes.length; i++) {
            String[] splittedNote = notes[i].split("/");
            for (String note : splittedNote) {
                if (note.equalsIgnoreCase(args[1])) {
                    intervalStartIndex = i;
                    break;
                }
            }
        }

        // right interval index lookup in notes
        int rightNoteIndex = (intervalStartIndex + semitonesCount) % notes.length;
        int rightNoteIndexDsc = ((intervalStartIndex - semitonesCount) + notes.length) % notes.length;

        if (descending) {
            rightNoteIndex = rightNoteIndexDsc;
            endDegreeIndex = endDegreeIndexDsc;
        }

        //Splitting notes
        String[] rightNote = notes[rightNoteIndex].split("/");
        String result = null;
        for (String splitNote : rightNote) {
            if (splitNote.substring(0, 1).equals(degrees[endDegreeIndex])) {
                result = splitNote;
            }
        }

        return result;
    }

    public static String intervalIdentification(String[] args) {
        // - If the interval does not fit a description, an exception should be thrown: "Cannot identify the interval".

        boolean descending = args.length == 3 && args[2].equals("dsc");

        int intervalLeftIndex = 0;
        int intervalRightIndex = 0;

        // left & right note index lookup
        for (int i = 0; i < notes.length; i++) {
            String[] splittedNote = notes[i].split("/");
            for (String note : splittedNote) {
                if (note.equals(args[0])) {
                    intervalLeftIndex = i;
                }
                if (note.equals(args[1])) {
                    intervalRightIndex = i;
                }
            }
        }

        int semitonesCount = ((intervalRightIndex - intervalLeftIndex) + notes.length) % notes.length;
        int semitonesCountDes = ((intervalLeftIndex - intervalRightIndex) + notes.length) % notes.length;

        if (descending) {
            return intervals[semitonesCountDes];
        }

        return intervals[semitonesCount];
    }
}

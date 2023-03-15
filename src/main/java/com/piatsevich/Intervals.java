package com.piatsevich;

import java.util.stream.IntStream;

public class Intervals {
    // interval's index corresponds to number of semitones in interval
    private static final String[] intervalList = new String[]
            {"", "m2", "M2", "m3", "M3", "P4", "", "P5", "m6", "M6", "m7", "M7", "P8"};

    // all possible notes combinations
    private static final String[] completeNoteList = new String[]{"C/Dbb/B#", "C#/Db/B##", "D/C##/Ebb", "D#/Eb/Fbb",
            "E/D##/Fb", "F/E#/Gbb", "F#/Gb/E##", "G/F##/Abb", "G#/Ab", "A/G##/Bbb", "A#/Bb/Cbb", "B/Cb/A##"};

    private static final String[] basicNoteList = new String[]{"C", "D", "E", "F", "G", "A", "B"};


    public static String intervalConstruction(String[] args) {

        //  - If there are more or fewer elements in the input array, an exception should be thrown: "Illegal number of elements in input array"

        int degreeStepsCount = Integer.parseInt(args[0].substring(1));

        int endDegreeIndex = 0;
        int endDegreeIndexDsc = 0;

        boolean descending = args.length == 3 && args[2].equals("dsc");

        // Looking for basicNoteList end index.
        for (int i = 0; i < basicNoteList.length; i++) {
            if (basicNoteList[i].equals(args[1].substring(0, 1))) {
                endDegreeIndex = (i + degreeStepsCount) % basicNoteList.length - 1;
                endDegreeIndexDsc = ((i - degreeStepsCount + 1) + basicNoteList.length) % basicNoteList.length;
                break;
            }
        }

        // semitones count in intervals(return index of interval=SemitonesCount)

        int semitonesCount = semitoneCounter(args);

        int intervalStartIndex = 0;

        // left note index lookup
        for (int i = 0; i < completeNoteList.length; i++) {
            String[] splittedNote = completeNoteList[i].split("/");
            for (String note : splittedNote) {
                if (note.equals(args[1])) {
                    intervalStartIndex = i;
                    break;
                }
            }
        }

        // right interval index lookup in notes
        int rightNoteIndex = (intervalStartIndex + semitonesCount) % completeNoteList.length;
        int rightNoteIndexDsc = ((intervalStartIndex - semitonesCount) + completeNoteList.length) % completeNoteList.length;

        if (descending) {
            rightNoteIndex = rightNoteIndexDsc;
            endDegreeIndex = endDegreeIndexDsc;
        }

        //Splitting notes
        String[] rightNote = completeNoteList[rightNoteIndex].split("/");
        String result = null;
        for (String splitNote : rightNote) {
            if (splitNote.substring(0, 1).equals(basicNoteList[endDegreeIndex])) {
                result = splitNote;
            }
        }

        return result;
    }

    public static String intervalIdentification(String[] args) {
        // - If the interval does not fit a description, an exception should be thrown: "Cannot identify the interval".

        boolean descending = args.length == 3 && args[2].equals("dsc");

        int intervalStartIndex = 0;
        int intervalEndIndex = 0;

        // left & right note index lookup
        for (int i = 0; i < completeNoteList.length; i++) {
            String[] splittedNote = completeNoteList[i].split("/");
            for (String note : splittedNote) {
                if (note.equals(args[1])) {
                    intervalEndIndex = i;
                }
                if (note.equals(args[0])) {
                    intervalStartIndex = i;
                }
            }
        }

        int semitonesCount = ((intervalEndIndex - intervalStartIndex) + completeNoteList.length) % completeNoteList.length;
        int semitonesCountDes = ((intervalStartIndex - intervalEndIndex) + completeNoteList.length) % completeNoteList.length;

        if (descending) {
            return intervalList[semitonesCountDes];
        }

        return intervalList[semitonesCount];
    }

    private static int semitoneCounter(String[] args) {
        return IntStream
                .range(0, intervalList.length)
                .filter(i -> intervalList[i].equals(args[0]))
                .findFirst().orElse(-1);
    }
}

package com.piatsevich;
        /*
        m2 - Minor Second - 1 semitone, 2 degrees <br>
        M2 - Major Second - 2 semitones, 2 degrees <br>
        m3 - Minor Third - 3 semitones, 3 degrees <br>
        M3 - Major Third - 4 semitones, 3 degrees <br>
        P4 - Perfect Fourth - 5 semitones, 4 degrees <br>
        P5 - Perfect Fifth - 7 semitones, 5 degrees <br>
        m6 - Minor Sixth - 8 semitones, 6 degrees <br>
        M6 - Major Sixth - 9 semitones, 6 degrees <br>
        m7 - Minor Seventh - 10 semitones, 7 degrees <br>
        M7 - Major Seventh - 11 semitones, 7 degrees <br>
        P8 - Perfect Octave - 12 semitones, 8 degrees <br>
        */

//        args = new String[] {"M2", "C"};

import java.util.stream.IntStream;

public class Intervals {
    public static String intervalConstruction(String[] args) {


        // interval's index corresponds to number of semitones in interval
        String[] intervals = new String[]
                {"", "m2", "M2", "m3", "M3", "P4", "", "P5", "m6", "M6", "m7", "M7", "P8"};

        // all possible notes combinations
        String[] notes = new String[]{"C/Dbb/B#", "C#/Db/B##", "D/C##/Ebb", "D#/Eb/Fbb",
                "E/D##/Fb", "F/E#/Gbb", "F#/Gb/E##", "G/F##/Abb", "G#/Ab", "A/G##/Bbb", "A#/Bb/Cbb", "B/Cb/A##"};

        String[] degrees = new String[]{"C", "D", "E", "F", "G", "A", "B"};

        int semitonesCount = 0;
        int degreeStepsCount = Integer.parseInt(args[0].substring(1));

        int rightDegreeIndex = 0;
        int rightDegreeIndexDsc = 0;

        boolean descending = args.length == 3 && args[2].equals("dsc");


        // Looking for degree right index. If degreeEndPointIndex out of boundary, move it to the beginning
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i].equals(args[1].substring(0,1))) {
                rightDegreeIndex = (i + degreeStepsCount) % degrees.length - 1;
                rightDegreeIndexDsc = ((i - degreeStepsCount + 1) + degrees.length) % degrees.length;
                break;
            }
        }

        // semitones count in intervals(return index of interval=NofSemitones)
        semitonesCount = IntStream
                .range(0, intervals.length)
                .filter(i -> intervals[i].equals(args[0]))
                .findFirst().orElse(-1);


        int intervalLeftIndex = 0;

        // left note index lookup
        for (int i = 0; i < notes.length; i++) {
            String[] splittedNote = notes[i].split("/");
            for (String note : splittedNote) {
                if (note.equalsIgnoreCase(args[1])) {
                    intervalLeftIndex = i;
                    break;
                }
            }
        }

        // right interval index lookup in notes
        int rightNoteIndex = (intervalLeftIndex + semitonesCount) % notes.length;
        int rightNoteIndexDsc = ((intervalLeftIndex - semitonesCount) + notes.length) % notes.length;

        if(descending) {
            rightNoteIndex = rightNoteIndexDsc;
            rightDegreeIndex = rightDegreeIndexDsc;
        }

        //Splitting notes
        String[] rightNote = notes[rightNoteIndex].split("/");
        String result = null;
        for (String splitNote : rightNote) {
            if (splitNote.substring(0, 1).equals(degrees[rightDegreeIndex])) {
                result = splitNote;
            }
        }

        return result;
    }

    public static String intervalIdentification(String[] args) {




        /*
        input:
        Cbb Cb C C# C## Dbb Db D D# D## Ebb Eb E E# E## Fbb Fb F F# F## Gbb Gb G G# G## Abb Ab A A# A## Bbb Bb B B# B##

        return:
        m2 M2 m3 M3 P4 P5 m6 M6 m7 M7 P8

        ['C#', 'Fb'] - find an ascending interval between C# and Fb <br>
        ['A', 'G#', 'asc'] - find an ascending interval between A and G# <br


        String[] nqotes = new String[]{"C/Dbb/B#", "C#/Db/B##", "D/C##/Ebb", "D#/Eb/Fbb",
        "E/D##/Fb", "F/E#/Gbb", "F#/Gb/E##", "G/F##/Abb", "G#/Ab", "A/G##/Bbb", "A#/Bb/Cbb", "B/Cb/A##"};
         */
        return null;
    }
}

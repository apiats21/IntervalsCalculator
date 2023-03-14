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

//        String[] notes = new String[]
//                {"Cb", "C", "C#", "Db", "D", "D#", "Eb", "E", "E#", "Fb", "F", "F#", "Gb", "G", "G#", "Ab", "A", "A#", "Bb", "B", "B#"};

// C C#/Db D D#/Eb E F F#/Gb G G#/Ab A A#/Bb B


import java.util.stream.IntStream;

public class Intervals {
    public static String intervalConstruction(String[] args) {

//        args = new String[]{"P5", "B"};

        // interval's index corresponds to number of semitones in interval
        String[] intervals = new String[]
                {"", "m2", "M2", "m3", "M3", "P4", "", "P5", "m6", "M6", "m7", "M7", "P8"};

        // all possible notes combinations
        String[] notes = new String[]{"C/Dbb/B#", "C#/Db/B##", "D/C##/Ebb", "D#/Eb/Fbb",
                "E/D##/Fb", "F/E#/Gbb", "F#/Gb/E##", "G/F##/Abb", "G#/Ab", "A/G##/Bbb", "A#/Bb/Cbb", "B/Cb/A##"};

        String[] degrees = new String[]{"C", "D", "E", "F", "G", "A", "B"}; // Need left and right degrees

        int semitonesCount = 0;
        int degreeStartPointIndex = 0;

        // Looking for degree left index
        String degreeStartPoint = args[1].substring(0, 1);
//        for (int i = 0; i < degrees.length; i++) {
//            if (degrees[i].equals(degreeStartPoint)) {
//                degreeStartPointIndex = i;
//            }
//        }
//
//        // Looking for degree right index. If degreeEndPointIndex out of boundary, move it to the beginning
        int degreeStepsCount = Integer.parseInt(args[0].substring(1));
//        int degreeEndPointIndex = degreeStartPointIndex + degreeStepsCount -1;
//
//        if (degreeEndPointIndex > 6) {
//            degreeEndPointIndex = degreeEndPointIndex - 8;
//        }
        int rightDegreeIndex = 0;
        int rightDegreeIndexDsc = 0;

        //        args = new String[]{"P5", "B"};


        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i].equals(args[1].substring(0,1))) {
                rightDegreeIndex = (i + degreeStepsCount) % degrees.length - 1;
                rightDegreeIndexDsc = ((i - degreeStepsCount + 1) + degrees.length) % degrees.length;
                break;
            }
        }

        // semitones count in intervals
//        for (int i = 0; i < intervals.length; i++) {
//            if (intervals[i].equals(args[0])) {
//                semitonesCount = i;
//            }
//        }

        // semitones count in intervals
        semitonesCount = IntStream
                .range(0, intervals.length)
                .filter(i -> intervals[i].equals(args[0]))
                .findFirst().orElse(-1);

        //        args = new String[]{"P5", "B"};

        // all possible notes combinations
        String[] notees = new String[]{"C/Dbb/B#", "C#/Db/B##", "D/C##/Ebb", "D#/Eb/Fbb",
                "E/D##/Fb", "F/E#/Gbb", "F#/Gb/E##", "G/F##/Abb", "G#/Ab", "A/G##/Bbb", "A#/Bb/Cbb", "B/Cb/A##"};


        int intervalLeftIndex = 0;
        int intervalRightIndex = 0;
        int intervalRightIndexDsc = 0;

        // left interval index lookup in notes
        for (int i = 0; i < notes.length; i++) {
            String[] splittedNote = notes[i].split("/");
            for (String note : splittedNote) {
                if (note.equalsIgnoreCase(args[1])) {
                    intervalLeftIndex = i;
                    break;
                }
            }
        }

        for (int i = 0; i < notes.length; i++) {
            if (degrees[i].equals("E")) {
                break;
            }
        }

        int rightNoteIndex = (intervalLeftIndex + semitonesCount) % notes.length - 1;
        int rightNoteIndexDsc = ((intervalLeftIndex - semitonesCount + 1) + notees.length) % notees.length;

        // right interval index lookup in notes
        intervalRightIndex = intervalLeftIndex + semitonesCount;
        if (intervalRightIndex > 11) {
            intervalRightIndex = intervalRightIndex - 12;
        }

        //{"C", "D", "E", "F", "G", "A", "B"};
        String[] nqotes = new String[]{"C/Dbb/B#", "C#/Db/B##", "D/C##/Ebb", "D#/Eb/Fbb",
                "E/D##/Fb", "F/E#/Gbb", "F#/Gb/E##", "G/F##/Abb", "G#/Ab", "A/G##/Bbb", "A#/Bb/Cbb", "B/Cb/A##"};

        String[] rightNote = notes[intervalRightIndex].split("/");
        String result = null;
        for (String splitNote : rightNote) {
            if (splitNote.substring(0, 1).equals(degrees[rightDegreeIndex])) {
                String test = splitNote.substring(0, 1);
                result = splitNote;
            }

        }


        System.out.println(result);


        /*
        input:
            notes: Cb C C# Db D D# Eb E E# Fb F F# Gb G G# Ab A A# Bb B B#
            notes: "Cb", "C", "C#", "Db", "D", "D#", "Eb", "E", "E#", "Fb", "F", "F#", "Gb", "G", "G#", "Ab", "A", "A#", "Bb", "B", "B#"
            intervals: m2 M2 m3 M3 P4 P5 m6 M6 m7 M7 P8

        return:
        Cbb Cb C C# C## Dbb Db D D# D## Ebb Eb E E# E## Fbb Fb F F# F## Gbb Gb G G# G## Abb Ab A A# A## Bbb Bb B B# B##

        ['M3', 'A', 'asc'] - build an ascending M3 interval starting from A <br>
        ['m7, 'Fb', 'dsc'] - build an descending m7 interval starting from Fb <br>
        ['P4', 'E#'] - build an ascending P4 interval starting from E# <br>
         */

        return null;
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

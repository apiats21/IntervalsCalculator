package com.piatsevich;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntervalsTest {
    private static String[][] twoNoteList;
    private static String[] expectedInterval;
    private static String[][] intervalAndNoteList;
    private static String[] expectedNote;

    @BeforeAll
    public static void init() {

        String[] input11 = new String[]{"M2", "C", "asc"};
        String[] input12 = new String[]{"P5", "B", "asc"};
        String[] input13 = new String[]{"m2", "Bb", "dsc"};
        String[] input14 = new String[]{"M3", "Cb", "dsc"};
        String[] input15 = new String[]{"P4", "G#", "dsc"};
        String[] input16 = new String[]{"m3", "B", "dsc"};
        String[] input17 = new String[]{"m2", "Fb", "asc"};
        String[] input18 = new String[]{"M2", "E#", "dsc"};
        String[] input19 = new String[]{"P4", "E", "dsc"};
        String[] input20 = new String[]{"m2", "D#", "asc"};
        String[] input21 = new String[]{"M7", "G", "asc"};

        intervalAndNoteList = new String[][]{input11, input12, input13, input14, input15, input16, input17, input18, input19, input20, input21};
        expectedNote = new String[]{"D", "F#", "A", "Abb", "D#", "G#", "Gbb", "D#", "B", "E", "F#"};

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

        twoNoteList = new String[][]{input, input1, input2, input3, input4, input5, input6, input7, input8, input9};
        expectedInterval = new String[]{"M2", "P5", "m2", "M7", "m2", "M3", "P4", "P4", "M2", "m3"};
    }

    @Test
    void multipleIntervalConstructionTest() {

        for( int i =0; i < intervalAndNoteList.length; i++){
            assertEquals(expectedNote[i], Intervals.intervalConstruction(intervalAndNoteList[i]));
        }
    }

    @Test
    void multipleIntervalIdentificationTest() {
        for( int i =0; i < twoNoteList.length; i++){
            assertEquals(expectedInterval[i], Intervals.intervalIdentification(twoNoteList[i]));
        }
    }
}
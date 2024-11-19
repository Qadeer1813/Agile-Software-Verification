// Student Name: Qadeer Hussain
// Student Id: C00270632
// Description: JUnit White Box testing for Period
package cm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class HussainQadeerTestTaskPeriod2 {

//    Period Constructor
    @Test
    void startHrIsGreaterThan0 (){
        cm.Period period = new cm.Period(5,7);
        assertEquals(5, period.startHour);
        assertEquals(7, period.endHour);
    }

    @Test
    void startHrIs0() {
        cm.Period period = new cm.Period(0,10);
        assertEquals(0, period.startHour);
        assertEquals(10, period.endHour);
    }

    @Test
    void startHrIsLessThan24() {
        cm.Period period = new cm.Period(13,23);
        assertEquals(13, period.startHour);
        assertEquals(23, period.endHour);
    }

    @Test
    void endHrIsGreaterThan0 (){
        cm.Period period = new cm.Period(6,9);
        assertEquals(6, period.startHour);
        assertEquals(9, period.endHour);
    }

    @Test
    void endHrIsLessThan24() {
        cm.Period period = new cm.Period(10,22);
        assertEquals(10, period.startHour);
        assertEquals(22, period.endHour);
    }

    @Test
    void startHrIsLssThan0() {
        assertThrows(IllegalArgumentException.class, () -> {
            new cm.Period(-1, 7);
        });
    }

    @Test
    void startHrIsGreaterThan24() {
        assertThrows(IllegalArgumentException.class, () -> {
            new cm.Period(25,27); // changed will be written in different
        });
    }

    @Test
    void endHrIsLessThan0() {
        assertThrows(IllegalArgumentException.class, () -> {
            new cm.Period(4,-1);
        });
    }

    @Test
    void endHrEquals0() {
        assertThrows(IllegalArgumentException.class, () -> {
            new cm.Period(5,0);
        });
    }

    @Test
    void endHrIsGreaterThan24() {
        assertThrows(IllegalArgumentException.class, () -> {
            new cm.Period(7,25);
        });
    }

    @Test
    void startHrSameAsEndHr() {
        assertThrows(IllegalArgumentException.class, () -> {
            new cm.Period(10,10);
        });
    }

    @Test
    void EndHrIsLessThanStartHr() {
        assertThrows(IllegalArgumentException.class, () -> {
            new cm.Period(10,9);
        });
    }


//    Overlaps
    @Test
    void periodAAndPeriodBothTheSame() {
        cm.Period periodA = new cm.Period(5, 15);
        cm.Period periodB = new cm.Period(5, 15);
        assertTrue(periodA.overlaps(periodB));
    }

    @Test
    void periodBStartsAndEndsWhilePeriodAIsRunning() {
        cm.Period periodA = new cm.Period(8,15);
        cm.Period periodB = new cm.Period(10,13);
        assertTrue(periodA.overlaps(periodB));
    }

    @Test
    void periodBStartsBeforePeriodAEnds() {
        cm.Period periodA = new cm.Period(8,15);
        cm.Period periodB = new cm.Period(14,18);
        assertTrue(periodA.overlaps(periodB));
    }

    @Test
    void PeriodBStartsWhenPeriodAIsFinished() {
        cm.Period periodA = new cm.Period(8,10);
        cm.Period periodB = new cm.Period(10,14);
        assertFalse(periodA.overlaps(periodB));
    }

    @Test
    void periodEndBeforePeriodAStarts() {
        cm.Period periodA = new cm.Period(14,16);
        cm.Period periodB = new cm.Period(11,13);
        assertFalse(periodA.overlaps(periodB));
    }

    @Test
    void periodAHasStartAndEndWhilePeriodBIsNull() {
        cm.Period periodA = new cm.Period(2,4);
        cm.Period periodB = null;
        assertThrows(IllegalArgumentException.class, () -> periodA.overlaps(periodB));
    }

    //  Duration
    @Test
    void periodMinDuration() {
        cm.Period period = new cm.Period(2,3);
        assertEquals(1,period.duration());
    }

    @Test
    void periodMaxDuration() {
        cm.Period period = new cm.Period(0,24);
        assertEquals(24,period.duration());
    }

    //    New test to get to branch coverage 96%
    @Test
    void hourPartiallyInPeriods() {
        cm.Period periodA = new cm.Period(3, 6);
        cm.Period periodB = new cm.Period(5, 8);
        cm.Period testPeriod = new cm.Period(4, 7);
        List<cm.Period> list = Arrays.asList(periodA, periodB);
        assertEquals(3, testPeriod.occurences(list));
    }

}

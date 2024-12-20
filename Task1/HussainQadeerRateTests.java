// Student Name: Qadeer Hussain
// Student Id: C00270632
// Description: JUnit Black Box testing for Rate

package Task1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

public class HussainQadeerRateTests {

//  Rate Constructor Tests
    @Test
    void normalRateGreaterThanZero() {
        ArrayList<cm.Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new cm.Period(3, 5));
        reducedPeriod.add(new cm.Period(7, 10));

        ArrayList<cm.Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new cm.Period(11, 14));
        normalPeriod.add(new cm.Period(15, 17));

        BigDecimal normalRate = new BigDecimal(6);
        BigDecimal reducedRate = new BigDecimal(3);
        cm.Rate rate = new cm.Rate(cm.CarParkKind.STAFF, reducedPeriod, normalPeriod, normalRate, reducedRate);
    }

    @Test
    void reducedRateGreaterThanZero() {
        ArrayList<cm.Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new cm.Period(2, 4));
        reducedPeriod.add(new cm.Period(8, 12));

        ArrayList<cm.Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new cm.Period(13, 14));
        normalPeriod.add(new cm.Period(17, 20));

        BigDecimal normalRate = new BigDecimal(6);
        BigDecimal reducedRate = new BigDecimal(3);
        cm.Rate rate = new cm.Rate(cm.CarParkKind.STAFF, reducedPeriod, normalPeriod, normalRate, reducedRate);
    }

    @Test
    void normalRateGreaterThanReducedRate() {
        ArrayList<cm.Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new cm.Period(6,8));
        reducedPeriod.add(new cm.Period(9,13));

        ArrayList<cm.Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new cm.Period(14,15));
        normalPeriod.add(new cm.Period(16,19));

        BigDecimal normalRate = new BigDecimal(8);
        BigDecimal reducedRate = new BigDecimal(5);

        cm.Rate rate = new cm.Rate(cm.CarParkKind.VISITOR, reducedPeriod, normalPeriod, normalRate, reducedRate);
    }

    @Test
    void existingCarPark() {
        ArrayList<cm.Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new cm.Period(6,7));
        reducedPeriod.add(new cm.Period(8,9));

        ArrayList<cm.Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new cm.Period(11,13));
        normalPeriod.add(new cm.Period(14,17));

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(3);

        cm.Rate rate = new cm.Rate(cm.CarParkKind.STUDENT, reducedPeriod, normalPeriod, normalRate, reducedRate);
    }

    @Test
    void noOverlappingReducedPeriod() {
        ArrayList<cm.Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new cm.Period(6,10));
        reducedPeriod.add(new cm.Period(11,13));

        ArrayList<cm.Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new cm.Period(12,14));
        normalPeriod.add(new cm.Period(15,17));

        BigDecimal normalRate = new BigDecimal(8);
        BigDecimal reducedRate = new BigDecimal(5);

        cm.Rate rate = new cm.Rate(cm.CarParkKind.STUDENT, reducedPeriod, normalPeriod, normalRate, reducedRate);

        assertFalse(reducedPeriod.get(0).overlaps(reducedPeriod.get(1)));
    }

    @Test
    void noOverlappingNormalPeriod() {
        ArrayList<cm.Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new cm.Period(6,8));
        reducedPeriod.add(new cm.Period(9,13));

        ArrayList<cm.Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new cm.Period(14,15));
        normalPeriod.add(new cm.Period(16,19));

        BigDecimal normalRate = new BigDecimal(8);
        BigDecimal reducedRate = new BigDecimal(5);

        cm.Rate rate = new cm.Rate(cm.CarParkKind.VISITOR, reducedPeriod, normalPeriod, normalRate, reducedRate);

        assertFalse(normalPeriod.get(0).overlaps(normalPeriod.get(1)));
    }

    @Test
    void normalRateSameReducedRate() {
        ArrayList<cm.Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new cm.Period(6,8));
        reducedPeriod.add(new cm.Period(9,13));

        ArrayList<cm.Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new cm.Period(14,15));
        normalPeriod.add(new cm.Period(16,19));

        BigDecimal normalRate = new BigDecimal(6);
        BigDecimal reducedRate = new BigDecimal(6);

        cm.Rate rate = new cm.Rate(cm.CarParkKind.VISITOR, reducedPeriod, normalPeriod, normalRate, reducedRate);
    }

    @Test
    void normalRateLessThan0() {
        ArrayList<cm.Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new cm.Period(3, 5));
        reducedPeriod.add(new cm.Period(7, 10));

        ArrayList<cm.Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new cm.Period(11, 14));
        normalPeriod.add(new cm.Period(15, 17));

        BigDecimal normalRate = new BigDecimal(-1);
        BigDecimal reducedRate = new BigDecimal(3);

        assertThrows(IllegalArgumentException.class, () -> {
            new cm.Rate(cm.CarParkKind.STAFF, reducedPeriod, normalPeriod, normalRate, reducedRate);
        });
    }


    @Test
    void reduceRateLessThan0() {
        ArrayList<cm.Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new cm.Period(6,7));
        reducedPeriod.add(new cm.Period(8,9));

        ArrayList<cm.Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new cm.Period(11,13));
        normalPeriod.add(new cm.Period(14,17));

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(-2);

        assertThrows(IllegalArgumentException.class, () -> {
            new cm.Rate(cm.CarParkKind.STUDENT, reducedPeriod, normalPeriod, normalRate, reducedRate);
        });
    }

    @Test
    void normalRateLessGreaterThan10() {
        ArrayList<cm.Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new cm.Period(6,8));
        reducedPeriod.add(new cm.Period(9,13));

        ArrayList<cm.Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new cm.Period(14,15));
        normalPeriod.add(new cm.Period(16,19));

        BigDecimal normalRate = new BigDecimal(12);
        BigDecimal reducedRate = new BigDecimal(5);

        assertThrows(IllegalArgumentException.class, () -> {
            new cm.Rate(cm.CarParkKind.VISITOR, reducedPeriod, normalPeriod, normalRate, reducedRate);
        });
    }

    @Test
    void reducedRateLessGreaterThan10() {
        ArrayList<cm.Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new cm.Period(3, 5));
        reducedPeriod.add(new cm.Period(7, 10));

        ArrayList<cm.Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new cm.Period(11, 14));
        normalPeriod.add(new cm.Period(15, 17));

        BigDecimal normalRate = new BigDecimal(7);
        BigDecimal reducedRate = new BigDecimal(20);

        assertThrows(IllegalArgumentException.class, () -> {
            new cm.Rate(cm.CarParkKind.STAFF, reducedPeriod, normalPeriod, normalRate, reducedRate);
        });
    }

    @Test
    void normalRateLessThanReducedRate() {
        ArrayList<cm.Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new cm.Period(6,7));
        reducedPeriod.add(new cm.Period(8,9));

        ArrayList<cm.Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new cm.Period(11,13));
        normalPeriod.add(new cm.Period(14,17));

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(7);

        assertThrows(IllegalArgumentException.class, () -> {
            new cm.Rate(cm.CarParkKind.STUDENT, reducedPeriod, normalPeriod, normalRate, reducedRate);
        });
    }

    @Test
    void overLappingReducedPeriod() {
        ArrayList<cm.Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new cm.Period(6,10));
        reducedPeriod.add(new cm.Period(7,11));

        ArrayList<cm.Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new cm.Period(12,14));
        normalPeriod.add(new cm.Period(15,17));

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(3);

        assertThrows(IllegalArgumentException.class, () -> {
            new cm.Rate(cm.CarParkKind.STUDENT, reducedPeriod, normalPeriod, normalRate, reducedRate);
        });
    }

    @Test
    void overLappingNormalPeriod() {
        ArrayList<cm.Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new cm.Period(6,8));
        reducedPeriod.add(new cm.Period(9,13));

        ArrayList<cm.Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new cm.Period(14,17));
        normalPeriod.add(new cm.Period(15,18));

        BigDecimal normalRate = new BigDecimal(8);
        BigDecimal reducedRate = new BigDecimal(5);

        assertThrows(IllegalArgumentException.class, () -> {
            new cm.Rate(cm.CarParkKind.VISITOR, reducedPeriod, normalPeriod, normalRate, reducedRate);
        });
    }

    @Test
    void reducedPeriodOverlapWithNormalPeriod() {
        ArrayList<cm.Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new cm.Period(14, 16));

        ArrayList<cm.Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new cm.Period(15, 17));

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(3);

        assertThrows(IllegalArgumentException.class, () -> {
            new cm.Rate(cm.CarParkKind.STUDENT, reducedPeriod, normalPeriod, normalRate, reducedRate);
        });
    }

    @Test
    void normalRateNull() {
        ArrayList<cm.Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new cm.Period(3, 5));
        reducedPeriod.add(new cm.Period(7, 10));

        ArrayList<cm.Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new cm.Period(11, 14));
        normalPeriod.add(new cm.Period(15, 17));

        BigDecimal normalRate = null;
        BigDecimal reducedRate = new BigDecimal(3);

        assertThrows(IllegalArgumentException.class, () -> {
            new cm.Rate(cm.CarParkKind.STAFF, reducedPeriod, normalPeriod, normalRate, reducedRate);
        });
    }

    @Test
    void reducedRateNull() {
        ArrayList<cm.Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new cm.Period(6,8));
        reducedPeriod.add(new cm.Period(9,13));

        ArrayList<cm.Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new cm.Period(14,15));
        normalPeriod.add(new cm.Period(16,19));

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = null;

        assertThrows(IllegalArgumentException.class, () -> {
            new cm.Rate(cm.CarParkKind.VISITOR, reducedPeriod, normalPeriod, normalRate, reducedRate);
        });
    }

//  Rate Calculate Method
    @Test
    void reducedPeriodStay() {
        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(7, 11));

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(12, 16));

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(3);

        cm.Rate rate = new cm.Rate(cm.CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate);

        cm.Period periodStay = new cm.Period(8, 10);
        BigDecimal calculatedCharge = rate.calculate(periodStay);
        assertEquals(new BigDecimal(6), calculatedCharge);
    }

    @Test
    void normalPeriodStay() {
        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(6,12));

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(13,16));

        BigDecimal normalRate = new BigDecimal(6);
        BigDecimal reducedRate = new BigDecimal(3);

        cm.Rate rate = new cm.Rate(cm.CarParkKind.STAFF, reducedPeriods, normalPeriods, normalRate, reducedRate);

        cm.Period periodStay = new cm.Period(14,15);
        BigDecimal calculatedCharge = rate.calculate(periodStay);
        assertEquals(new BigDecimal(6), calculatedCharge);
    }

    @Test
    void mixedPeriodStay() {
        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(9,12));

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(13,15));

        BigDecimal normalRate = new BigDecimal(8);
        BigDecimal reducedRate = new BigDecimal(4);

        cm.Rate rate = new cm.Rate(cm.CarParkKind.VISITOR, reducedPeriods, normalPeriods, normalRate, reducedRate);

        cm.Period periodStay = new cm.Period(11,14);
        BigDecimal calculatedCharge = rate.calculate(periodStay);
        assertEquals(new BigDecimal(12), calculatedCharge);
    }

    @Test
    void outsideOfPeriodStay() {
        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(6,12));

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(13,16));

        BigDecimal normalRate = new BigDecimal(6);
        BigDecimal reducedRate = new BigDecimal(3);

        cm.Rate rate = new cm.Rate(cm.CarParkKind.STAFF, reducedPeriods, normalPeriods, normalRate, reducedRate);

        cm.Period periodStay = new cm.Period(17,20);
        BigDecimal calculatedCharge = rate.calculate(periodStay);
        assertEquals(new BigDecimal(0), calculatedCharge);
    }

    @Test
    void periodStaNull() {
        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(9,12));

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(13,15));

        BigDecimal normalRate = new BigDecimal(8);
        BigDecimal reducedRate = new BigDecimal(4);

        cm.Rate rate = new cm.Rate(cm.CarParkKind.VISITOR, reducedPeriods, normalPeriods, normalRate, reducedRate);

        assertThrows(IllegalArgumentException.class, () -> {
            rate.calculate(null);
        });
    }

}

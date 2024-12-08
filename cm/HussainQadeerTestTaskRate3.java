// Student Name: Qadeer Hussain
// Student Id: C00270632
// Description: JUnit White Box testing for Rate

package cm;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class HussainQadeerTestTaskRate3 {

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
        reducedPeriod.add(new cm.Period(6, 8));
        reducedPeriod.add(new cm.Period(9, 13));

        ArrayList<cm.Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new cm.Period(14, 15));
        normalPeriod.add(new cm.Period(16, 19));

        BigDecimal normalRate = new BigDecimal(8);
        BigDecimal reducedRate = new BigDecimal(5);

        cm.Rate rate = new cm.Rate(cm.CarParkKind.VISITOR, reducedPeriod, normalPeriod, normalRate, reducedRate);
    }

    @Test
    void existingCarPark() {
        ArrayList<cm.Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new cm.Period(6, 7));
        reducedPeriod.add(new cm.Period(8, 9));

        ArrayList<cm.Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new cm.Period(11, 13));
        normalPeriod.add(new cm.Period(14, 17));

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(3);

        cm.Rate rate = new cm.Rate(cm.CarParkKind.STUDENT, reducedPeriod, normalPeriod, normalRate, reducedRate);
    }

    @Test
    void noOverlappingReducedPeriod() {
        ArrayList<cm.Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new cm.Period(6, 10));
        reducedPeriod.add(new cm.Period(11, 12));

        ArrayList<cm.Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new cm.Period(12, 14));
        normalPeriod.add(new cm.Period(15, 17));

        BigDecimal normalRate = new BigDecimal(8);
        BigDecimal reducedRate = new BigDecimal(5);

        cm.Rate rate = new cm.Rate(cm.CarParkKind.STUDENT, reducedPeriod, normalPeriod, normalRate, reducedRate);
        assertFalse(reducedPeriod.get(0).overlaps(reducedPeriod.get(1)));

    }

    @Test
    void noOverlappingNormalPeriod() {
        ArrayList<cm.Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new cm.Period(6, 8));
        reducedPeriod.add(new cm.Period(9, 13));

        ArrayList<cm.Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new cm.Period(14, 15));
        normalPeriod.add(new cm.Period(16, 19));

        BigDecimal normalRate = new BigDecimal(8);
        BigDecimal reducedRate = new BigDecimal(5);

        cm.Rate rate = new cm.Rate(cm.CarParkKind.VISITOR, reducedPeriod, normalPeriod, normalRate, reducedRate);

        assertFalse(normalPeriod.get(0).overlaps(normalPeriod.get(1)));
    }

    @Test
    void normalRateSameReducedRate() {
        ArrayList<cm.Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new cm.Period(6, 8));
        reducedPeriod.add(new cm.Period(9, 13));

        ArrayList<cm.Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new cm.Period(14, 15));
        normalPeriod.add(new cm.Period(16, 19));

        BigDecimal normalRate = new BigDecimal(7);
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
        reducedPeriod.add(new cm.Period(6, 7));
        reducedPeriod.add(new cm.Period(8, 9));

        ArrayList<cm.Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new cm.Period(11, 13));
        normalPeriod.add(new cm.Period(14, 17));

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(-2);

        assertThrows(IllegalArgumentException.class, () -> {
            new cm.Rate(cm.CarParkKind.STUDENT, reducedPeriod, normalPeriod, normalRate, reducedRate);
        });
    }

    @Test
    void normalRateGreaterThan10() {
        ArrayList<cm.Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new cm.Period(6, 8));
        reducedPeriod.add(new cm.Period(9, 13));

        ArrayList<cm.Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new cm.Period(14, 15));
        normalPeriod.add(new cm.Period(16, 19));

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
        reducedPeriod.add(new cm.Period(6, 7));
        reducedPeriod.add(new cm.Period(8, 9));

        ArrayList<cm.Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new cm.Period(11, 13));
        normalPeriod.add(new cm.Period(14, 17));

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(7);

        assertThrows(IllegalArgumentException.class, () -> {
            new cm.Rate(cm.CarParkKind.STUDENT, reducedPeriod, normalPeriod, normalRate, reducedRate);
        });
    }

    @Test
    void overLappingReducedPeriod() {
        ArrayList<cm.Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new cm.Period(6, 10));
        reducedPeriod.add(new cm.Period(7, 11));

        ArrayList<cm.Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new cm.Period(12, 14));
        normalPeriod.add(new cm.Period(15, 17));

        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(3);

        assertThrows(IllegalArgumentException.class, () -> {
            new cm.Rate(cm.CarParkKind.STUDENT, reducedPeriod, normalPeriod, normalRate, reducedRate);
        });
    }

    @Test
    void overLappingNormalPeriod() {
        ArrayList<cm.Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new cm.Period(6, 8));
        reducedPeriod.add(new cm.Period(9, 13));

        ArrayList<cm.Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new cm.Period(14, 17));
        normalPeriod.add(new cm.Period(15, 18));

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
        reducedPeriod.add(new cm.Period(6, 8));
        reducedPeriod.add(new cm.Period(9, 13));

        ArrayList<cm.Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new cm.Period(14, 15));
        normalPeriod.add(new cm.Period(16, 19));

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
        BigDecimal calculatedCharge = rate.calculate(periodStay).setScale(2, BigDecimal.ROUND_HALF_UP);
        assertEquals(new BigDecimal("5.88"), calculatedCharge);
    }

    @Test
    void normalPeriodStay() {
        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(6, 12));

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(13, 16));

        BigDecimal normalRate = new BigDecimal(6);
        BigDecimal reducedRate = new BigDecimal(3);

        cm.Rate rate = new cm.Rate(cm.CarParkKind.STAFF, reducedPeriods, normalPeriods, normalRate, reducedRate);

        cm.Period periodStay = new cm.Period(14, 15);
        BigDecimal calculatedCharge = rate.calculate(periodStay);
        assertEquals(new BigDecimal(6), calculatedCharge);
    }

    @Test
    void mixedPeriodStay() {
        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(9, 12));

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(13, 15));

        BigDecimal normalRate = new BigDecimal(8);
        BigDecimal reducedRate = new BigDecimal(4);

        cm.Rate rate = new cm.Rate(cm.CarParkKind.VISITOR, reducedPeriods, normalPeriods, normalRate, reducedRate);

        cm.Period periodStay = new cm.Period(11, 14);
        BigDecimal calculatedCharge = rate.calculate(periodStay);
        assertEquals(new BigDecimal("1.00"), calculatedCharge);
    }

    @Test
    void outsideOfPeriodStay() {
        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(6, 12));

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(13, 16));

        BigDecimal normalRate = new BigDecimal(6);
        BigDecimal reducedRate = new BigDecimal(3);

        cm.Rate rate = new cm.Rate(cm.CarParkKind.STAFF, reducedPeriods, normalPeriods, normalRate, reducedRate);

        cm.Period periodStay = new cm.Period(17, 20);
        BigDecimal calculatedCharge = rate.calculate(periodStay);
        assertEquals(new BigDecimal(0), calculatedCharge);
    }

    @Test
    void periodStayNull() {
        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(9, 12));

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(13, 15));

        BigDecimal normalRate = new BigDecimal(8);
        BigDecimal reducedRate = new BigDecimal(4);

        cm.Rate rate = new cm.Rate(cm.CarParkKind.VISITOR, reducedPeriods, normalPeriods, normalRate, reducedRate);

        assertThrows(IllegalArgumentException.class, () -> {
            rate.calculate(null);
        });
    }

    // New tests
    @Test
    void overlappingWithTwoPeriods() {
        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(1, 2));
        reducedPeriods.add(new cm.Period(3, 4));
        reducedPeriods.add(new cm.Period(5, 6));

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(2, 4));
        normalPeriods.add(new cm.Period(12, 13));

        BigDecimal normalRate = new BigDecimal(7);
        BigDecimal reducedRate = new BigDecimal(4);
        assertThrows(IllegalArgumentException.class, () -> new Rate(CarParkKind.STAFF, reducedPeriods, normalPeriods, normalRate, reducedRate));
    }

    @Test
    void ReducedPeriodsIsNull() {
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(11, 14));
        normalPeriods.add(new Period(15, 17));

        BigDecimal normalRate = new BigDecimal("5");
        BigDecimal reducedRate = new BigDecimal("3");

        assertThrows(IllegalArgumentException.class, () -> {
            new cm.Rate(cm.CarParkKind.STUDENT, null, normalPeriods, normalRate, reducedRate);
        });
    }

    @Test
    void NormalPeriodsIsNull() {
        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(6, 8));
        reducedPeriods.add(new Period(9, 13));

        BigDecimal normalRate = new BigDecimal("5");
        BigDecimal reducedRate = new BigDecimal("3");

        assertThrows(IllegalArgumentException.class, () -> {
            new cm.Rate(cm.CarParkKind.STUDENT, reducedPeriods, null, normalRate, reducedRate);
        });
    }

    @Test
    void overlappingReducedPeriod() {
        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(10, 15));
        reducedPeriods.add(new cm.Period(14, 20));
        reducedPeriods.add(new cm.Period(16, 18));

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();

        BigDecimal normalRate = new BigDecimal("5");
        BigDecimal reducedRate = new BigDecimal("3");

        assertThrows(IllegalArgumentException.class, () -> {
            new cm.Rate(cm.CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate);
        });
    }

    @Test
    void carParkKindIsNull() {
        ArrayList<cm.Period> reducedPeriod = new ArrayList<>();
        reducedPeriod.add(new cm.Period(3, 5));
        reducedPeriod.add(new cm.Period(7, 10));

        ArrayList<cm.Period> normalPeriod = new ArrayList<>();
        normalPeriod.add(new cm.Period(11, 14));
        normalPeriod.add(new cm.Period(15, 17));

        BigDecimal normalRate = new BigDecimal(6);
        BigDecimal reducedRate = new BigDecimal(3);
        assertThrows(IllegalArgumentException.class, () -> {
            new cm.Rate(null, reducedPeriod, normalPeriod, normalRate, reducedRate);
        });
    }

//    Updated Tests Calculate method
    @Test
    void visitorRateDiscount() {
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(10, 13));

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(13, 17));

        BigDecimal normalRate = new BigDecimal("3");
        BigDecimal reducedRate = new BigDecimal("2");

        Rate rate = new Rate(CarParkKind.VISITOR, reducedPeriods, normalPeriods, normalRate, reducedRate);

        Period periodStay = new Period(10, 17);
        BigDecimal calculatedCharge = rate.calculate(periodStay);
        assertEquals(new BigDecimal("4.00"), calculatedCharge);
    }

    @Test
    void visitorChargeNoDiscount() {
        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(10, 12));

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(13, 15));

        BigDecimal normalRate = new BigDecimal("5");
        BigDecimal reducedRate = new BigDecimal("5");

        cm.Rate rate = new cm.Rate(cm.CarParkKind.VISITOR, reducedPeriods, normalPeriods, normalRate, reducedRate);

        cm.Period periodStay = new cm.Period(10, 12);
        BigDecimal calculatedCharge = rate.calculate(periodStay).setScale(2, BigDecimal.ROUND_HALF_UP);
        assertEquals(new BigDecimal("10.00"), calculatedCharge);
    }

    @Test
    void managementRateMinCharge() {
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(13, 14));

        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(12, 13));

        BigDecimal normalRate = new BigDecimal("2");
        BigDecimal reducedRate = new BigDecimal("1");

        Rate rate = new Rate(CarParkKind.MANAGEMENT, reducedPeriods, normalPeriods, normalRate, reducedRate);

        Period periodStay = new Period(12, 14);
        BigDecimal calculatedCharge = rate.calculate(periodStay).setScale(2, BigDecimal.ROUND_HALF_UP);
        assertEquals(new BigDecimal("4.00"), calculatedCharge);
    }

    @Test
    void managementNoMinimumCharge() {
        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(9, 10));

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(10, 12));

        BigDecimal normalRate = new BigDecimal("3");
        BigDecimal reducedRate = new BigDecimal("2");

        cm.Rate rate = new cm.Rate(cm.CarParkKind.MANAGEMENT, reducedPeriods, normalPeriods, normalRate, reducedRate);

        cm.Period periodStay = new cm.Period(10, 12);
        BigDecimal calculatedCharge = rate.calculate(periodStay).setScale(2, BigDecimal.ROUND_HALF_UP);
        assertEquals(new BigDecimal("6.00"), calculatedCharge);
    }


    @Test
    void studentRateDiscount() {
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(13, 15));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(10, 13));

        BigDecimal normalRate = new BigDecimal("3");
        BigDecimal reducedRate = new BigDecimal("2");

        Rate rate = new Rate(CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate);

        Period periodStay = new Period(10, 15);
        BigDecimal calculatedCharge = rate.calculate(periodStay).setScale(2, BigDecimal.ROUND_HALF_UP);
        assertEquals(new BigDecimal("11.13"), calculatedCharge);
    }

    @Test
    void studentNoDiscountApplied() {
        ArrayList<cm.Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new cm.Period(9, 12));

        ArrayList<cm.Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new cm.Period(12, 13));

        BigDecimal normalRate = new BigDecimal("2");
        BigDecimal reducedRate = new BigDecimal("1");

        cm.Rate rate = new cm.Rate(cm.CarParkKind.STUDENT, reducedPeriods, normalPeriods, normalRate, reducedRate);

        cm.Period periodStay = new cm.Period(9, 13);
        BigDecimal calculatedCharge = rate.calculate(periodStay).setScale(2, BigDecimal.ROUND_HALF_UP);
        assertEquals(new BigDecimal("5.00"), calculatedCharge);
    }


    @Test
    void staffRateMaxPay(){
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(14, 16));
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(9, 14));

        BigDecimal normalRate = new BigDecimal("4");
        BigDecimal reducedRate = new BigDecimal("2");

        Rate rate = new Rate(CarParkKind.STAFF, reducedPeriods, normalPeriods, normalRate, reducedRate);

        Period periodStay = new Period(9, 16);
        BigDecimal calculatedCharge = rate.calculate(periodStay).setScale(2, BigDecimal.ROUND_HALF_UP);
        assertEquals(new BigDecimal("16.00"), calculatedCharge);
    }
}

package com.tw.vapasi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest {
    @Test
    void expect50CmsEquals50Cms() {
        Unit unit = Unit.CM;

        double actualResult = unit.convertToBase(50);

        assertEquals(50, actualResult);
    }

    @Test
    void expect30MeterEquals3000Cms() {
        Unit unit = Unit.M;

        double actualResult = unit.convertToBase(30);

        assertEquals(3000, actualResult);
    }

    @Test
    void expect200000CmsEquals2Km() {
        Unit unit = Unit.KM;

        double actualResult = unit.convertFromBase(200000);

        assertEquals(2, actualResult);
    }

    @Test
    void expectCmAndMeterHaveSameUnitType() {
        Unit cm = Unit.CM;
        Unit m = Unit.M;

        boolean actualResult = cm.isCompatibleType(m);

        assertTrue(actualResult);
    }
}

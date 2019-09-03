package com.tw.vapasi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.tw.vapasi.Measurement.*;
import static org.junit.jupiter.api.Assertions.*;

class MeasurementTest {
    @Nested
    class DistanceTests {
        @Test
        void expect100CmEquals100cm() {
            Assertions.assertEquals(cms(100), cms(100));
        }

        @Test
        void expect100cmEquals1Meter() {
            assertEquals(cms(100), meter(1));
        }

        @Test
        void expect100000CmEquals1Kilometer() {
            assertEquals(cms(100000), km(1));
        }

        @Test
        void expect2mEquals200Centimeter() {
            assertEquals(meter(2), cms(200));
        }

        @Test
        void expect5MeterEquals5Meter() {
            assertEquals(meter(5), meter(5));
        }

        @Test
        void expect5000MeterEquals5Kilometer() {
            assertEquals(meter(5000), km(5));
        }

        @Test
        void expect4KiloMeterEquals400000Centimeters() {
            assertEquals(km(4), cms(400000));
        }

        @Test
        void expect4KiloMeterEquals4000Meters() {
            assertEquals(km(4), meter(4000));
        }

        @Test
        void expect7KiloMeterEquals7Kilometers() {
            assertEquals(km(7), km(7));
        }

        @Test
        void expectFalseWhenOneObjectIsNull() {
            assertNotEquals(null, cms(30));
        }
    }

    @Nested
    class WeightTests
    {
        @Test
        void expect1KgAnd1000GmsAreEqual()
        {
            assertEquals(kg(1), gms(1000));
        }

        @Test
        void expect2KgAnd200GmsAreNotEqual()
        {
            assertNotEquals(kg(2), gms(200));
        }

        @Test
        void expect1KgAnd1KmAreNotEqual()
        {
            assertNotEquals(kg(1), km(1));
        }

        @Test
        void expect1KgAnd10MAreNotEqual()
        {
            assertNotEquals(kg(1), meter(10));
        }
    }
}

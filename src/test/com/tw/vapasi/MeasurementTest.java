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

        @Test
        void expectSumOf100CmAnd2MeterIsEqualTo2200Cm() throws Exception {
            Measurement cm = cms(100);
            Measurement meter = meter(2);
            Measurement expectedCm = cms(300);

            Measurement actualCm = cm.add(meter);

            assertEquals(expectedCm, actualCm);
        }
    }

    @Nested
    class WeightTests {
        @Test
        void expect1KgAnd1000GmsAreEqual() {
            assertEquals(kg(1), gms(1000));
        }

        @Test
        void expect2KgAnd200GmsAreNotEqual() {
            assertNotEquals(kg(2), gms(200));
        }

        @Test
        void expect1KgAnd1KmAreNotEqual() {
            assertNotEquals(kg(1), km(1));
        }

        @Test
        void expect1KgAnd10MAreNotEqual() {
            assertNotEquals(kg(1), meter(10));
        }

        @Test
        void expectSumOf2KgAnd200GmIsEqualTo2_2Kg() throws Exception {
            Measurement kg = kg(2);
            Measurement gm = gms(200);
            Measurement expectedKg = kg(2.2);

            Measurement actualKg = kg.add(gm);

            assertEquals(expectedKg, actualKg);
        }

        @Test
        void expectAdditionOfDistanceAndWeightUnitsAreNotAllowed() {
            try {
                Measurement cm = cms(100);
                Measurement gm = gms(100);

                Measurement actualResult = cm.add(gm);
                Assertions.fail("Incompatible Unit Types");
            } catch (Exception e) {
                //expected path
            }
        }
    }

    @Nested
    class TemperatureTests {
        @Test
        void expect1CelciusEquals274Kelvin() {
            Measurement celcius = celcius(1);
            Measurement kelvin = kelvin(274);

            assertEquals(celcius, kelvin);
        }

        @Test
        void expect50FahrenheitEquals10Celcius() {
            Measurement fahrenheit = fahrenheit(50);
            Measurement celcius = celcius(10);

            assertEquals(fahrenheit, celcius);
        }

        @Test
        void expect32FahrenheitEquals273Kelvin() {
            Measurement fahrenheit = fahrenheit(32);
            Measurement kelvin = kelvin(273);

            assertEquals(fahrenheit, kelvin);
        }
    }
}

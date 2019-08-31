package com.tw.vapasi;

import java.util.Objects;

//understands length with different units
class Distance {

    private static final double ONE_METER_IN_CENTIMETER = 100;
    private static final double ONE_KILOMETER_IN_CENTIMETER = 100000;
    private final double value;
    private final Unit unit;

    Distance(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    static Distance centimeter(int magnitude) {
        return new Distance(magnitude, Unit.CM);
    }

    static Distance meter(int magnitude) {
        return new Distance(magnitude, Unit.M);
    }

    static Distance kilometer(int magnitude) {
        return new Distance(magnitude, Unit.KM);
    }


    private double converttoCm() {
        switch (this.unit) {
            case M:
                return this.value * ONE_METER_IN_CENTIMETER;
            case KM:
                return this.value * ONE_KILOMETER_IN_CENTIMETER;
        }
        return this.value;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;
        Distance other = (Distance) otherObject;
        return this.converttoCm() == other.converttoCm();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.unit.hashCode() + this.value);
    }

    enum Unit {
        KM,
        CM,
        M
    }

}



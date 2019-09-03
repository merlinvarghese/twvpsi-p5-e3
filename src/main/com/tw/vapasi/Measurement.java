package com.tw.vapasi;

import java.util.Objects;

//Understands dimensions with different units
class Measurement {
    private final double value;
    private final Unit unit;
    private final Unit.UnitType unitType;

    private Measurement(double value, Unit unit, Unit.UnitType unitType) {
        this.value = value;
        this.unit = unit;
        this.unitType = unitType;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other == null)
            return false;

        if (getClass() != other.getClass()) {
            return false;
        }

        Measurement otherMeasurement = (Measurement) other;
        if (isDifferentType(otherMeasurement)) {
            return false;
        }

        return this.convertToBaseUnit() == otherMeasurement.convertToBaseUnit();
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }

    public double convertToBaseUnit() {
        return this.unit.convertToBase(this.value);
    }

    static Measurement cms(double magnitude) {
        return new Measurement(magnitude, Unit.CM, Unit.UnitType.LENGTH);
    }

    static Measurement meter(double magnitude) {
        return new Measurement(magnitude, Unit.M, Unit.UnitType.LENGTH);
    }

    static Measurement km(double magnitude) {
        return new Measurement(magnitude, Unit.KM, Unit.UnitType.LENGTH);
    }

    static Measurement gms(double magnitude) {
        return new Measurement(magnitude, Unit.GM, Unit.UnitType.WEIGHT);
    }

    static Measurement kg(double magnitude) {
        return new Measurement(magnitude, Unit.KG, Unit.UnitType.WEIGHT);
    }

    private double convertToBase() {
        return this.unit.convertToBase(this.value);
    }

    private boolean isDifferentType(Measurement otherMeasurement) {
        return this.unitType != otherMeasurement.unitType ;
    }
}



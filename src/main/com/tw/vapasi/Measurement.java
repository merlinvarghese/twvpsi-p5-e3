package com.tw.vapasi;

import java.util.Objects;

//Understands dimensions with different units
class Measurement {
    private double value;
    private Unit unit;
    private Unit.UnitType unitType;

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
        if (!this.unit.isCompatibleType(otherMeasurement.unit)) {
            return false;
        }
        return this.unit.convertToBase(this.value) == otherMeasurement.unit.convertToBase(otherMeasurement.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, unit);
    }

    Measurement add(Measurement otherObject) throws Exception {
        if (!this.unit.isCompatibleType(otherObject.unit)) {
            throw new IncompatibleMeasurementTypeException();
        }

        double sumInBaseUnit = this.unit.convertToBase(this.value) + otherObject.unit.convertToBase(otherObject.value);
        this.value = this.unit.convertFromBase(sumInBaseUnit);
        return this;
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

    static Measurement celcius(double magnitude) {
        return new Measurement(magnitude, Unit.CELCIUS, Unit.UnitType.TEMPERATURE);
    }

    static Measurement kelvin(double magnitude) {
        return new Measurement(magnitude, Unit.KELVIN, Unit.UnitType.TEMPERATURE);
    }

    static Measurement fahrenheit(double magnitude) {
        return new Measurement(magnitude, Unit.FAHRENHEIT, Unit.UnitType.TEMPERATURE);
    }
}



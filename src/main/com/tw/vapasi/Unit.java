package com.tw.vapasi;

// Understands conversions from one unit to base unit
public class Unit {
    static final Unit KM = new Unit(100000, UnitType.LENGTH, 0);
    static final Unit M = new Unit(100, UnitType.LENGTH, 0);
    static final Unit CM = new Unit(1, UnitType.LENGTH, 0);
    static final Unit KG = new Unit(1000, UnitType.WEIGHT, 0);
    static final Unit GM = new Unit(1, UnitType.WEIGHT, 0);
    static final Unit CELCIUS = new Unit(1, UnitType.TEMPERATURE, 0);
    static final Unit KELVIN = new Unit(1, UnitType.TEMPERATURE, -273);
    static final Unit FAHRENHEIT = new Unit(5.0 / 9, UnitType.TEMPERATURE, -160.0 / 9);

    private final UnitType unitType;
    private final double conversionFactor;
    private final double offset;

    enum UnitType {
        WEIGHT,
        LENGTH,
        TEMPERATURE
    }

    private Unit(double conversionFactor, UnitType unitType, double offset) {
        this.conversionFactor = conversionFactor;
        this.unitType = unitType;
        this.offset = offset;
    }

    double convertToBase(double magnitude) {
        return (magnitude * this.conversionFactor) + offset;
    }

    double convertFromBase(double magnitude) {
        return (magnitude / this.conversionFactor) - offset;
    }

    boolean isCompatibleType(Unit unit) {
        return this.unitType == unit.unitType;
    }
}

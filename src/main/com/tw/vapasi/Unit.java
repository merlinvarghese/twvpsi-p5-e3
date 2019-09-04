package com.tw.vapasi;

// Understands conversions from one unit to base unit
class Unit {
    static final Unit KM = new Unit(100000, UnitType.LENGTH);
    static final Unit M = new Unit(100,UnitType.LENGTH);
    static final Unit CM = new Unit(1,UnitType.LENGTH);
    static final Unit KG = new Unit(1000, UnitType.WEIGHT);
    static final Unit GM = new Unit(1,UnitType.WEIGHT);
    private UnitType unitType;
    private double conversionFactor;

    enum UnitType {
        WEIGHT,
        LENGTH
    }

    private Unit(double conversionFactor,UnitType unitType) {
        this.conversionFactor = conversionFactor;
        this.unitType = unitType;
    }

    double convertToBase(double magnitude) {
        return magnitude * this.conversionFactor;
    }

    double convertFromBase(double magnitude) {
        return magnitude / this.conversionFactor;
    }

    boolean isCompatibleType(Unit unit) {
        return this.unitType != unit.unitType ;
    }
}

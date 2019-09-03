package com.tw.vapasi;

// Understands conversions from one unit to base unit
class Unit {
    static final Unit KM = new Unit(100000);
    static final Unit M = new Unit(100);
    static final Unit CM = new Unit(1);
    static final Unit KG = new Unit(1000);
    static final Unit GM = new Unit(1);
    private UnitType unitType;
    private double conversionFactor;

    double getConversionFactor() {
        return conversionFactor;
    }
    enum UnitType {
        WEIGHT,
        LENGTH
    }

    private Unit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    double convertToBase(double magnitude) {
        return magnitude * this.conversionFactor;
    }
}

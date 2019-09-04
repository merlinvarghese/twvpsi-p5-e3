package com.tw.vapasi;

public class IncompatibleMeasurementTypeException extends Exception {
    public IncompatibleMeasurementTypeException() {
        super("Measurement units are incompatible. Cannot perform given operation");
    }
}

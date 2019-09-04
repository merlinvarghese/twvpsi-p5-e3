package com.tw.vapasi;

class IncompatibleMeasurementTypeException extends Exception {
    IncompatibleMeasurementTypeException() {
        super("Measurement units are incompatible. Cannot perform given operation");
    }
}

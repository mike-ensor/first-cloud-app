package com.ensor.date;

import org.joda.time.DateTime;

public class MockDateTimeSupplier implements DateTimeSupplier {

    private final DateTime mockedDateTime;

    public MockDateTimeSupplier(DateTime mockedDateTime) {
        this.mockedDateTime = mockedDateTime;
    }

    @Override
    public DateTime get() {
        return mockedDateTime;
    }
}

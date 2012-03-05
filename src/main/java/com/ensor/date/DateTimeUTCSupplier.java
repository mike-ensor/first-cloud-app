package com.ensor.date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class DateTimeUTCSupplier implements DateTimeSupplier {

    @Override
    public DateTime get() {
        return new DateTime(DateTimeZone.UTC);
    }
}

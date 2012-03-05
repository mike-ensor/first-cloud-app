package com.ensor.date;

import com.google.common.base.Supplier;
import org.joda.time.DateTime;

public interface DateTimeSupplier extends Supplier<DateTime> {

    DateTime get();

}

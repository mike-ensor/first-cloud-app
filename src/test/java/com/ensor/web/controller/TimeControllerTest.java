package com.ensor.web.controller;

import com.ensor.date.MockDateTimeSupplier;
import org.joda.time.DateTime;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class TimeControllerTest {

    private static final Logger LOG = LoggerFactory.getLogger(TimeControllerTest.class);
    private final int HOUR_OF_DAY = 12;
    private final int MINUTE_OF_DAY = 30;

    @Test
    public void testShowCurrentTime() throws Exception {
        TimeController controller = new TimeController();
        // Create the mock DateTimeSupplier with our known DateTime
        controller.dateTime = new MockDateTimeSupplier(new DateTime(2012, 1, 1, HOUR_OF_DAY, MINUTE_OF_DAY, 0, 0));

        String dateTimeString = controller.showCurrentTime();
        assertThat(dateTimeString, is(String.format("%d:%d", HOUR_OF_DAY, MINUTE_OF_DAY)));
        LOG.debug(dateTimeString);
    }

}

package com.ensor.web.controller;

import com.ensor.date.DateTimeSupplier;
import com.google.common.annotations.VisibleForTesting;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/time")
@VisibleForTesting
class TimeController {

    @Autowired
    DateTimeSupplier dateTime;

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    @ResponseBody
    public String showCurrentTime() {
        return DateTimeFormat.forPattern("hh:mm").print(dateTime.get());
    }
}

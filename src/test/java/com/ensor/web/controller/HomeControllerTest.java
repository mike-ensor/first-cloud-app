package com.ensor.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HomeControllerTest {

    private HomeController controller;

    @Before
    public void setup() {
        controller = new HomeController();
    }

    @Test
    public void testShowHomePage() throws Exception {
        assertThat(controller.showHomePage(new ExtendedModelMap()), is("home/home"));
    }
}

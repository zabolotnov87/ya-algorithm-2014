package com.zabolotnov.yandex2014;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class CirclesTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    private final String expectedOutputContent = "2";
    private final String inputContent = "3" + "\n"
            + "3 4 5" + "\n"
            + "5 4 3" + "\n"
            + "10 10 10" + "\n";

    @Before
    public void mockInOut(){
        System.setIn(new ByteArrayInputStream(inputContent.getBytes()));
        System.setOut(new PrintStream(output));
    }

    @Test
    public void testMain() throws Exception {
        Circles.main(new String[]{});

        String result = output.toString().trim();
        assertEquals(result, expectedOutputContent);
    }
}
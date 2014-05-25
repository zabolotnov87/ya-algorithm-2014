package com.zabolotnov.yandex2014;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class PlayoffTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    private final String expectedOutputContent = "a";
    private final String inputContent = "8" + "\n"
            + "a b" + "\n"
            + "c d" + "\n"
            + "e f" + "\n"
            + "h g" + "\n"
            + "a c" + "\n"
            + "e h" + "\n"
            + "a e" + "\n";

    @Before
    public void mockInOut(){
        System.setIn(new ByteArrayInputStream(inputContent.getBytes()));
        System.setOut(new PrintStream(output));
    }

    @Test
    public void testMain() throws Exception {
        Playoff.main(new String[]{});

        String result = output.toString().trim();
        assertEquals(result, expectedOutputContent);
    }
}

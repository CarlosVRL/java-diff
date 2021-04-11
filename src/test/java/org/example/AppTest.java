package org.example;

import static org.example.Engine.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

public class AppTest {

    private static final String MOCK_1 = "" +
            "id,col2,col3\n" +
            "1,a,b\n" +
            "2,c,d"
            ;

    private static final String MOCK_2 = "" +
            "id,col2,col3\n" +
            "1,a,b\n" +
            "2,x,d"
            ;

    private static final String MOCK_3 = "" +
            "id,col2,col3\n" +
            "1,a,b"
            ;

    private static final String MOCK_4 = "" +
            "id,col2,col3\n" +
            "1,a,b\n" +
            "2,c,d\n" +
            "3,e,f"
            ;

    @Test
    public void givenMock_whenChanged_findsDifference() {
        // given files mocks

        // when compare
        Result result = compare(MOCK_1, MOCK_2);

        // get results object to summarize differences
        assertEquals(result.getChanged().size(), 1);
        assertEquals(result.getAdded().size(), 0);
        assertEquals(result.getRemoved().size(), 0);
    }

    @Test
    public void givenMock_whenAdded_findsDifference() {
        // given files mocks

        // when compare
        Result result = compare(MOCK_1, MOCK_3);

        // get results object to summarize differences
        assertEquals(result.getChanged().size(), 0);
        assertEquals(result.getAdded().size(), 1);
        assertEquals(result.getRemoved().size(), 0);
    }

    @Test
    public void givenMock_whenRemoved_findsDifference() {
        // given files mocks

        // when compare
        Result result = compare(MOCK_1, MOCK_4);

        // get results object to summarize differences
        assertEquals(result.getChanged().size(), 0);
        assertEquals(result.getAdded().size(), 0);
        assertEquals(result.getRemoved().size(), 1);
    }
}

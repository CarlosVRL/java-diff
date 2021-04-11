package org.example;

import static org.example.Engine.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AppTest {

    private static final String MOCK_BASELINE = "" +
            "id,col2,col3\n" +
            "1,a,b\n" +
            "2,c,d"
            ;

    private static final String MOCK_CHANGED = "" +
            "id,col2,col3\n" +
            "1,a,b\n" +
            "2,x,d"
            ;

    private static final String MOCK_REMOVED = "" +
            "id,col2,col3\n" +
            "1,a,b"
            ;

    private static final String MOCK_ADDED = "" +
            "id,col2,col3\n" +
            "1,a,b\n" +
            "2,c,d\n" +
            "3,e,f"
            ;

    private static final String MOCK_VARIOUS = "" +
            "id,col2,col3\n" +
            "2,x,d\n" +
            "3,e,f"
            ;

    @Test
    public void givenMock_whenChanged_findsDifference() {
        // given files mocks

        // when compare
        Result result = compare(MOCK_BASELINE, MOCK_CHANGED);

        // get results object to summarize differences
        assertEquals(result.getChanged().size(), 1);
        assertEquals(result.getAdded().size(), 0);
        assertEquals(result.getRemoved().size(), 0);
    }

    @Test
    public void givenMock_whenAdded_findsDifference() {
        // given files mocks

        // when compare
        Result result = compare(MOCK_BASELINE, MOCK_ADDED);

        // get results object to summarize differences
        assertEquals(result.getChanged().size(), 0);
        assertEquals(result.getAdded().size(), 1);
        assertEquals(result.getRemoved().size(), 0);
    }

    @Test
    public void givenMock_whenRemoved_findsDifference() {
        // given files mocks

        // when compare
        Result result = compare(MOCK_BASELINE, MOCK_REMOVED);

        // get results object to summarize differences
        assertEquals(result.getChanged().size(), 0);
        assertEquals(result.getAdded().size(), 0);
        assertEquals(result.getRemoved().size(), 1);
    }

    @Test
    public void givenMock_whenVarious_findsDifference() {
        // given files mocks

        // when compare
        Result result = compare(MOCK_BASELINE, MOCK_VARIOUS);

        // get results object to summarize differences
        assertEquals(result.getChanged().size(), 1);
        assertEquals(result.getAdded().size(), 1);
        assertEquals(result.getRemoved().size(), 1);
    }

}

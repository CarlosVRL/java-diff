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

    @Test
    public void givenMock_whenChanged_findsDifference() {
        // given files mocks

        // when compare
        Result result = compare(MOCK_1, MOCK_2);

        // get results object to summarize differences
        assertTrue(result.getChanged().size() > 0);
    }
}

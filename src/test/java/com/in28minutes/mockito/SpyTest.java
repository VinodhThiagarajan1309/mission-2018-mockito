package com.in28minutes.mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 * Created by vthiagarajan on 1/24/18.
 */
public class SpyTest {

    @Test
    public void test () {
        List arrayListMock = mock(ArrayList.class);
        assertEquals(0,arrayListMock.size());
        when(arrayListMock.size()).thenReturn(5);
    }

    @Test
    public void testSpy () {
        List arrayListMock = spy(ArrayList.class);

        //when(arrayListMock.size()).thenReturn(5);
        arrayListMock.add("6");
        arrayListMock.add("6");
        arrayListMock.add("6");
        arrayListMock.add("6");
        assertEquals(4,arrayListMock.size());
    }
}

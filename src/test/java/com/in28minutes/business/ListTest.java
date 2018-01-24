package com.in28minutes.business;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.mockito.BDDMockito;

import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.is;

/**
 * Created by vthiagarajan on 1/19/18.
 */
public class ListTest {

    @Test
    public void letsMockListSizeMethod() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2);

        assertEquals(2,listMock.size());

    }

    /**
     * In case you want to assign values for the sub sequent calls
     */
    @Test
    public void letsMockListSizeMethod_ReturnMultipleValues() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3);

        assertEquals(2,listMock.size());
        assertEquals(3,listMock.size());

    }

    @Test
    public void letsMockListGetMethod() {
        List listMock = mock(List.class);
        when(listMock.get(anyInt())).thenReturn(11.09);

        assertEquals(11.09,listMock.get(0));
        assertEquals(11.09,listMock.get(1));

    }

    /**
     * When using matchers always use all params as matchers this below test will PASS
     * because it failed with
     * org.mockito.exceptions.misusing.InvalidUseOfMatchersException:
     Invalid use of argument matchers! but passes as we have caught it
     */
    @Test(expected = RuntimeException.class)
    public void letsMockListGetMethod_throwAnException() {
        List listMock = mock(List.class);
        when(listMock.subList(anyInt(),-1)).thenReturn(Arrays.asList(11.09));

        assertEquals(11.09,listMock.get(0));
        assertEquals(11.09,listMock.get(1));

    }

    @Test
    public void letsMockListGetMethodBDD() {
        //Given
        List listMock = mock(List.class);
        BDDMockito.given(listMock.get(anyInt())).willReturn("11.09");

        assertThat(listMock.get(0).toString(), is("11.09"));
        assertEquals(11.09,listMock.get(1));

    }
}

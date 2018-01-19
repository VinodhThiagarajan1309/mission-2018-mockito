package com.in28minutes.business;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by vthiagarajan on 1/19/18.
 */
public class ListTest {

    @Test
    public void letsMockListSizeMethod() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2);

        Assert.assertEquals(2,listMock.size());

    }
}

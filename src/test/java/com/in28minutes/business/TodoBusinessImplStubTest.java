package com.in28minutes.business;

import org.junit.Test;

import com.in28minutes.data.api.TodoService;
import com.in28minutes.mockito.TodoServiceStub;

import static org.junit.Assert.*;

/**
 * Created by vthiagarajan on 1/19/18.
 */
public class TodoBusinessImplStubTest {

    @Test
    public void testRetrieveTodosRelatedToSpring_usingAStub() {

        TodoService todoService = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
        assertEquals(2,todoBusinessImpl.retrieveTodosRelatedToSpring("someuser").size());

    }
}
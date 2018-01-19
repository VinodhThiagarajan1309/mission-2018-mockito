package com.in28minutes.business;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.in28minutes.data.api.TodoService;
import com.in28minutes.mockito.TodoServiceStub;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
import static org.junit.Assert.assertEquals;

/**
 * Created by vthiagarajan on 1/19/18.
 */
public class TodoBusinessImplMockTest {

    @Test
    public void testRetrieveTodosRelatedToSpring_usingAMock() {

        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC","Learn Spring", "Learn to Dance");
        when(todoServiceMock.retrieveTodos("DUMMY")).thenReturn(todos);
        // stub(todoServiceMock.retrieveTodos("DUMMY")).toReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("DUMMY");
        assertEquals(2,filteredTodos.size());

    }
}
package com.in28minutes.business;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.in28minutes.data.api.TodoService;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by vthiagarajan on 1/19/18.
 */
public class TodoBusinessImplMockTest {

    @Test
    public void testRetrieveTodosRelatedToSpring_usingAMock() {

        TodoService todoServiceMock = mock(TodoService.class);
        when(todoServiceMock.retrieveTodos("DUMMY")).thenReturn(Arrays.asList("Learn Spring MVC",
            "Learn Spring", "Learn to Dance"));
        //stub(todoServiceMock.retrieveTodos("DUMMY")).toReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("DUMMY");
        assertEquals(2,filteredTodos.size());

    }

    @Test
    public void testRetrieveTodosRelatedToSpring_usingAMockBDD() {

        // Given
        TodoService todoServiceMock = mock(TodoService.class);
        given(todoServiceMock.retrieveTodos("DUMMY")).willReturn(Arrays.asList("Learn Spring MVC",
            "Learn Spring", "Learn to Dance"));
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        // When
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("DUMMY");
        // Then
        assertThat(filteredTodos.size(), is(2));
    }

    @Test
    public void testDeleteTodosNotRelatedToSpring_usingAMockBDD() {

        // Given
        TodoService todoServiceMock = mock(TodoService.class);
        given(todoServiceMock.retrieveTodos("DUMMY")).willReturn(Arrays.asList("Learn Spring MVC",
            "Learn Spring", "Learn to Dance", "Tackle"));
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        // When
        todoBusinessImpl.deleteTodosNotRelatedToSpring("DUMMY");

        // Then
        verify(todoServiceMock).deleteTodos("Learn to Dance");
        then(todoServiceMock).should().deleteTodos("Learn to Dance");

        verify(todoServiceMock,atLeastOnce()).deleteTodos("Learn to Dance");
        then(todoServiceMock).should(atLeastOnce()).deleteTodos("Learn to Dance");

        verify(todoServiceMock, times(1)).deleteTodos("Learn to Dance");
        then(todoServiceMock).should(times(1)).deleteTodos("Learn to Dance");

        verify(todoServiceMock, never()).deleteTodos("Learn Spring");
        then(todoServiceMock).should(never()).deleteTodos("Learn Spring");
        //assertThat(filteredTodos.size(), is(2));
    }

    @Test
    public void testDeleteTodosNotRelatedToSpring_usingAMockBDDArgumentCapturing() {

        // Declare Argument Captor
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

        // Given
        TodoService todoServiceMock = mock(TodoService.class);
        given(todoServiceMock.retrieveTodos("DUMMY")).willReturn(Arrays.asList("Learn Spring MVC",
            "Learn Spring", "Learn to Dance", "Tackle"));
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        // When
        todoBusinessImpl.deleteTodosNotRelatedToSpring("DUMMY");

        // Then
        then(todoServiceMock).should().deleteTodos(stringArgumentCaptor.capture());

        assertThat(stringArgumentCaptor.getValue(), is("Learn to Dance"));


    }

    @Test
    public void testDeleteTodosNotRelatedToSpring_usingAMockBDDArgumentCapturingMultiple() {

        // Declare Argument Captor
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

        // Given
        TodoService todoServiceMock = mock(TodoService.class);
        given(todoServiceMock.retrieveTodos("DUMMY")).willReturn(Arrays.asList("Learn to Rock and Roll",
            "Learn Spring", "Learn to Dance", "Tackle"));
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        // When
        todoBusinessImpl.deleteTodosNotRelatedToSpring("DUMMY");

        // Then
        then(todoServiceMock).should(atLeastOnce()).deleteTodos(stringArgumentCaptor.capture());

        assertThat(stringArgumentCaptor.getAllValues().size(), is(3));


    }
}
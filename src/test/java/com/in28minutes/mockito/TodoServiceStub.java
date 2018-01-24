package com.in28minutes.mockito;

import java.util.Arrays;
import java.util.List;

import com.in28minutes.data.api.TodoService;

/**
 * Created by vthiagarajan on 1/19/18.
 */
public class TodoServiceStub implements TodoService {

    public List<String> retrieveTodos(String user) {
        return Arrays.asList("Learn Spring MVC","Learn Spring", "Learn to Dance");
    }

    public void deleteTodos(String todo) {

    }
}

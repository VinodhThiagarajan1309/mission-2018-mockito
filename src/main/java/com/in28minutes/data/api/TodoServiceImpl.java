package com.in28minutes.data.api;

import java.util.Arrays;
import java.util.List;

/**
 * Created by vthiagarajan on 1/19/18.
 */
public class TodoServiceImpl implements TodoService {

    public List<String> retrieveTodos(String user) {
        return Arrays.asList("1","2","Spring3","4","Spring");
    }

    public void deleteTodos(String todo) {

    }
}

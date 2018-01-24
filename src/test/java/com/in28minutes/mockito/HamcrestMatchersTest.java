package com.in28minutes.mockito;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

import static org.hamcrest.Matchers.hasSize;
import org.junit.Test;

/**
 * Created by vthiagarajan on 1/24/18.
 */
public class HamcrestMatchersTest {

    @Test
    public void test(){
        List<Integer> scores = Arrays.asList(99,100,101,105);
        assertThat(scores, hasSize(4));
        assertThat(scores, hasItems(99,101));

        assertThat(scores, everyItem(greaterThan(90)));
        assertThat(scores, everyItem(lessThan(190)));

        // String Asserts
        assertThat("", isEmptyString());
        assertThat(null, isEmptyOrNullString());

        // Array Asserts
        Integer[] marks = {1,2,3};
        assertThat(marks, arrayWithSize(3));
        assertThat(marks, arrayContaining(1,2,3));
        assertThat(marks, arrayContainingInAnyOrder(2,1,3));



    }
}

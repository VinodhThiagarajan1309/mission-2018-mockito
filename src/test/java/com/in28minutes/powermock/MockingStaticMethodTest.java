package com.in28minutes.powermock;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.in28minutes.business.TodoBusinessImpl;
import com.in28minutes.data.api.TodoService;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by vthiagarajan on 1/19/18.
 */
@RunWith(PowerMockRunner.class) //----------------------------------------****************** - STEP 1
@PrepareForTest(UtilityClass.class) //----------------------------------------****************** - STEP 2
public class MockingStaticMethodTest {

    // Either use RunWith or this line. Prefer this. This is called Before and After tests
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    Dependency dependency;

    @InjectMocks
    SystemUnderTest systemUnderTest;


    @Test
    public void testRetrieveTodosRelatedToSpring_usingAMock() {

        //TodoService todoServiceMock = mock(TodoService.class);
        when(dependency.retrieveAllStats()).thenReturn(Arrays.asList(1,2,3,4));

        PowerMockito.mockStatic(UtilityClass.class); //----------------------------------------****************** - STEP 3

        when(UtilityClass.staticMethod(10)).thenReturn(150);

        //stub(todoServiceMock.retrieveTodos("DUMMY")).toReturn(todos);
        //TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        int staticReturnInt = systemUnderTest.methodCallingAStaticMethod();
        assertEquals(150,staticReturnInt);

        PowerMockito.verifyStatic(times(1)); //-------------------------******* - Use this call before verifying
        UtilityClass.staticMethod(10);


    }
}
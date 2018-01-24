package com.in28minutes.powermock;

import java.util.Arrays;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

/**
 * Created by vthiagarajan on 1/19/18.
 */
@RunWith(PowerMockRunner.class) //----------------------------------------****************** - STEP 1
public class InvokingPrivateMethodTest {

    // Either use RunWith or this line. Prefer this. This is called Before and After tests
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    Dependency dependency;

    @InjectMocks
    SystemUnderTest systemUnderTest;


    @Test
    public void testRetrieveTodosRelatedToSpring_usingAMock() throws Exception {

        //TodoService todoServiceMock = mock(TodoService.class);
        when(dependency.retrieveAllStats()).thenReturn(Arrays.asList(1,2,3,4,23));

        //stub(todoServiceMock.retrieveTodos("DUMMY")).toReturn(todos);
        //TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        //int staticReturnInt = systemUnderTest.methodCallingAStaticMethod();

        long result = Whitebox.invokeMethod(systemUnderTest,"privateMethodUnderTest");

        assertEquals(33,result);




    }
}
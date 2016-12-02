package com.example.kerengold.mainmanu;

import static org.junit.Assert.*;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Created by KerenGold on 12/2/16.
 */
public class layout3_1Test {

    @RunWith(AndroidJUnit4.class)
    public class ExampleInstrumentedTest {
        @Test
        public void useAppContext() throws Exception {
            // Context of the app under test.
            Context appContext = InstrumentationRegistry.getTargetContext();

            assertEquals("com.example.kerengold.mainManu", appContext.getPackageName());
        }
    }
}


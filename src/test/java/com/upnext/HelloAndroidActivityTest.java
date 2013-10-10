package com.upnext;

import android.os.Bundle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;


@RunWith(RobolectricTestRunner.class)
public class HelloAndroidActivityTest {


    @Test
    public void hello(){
        HelloAndroidActivity helloAndroidActivity = Robolectric.buildActivity(HelloAndroidActivity.class).create().get();

        assertEquals(".HelloApplication", helloAndroidActivity.hello.getText());
    }

}


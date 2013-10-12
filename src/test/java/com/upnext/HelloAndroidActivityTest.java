package com.upnext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;


@RunWith(RobolectricTestRunner.class)
public class HelloAndroidActivityTest {


    @Test
    public void hello() {
        HelloAndroidActivity helloAndroidActivity = Robolectric.buildActivity(HelloAndroidActivity.class).create().get();

        assertEquals(".HelloApplication", helloAndroidActivity.hello.getText());
    }

    @Test
    @Config(shadows = ShadowTask.class)
    public void web() {
        Robolectric.addHttpResponseRule("http://files.mobile.up-next.com/list.json", "test");

        HelloAndroidActivity helloAndroidActivity = Robolectric.buildActivity(HelloAndroidActivity.class).create().get();

        assertEquals(".HelloApplication", helloAndroidActivity.hello.getText());
    }

}


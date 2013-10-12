package com.upnext;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowTextView;

import javax.inject.Inject;

import static junit.framework.Assert.assertEquals;


@RunWith(RobolectricTestRunner.class)
public class HelloAndroidActivityTest {

//    @Inject
//    ExecutorInterface executorInterface;

    @Before
    public void before(){
       HelloApplication.add(new RootModule(), new TestModule());
    }

    @Test
    public void hello() {
        HelloAndroidActivity helloAndroidActivity = Robolectric.buildActivity(HelloAndroidActivity.class).create().get();

        assertEquals(".HelloApplication", helloAndroidActivity.hello.getText());
        ShadowTextView shadowTextView = Robolectric.shadowOf(helloAndroidActivity.hello);
        shadowTextView.dump();
    }

    @Test
    public void web() {
        Robolectric.addHttpResponseRule("http://files.mobile.up-next.com/list.json", "test");

        HelloAndroidActivity helloAndroidActivity = Robolectric.buildActivity(HelloAndroidActivity.class).create().get();

        assertEquals(".HelloApplication", helloAndroidActivity.hello.getText());
    }

}


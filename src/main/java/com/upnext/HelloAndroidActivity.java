package com.upnext;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import butterknife.InjectView;
import butterknife.Views;

import javax.inject.Inject;

public class HelloAndroidActivity extends Activity {

    private static String TAG = "robolectric";
    @InjectView(R.id.hello)
    TextView hello;
    @Inject
    ApplicationInfo applicationInfo;

    /**
     * Called when the activity is first created.
     *
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
     */
    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        setContentView(R.layout.main);
        Injector.inject(this);
        Views.inject(this);
        hello.setText(applicationInfo.name);

        WebTask webTask = new WebTask("http://files.mobile.up-next.com/list.json", hello);

        webTask.execute();
    }

}


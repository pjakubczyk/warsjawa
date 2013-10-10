package com.upnext;

import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;

import static android.os.Build.VERSION.SDK_INT;
import static android.os.Build.VERSION_CODES.FROYO;

/**
 * Created with IntelliJ IDEA.
 * User: przemek
 * Date: 10/10/13
 * Time: 7:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class HelloApplication extends Application {

    private static HelloApplication instance;

    /**
     * Create main application
     */
    public HelloApplication() {


    }

    /**
     * Create main application
     *
     * @param context
     */
    public HelloApplication(final Context context) {
        this();
        attachBaseContext(context);

    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        // Perform injection
        Injector.init(getRootModule(), this);

    }

    private Object getRootModule() {
        return new RootModule();
    }


    /**
     * Create main application
     *
     * @param instrumentation
     */
    public HelloApplication(final Instrumentation instrumentation) {
        this();
        attachBaseContext(instrumentation.getTargetContext());
    }

    public static HelloApplication getInstance() {
        return instance;
    }
}

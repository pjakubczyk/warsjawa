package com.upnext;

import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;
import dagger.ObjectGraph;

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
    private static ObjectGraph objectGraph;

    /**
     * Create main application
     */
    public HelloApplication() {


    }


    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
        objectGraph = ObjectGraph.create(getRootModule());
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

    public static void add(Object... object){
        objectGraph = ObjectGraph.create(object)   ;
    }

    public static void inject(Object target){
        objectGraph.inject(target);
    }
}

package com.upnext;

import dagger.Module;

/**
 * Add all the other modules to this one.
 */
@Module
(
    includes = {
            AndroidModule.class,
            ExecModule.class
    },
    injects = {
            HelloAndroidActivity.class,
            HelloApplication.class
    }

)
public class RootModule {
}

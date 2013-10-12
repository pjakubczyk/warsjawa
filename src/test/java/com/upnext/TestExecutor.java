package com.upnext;

import android.util.Log;

/**
 * Created with IntelliJ IDEA.
 * User: przemek
 * Date: 10/12/13
 * Time: 11:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestExecutor implements ExecutorInterface{
    @Override
    public void execute(WebTask webTask) {
        Log.d("Ddd", "dd");
    }
}

package com.upnext;

/**
 * Created with IntelliJ IDEA.
 * User: przemek
 * Date: 10/12/13
 * Time: 10:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class ExecutorImpl implements ExecutorInterface {
    @Override
    public void execute(WebTask webTask) {
        webTask.execute();
    }
}

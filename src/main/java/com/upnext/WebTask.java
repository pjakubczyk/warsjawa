package com.upnext;

import android.widget.TextView;
import com.upnext.utils.SafeAsyncTask;
import com.upnext.utils.Utils;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created with IntelliJ IDEA.
 * User: przemek
 * Date: 10/11/13
 * Time: 9:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class WebTask extends SafeAsyncTask<String> {

    String url;
    private TextView textView;

    public WebTask(String url, TextView textView) {
        this.url = url;
        this.textView = textView;
    }

    @Override
    public String call() throws Exception {
        URL url = new URL(this.url);
        URLConnection urlConnection = url.openConnection();
        InputStream in = new BufferedInputStream(urlConnection.getInputStream());
        try {
            return Utils.readAsString(in);
        } finally {
            Utils.close(in);
        }
    }

    @Override
    protected void onSuccess(String s) throws Exception {
        super.onSuccess(s);    //To change body of overridden methods use File | Settings | File Templates.
        textView.setText(s);
    }
}

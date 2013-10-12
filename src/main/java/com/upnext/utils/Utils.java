package com.upnext.utils;

import java.io.*;
import java.net.HttpURLConnection;

/**
 * Created with IntelliJ IDEA.
 * User: przemek
 * Date: 10/11/13
 * Time: 9:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class Utils {

    public static boolean close(final OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
                return true;
            } catch (final IOException e) {
                return false;
            }
        }
        return false;
    }

    public static boolean close(final InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
                return true;
            } catch (final IOException e) {
                return false;
            }
        }
        return false;
    }

    public static boolean close(final Reader reader) {
        if (reader != null) {
            try {
                reader.close();
                return true;
            } catch (final IOException e) {
                return false;
            }
        }
        return false;
    }

    public static boolean close(final HttpURLConnection connection) {
        if (connection != null) {
            connection.disconnect();
            return true;
        }
        return false;
    }

    public static byte[] readAsByteArray(final InputStream is) throws IOException {
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();

            final byte[] buffer = new byte[1024];
            int numRead = 0;

            while ((numRead = is.read(buffer)) != -1) {
                baos.write(buffer, 0, numRead);
            }

            return baos.toByteArray();
        } finally {
            close(baos);
        }
    }

    public static String readAsString(final InputStream is) throws IOException {
        return new String(readAsByteArray(is));
    }

    public static void write(InputStream is, OutputStream os) throws IOException {
        byte[] buffer = new byte[1024]; //optimize the size of buffer to your need
        int num;
        while((num = is.read(buffer)) != -1){
            os.write(buffer, 0, num);
        }
    }
}

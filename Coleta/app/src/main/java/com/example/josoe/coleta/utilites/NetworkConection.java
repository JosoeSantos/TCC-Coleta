package com.example.josoe.coleta.utilites;

import android.content.Context;
import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NetworkConection {
    public static URL buildQueryUrl(String urlBase, String[] paths, String[] paramsNames, String[] paramsContent) {
        if (urlBase != null && !urlBase.equals("")) {
            Uri.Builder uri = Uri.parse(urlBase).buildUpon();
            if (paths != null) {
                for (String path : paths) {
                    uri.appendPath(path);
                }
            }
            if (paramsNames != null && paramsContent != null) {
                if (paramsNames.length == paramsContent.length) {
                    for (int i = 0; i < paramsNames.length; i++) {
                        uri.appendQueryParameter(paramsNames[i], paramsContent[i]);
                    }
                }
            }
            URL url = null;
            try {
                url = new URL(uri.toString());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return url;
        }
        return null;
    }

    /**
     * This method returns the entire result from the HTTP response.
     *
     * @param url The URL to fetch the HTTP response from.
     * @return The contents of the HTTP response.
     * @throws IOException Related to network and stream reading
     */
    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();
            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");
            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }
}

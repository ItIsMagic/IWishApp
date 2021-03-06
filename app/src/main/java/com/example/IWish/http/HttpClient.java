package com.example.IWish.http;

import android.os.AsyncTask;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class HttpClient {

    public HttpClient() {
    }

    public AsyncTask<String, Void, String> get(String url) {
        HttpGetRequest getRequest = new HttpGetRequest();
        return getRequest.exec(url);
    }

    public AsyncTask<String, Void, String> post(String url, Map<String, String> data) throws UnsupportedEncodingException {
        HttpPostRequest postRequest = new HttpPostRequest();
        return postRequest.exec(url, data);
    }

    public AsyncTask<String, Void, String> delete(String url) {
        HttpDeleteRequest deleteRequest = new HttpDeleteRequest();
        return deleteRequest.exec(url);
    }

    public AsyncTask<String, Void, String> patch(String url, Map<String, String> data) throws UnsupportedEncodingException {
        HttpPatchRequest patchRequest = new HttpPatchRequest();
        return patchRequest.exec(url, data);
    }

    public AsyncTask<String, Void, String> put(String url) {
        HttpPutRequest putRequest = new HttpPutRequest();
        return putRequest.exec(url);
    }
}

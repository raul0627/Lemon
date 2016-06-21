package com.hexin.Netty.Http.Client;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/2/15.
 */
public class HttpClient {
    private static String url = "http://127.0.0.1:9900";
    public static void main(String[] args) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("key111", "value111111"));
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params, Consts.UTF_8);
        httpPost.setEntity(formEntity);
        try {
            CloseableHttpResponse response = client.execute(httpPost);
            int statCode = response.getStatusLine().getStatusCode();
            if (statCode != 200) {
                System.out.println("statCode is " + statCode);
            } else {
                HttpEntity entity = response.getEntity();
                long len = entity.getContentLength();
                entity = new BufferedHttpEntity(entity);
                boolean isChunked = entity.isChunked();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

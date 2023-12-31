package com.example.feature;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Slf4j
public class URLConnection {

    public static void main(String[] args) {
        try {
            var url = new URL("https://jsonplaceholder.typicode.com/posts/");
            var connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            log.info("> Request");

            var response = new StringBuffer();

            try (var ins = connection.getInputStream()) {
                response.append(new String(ins.readAllBytes()));
            } finally {
                connection.disconnect();
            }

            log.info("{} < Response", response);

        } catch (MalformedURLException mfe) {
            log.info("URl is malformed", mfe);
        } catch (IOException e) {
            log.info("No connection", e);
            throw new RuntimeException(e);
        }
    }

}

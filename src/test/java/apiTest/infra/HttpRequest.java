package apiTest.infra;

import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HttpRequest {
    private String method;
    private String url;
    private Map<String, String> headers;
    private String body;

    private HttpRequest(String method, String url, Map<String, String> headers, String body) {
        this.method = method;
        this.url = url;
        this.headers = headers;
        this.body = body;
    }

    public static HttpRequest fromUrl(String url) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "text/html");

        return new HttpRequest("GET", url, headers, null);
    }

    public static <T> HttpResponse<T> get(String url, Map<String, String> headers,
                                          Map<String, String> queryParams ,Class<T> clz) throws IOException {
        // set query parameters
        if (queryParams != null) {
            String queryString = queryParams.entrySet().stream().map(entry -> entry.getKey() + "=" + entry.getValue()).collect(Collectors.joining("&"));
            url += "?" + queryString;
        }
        // create connection
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");
        // set headers
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                connection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        // send request and handle response
        int status = connection.getResponseCode();
        String body = new String(connection.getInputStream().readAllBytes());


        HttpResponse test2 = new HttpResponse<>();
        T d2;
        d2 = new Gson().fromJson(body, clz);

        test2.setData(d2);
        test2.setStatus(status);

        Map<String, String> responseHeaders = connection.getHeaderFields().entrySet().stream().filter(entry -> entry.getKey() != null).collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().get(0)));
        return test2;
    }
    // similar functions for other HTTP methods

    public static HttpResponse post(String url, Map<String, String> headers, String body) throws IOException {
        // create connection
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        // set headers
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            connection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        // send request body
        OutputStream os = connection.getOutputStream();
        os.write(body.getBytes());
        os.flush();
        os.close();
        // handle response
        int status = connection.getResponseCode();
        String responseBody = "";
        if (status >= 200 && status < 300) {
            responseBody = new String(connection.getInputStream().readAllBytes());
        } else {
            responseBody = new String(connection.getErrorStream().readAllBytes());
        }

        Map<String, String> responseHeaders = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : connection.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                responseHeaders.put(entry.getKey(), entry.getValue().get(0));
            }
        }
        return new HttpResponse(status, responseHeaders, responseBody);
    }

    public static HttpResponse put(String url, Map<String, String> headers, String body) throws IOException {
        // Similar to post, but set the request method to PUT
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("PUT");
        connection.setDoOutput(true);
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            connection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        // send request body
        OutputStream os = connection.getOutputStream();
        os.write(body.getBytes());
        os.flush();
        os.close();
        // handle response
        int status = connection.getResponseCode();
        String responseBody = "";
        if (status >= 200 && status < 300) {
            responseBody = new String(connection.getInputStream().readAllBytes());
        } else {
            responseBody = new String(connection.getErrorStream().readAllBytes());
        }

        Map<String, String> responseHeaders = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : connection.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                responseHeaders.put(entry.getKey(), entry.getValue().get(0));
            }
        }

        return new HttpResponse(status, responseHeaders, responseBody);
    }

    public static HttpResponse patch(String url, Map<String, String> headers, String body) throws IOException {
        // Similar to post, but set the request method to PATCH
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("PATCH");
        connection.setDoOutput(true);

        for (Map.Entry<String, String> entry : headers.entrySet()) {
            connection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        // send request body
        OutputStream os = connection.getOutputStream();
        os.write(body.getBytes());
        os.flush();
        os.close();
        // handle response
        int status = connection.getResponseCode();
        String responseBody = "";
        if (status >= 200 && status < 300) {
            responseBody = new String(connection.getInputStream().readAllBytes());
        } else {
            responseBody = new String(connection.getErrorStream().readAllBytes());
        }

        Map<String, String> responseHeaders = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : connection.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                responseHeaders.put(entry.getKey(), entry.getValue().get(0));
            }
        }
        return new HttpResponse(status, responseHeaders, responseBody);
    }

    public static HttpResponse delete(String url, Map<String, String> headers, String body) throws IOException {
        // Similar to post, but set the request method to DELETE
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("DELETE");
        connection.setDoOutput(true);

        for (Map.Entry<String, String> entry : headers.entrySet()) {
            connection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        // send request body
        OutputStream os = connection.getOutputStream();
        os.write(body.getBytes());
        os.flush();
        os.close();
        // handle response
        int status = connection.getResponseCode();
        String responseBody = "";
        if (status >= 200 && status < 300) {
            responseBody = new String(connection.getInputStream().readAllBytes());
        } else {
            responseBody = new String(connection.getErrorStream().readAllBytes());
        }

        Map<String, String> responseHeaders = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : connection.getHeaderFields().entrySet()) {
            if (entry.getKey() != null) {
                responseHeaders.put(entry.getKey(), entry.getValue().get(0));
            }
        }

        return new HttpResponse(status, responseHeaders, responseBody);
    }

    // Helper method to convert InputStream to String
    private static String inputStreamToString(InputStream inputStream) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            StringBuilder responseContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }
            return responseContent.toString();
        }
    }
}




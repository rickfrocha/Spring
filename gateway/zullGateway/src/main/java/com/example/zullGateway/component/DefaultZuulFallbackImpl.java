package com.example.zullGateway.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ricardo on 29/12/17.
 */
@Component
public class DefaultZuulFallbackImpl implements FallbackProvider {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public ClientHttpResponse fallbackResponse(Throwable cause) {
        logger.error("Fallback error, msg="+ cause.getMessage(), cause);
        return fallbackResponse();
    }

    @Override
    public String getRoute() {
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {

            private  HttpStatus statusToReturn = HttpStatus.SERVICE_UNAVAILABLE;

            private String msgToReturn = "Service Unavaliable";

            @Override
            public HttpStatus getStatusCode() throws IOException {
                return statusToReturn;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return statusToReturn.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return msgToReturn;
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream(msgToReturn.getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.TEXT_PLAIN);
                return headers;
            }
        };
    }
}

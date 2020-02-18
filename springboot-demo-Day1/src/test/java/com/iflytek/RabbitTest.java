package com.iflytek;

import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.protocol.HttpContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.iflytek.compnent.RoncooAmqpComponent;
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class RabbitTest {
	@Autowired
	private RoncooAmqpComponent roncooAmqpComponent;
	@Autowired
    private RestTemplateBuilder restTemplateBuilder;
	@Test
	public void send() {
		roncooAmqpComponent.send("hello world2");
	}
	/**
     * get请求
     */
    @Test
    public void getForObject() {

        String result = restTemplateBuilder.additionalCustomizers(new ProxyCustomizer()).build().getForObject("https://www.roncoo.com/", String.class);
        System.out.println(result);

    }
    static class ProxyCustomizer implements RestTemplateCustomizer {
        @Override
        public void customize(RestTemplate restTemplate) {
            String proxyHost = "159.65.87.167";
            int proxyPort = 8080;

            HttpHost proxy = new HttpHost(proxyHost, proxyPort);
            HttpClient httpClient = HttpClientBuilder.create().setRoutePlanner(new DefaultProxyRoutePlanner(proxy) {
                @Override
                public HttpHost determineProxy(HttpHost target, HttpRequest request, HttpContext context)
                        throws HttpException {
                    System.out.println(target.getHostName());
                    return super.determineProxy(target, request, context);
                }
            }).build();
            HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
                    httpClient);
            httpComponentsClientHttpRequestFactory.setConnectTimeout(10000);
            httpComponentsClientHttpRequestFactory.setReadTimeout(60000);
            restTemplate.setRequestFactory(httpComponentsClientHttpRequestFactory);
        }
    }
}

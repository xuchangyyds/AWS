package com.aws.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Origami
 * @description
 * @create 2025-07-09 15:45
 **/
@Component
@Slf4j
public class WeatherUtil {

    @Value("${jwt.weather.url}")
    private String url;

    /**
     * 请求和风天气 - 实时天气
     *
     * @param token    外部传入的 token
     * @param location 地理位置编码或坐标
     * @return 返回和风天气 now 接口的 JSON 对象
     */
    public JSONObject getNowWeather(String token, String location) {
        // 构造 URL
        location = String.valueOf(101010100);
        String fullUrl = String.format("https://%s/v7/weather/now?location=%s", url, location);

        // 创建请求
        HttpGet request = new HttpGet(fullUrl);
        request.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token);
        request.setHeader(HttpHeaders.ACCEPT_ENCODING, "gzip");

        log.info("request url: {}",request);

        // 使用 HttpClient 发起请求
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(request)) {

            if (response.getStatusLine().getStatusCode() != 200) {
                log.warn("和风天气请求失败，状态码: {}", response.getStatusLine().getStatusCode());
                return null;
            }

            String json = EntityUtils.toString(response.getEntity(), "UTF-8");
            return JSON.parseObject(json);

        } catch (Exception e) {
            log.error("请求和风天气异常", e);
            return null;
        }
    }
}
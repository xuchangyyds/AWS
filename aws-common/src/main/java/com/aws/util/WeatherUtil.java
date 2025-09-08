package com.aws.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aws.vo.RegionEnvVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.Date;

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
     * @param regionCode 地理位置编码或坐标
     * @return 返回和风天气 now 接口的 JSON 对象
     */
    public JSONObject getNowWeather(String token, String regionCode) {
        // 构造 URL
        String fullUrl = String.format("https://%s/v7/weather/now?location=%s", url, regionCode);

        // 创建请求
        HttpGet request = new HttpGet(fullUrl);
        request.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token);
        request.setHeader(HttpHeaders.ACCEPT_ENCODING, "gzip");

        log.info("request url: {}", request);

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

    /**
     * @param id 区域ID
     * @param nowWeather
     * @return
     */
    public RegionEnvVO apiToRegionEnvVO(Long id,JSONObject nowWeather) {
        return RegionEnvVO.builder()
                .regionId(id)
                .recordTime(convertToDate(nowWeather.getString("updateTime")))
                .weatherDesc(nowWeather.getJSONObject("now").getString("text"))
                .temperature(nowWeather.getJSONObject("now").getDouble("temp"))
                .humidity(nowWeather.getJSONObject("now").getDouble("humidity"))
                .pressure(nowWeather.getJSONObject("now").getDouble("pressure"))
                .windSpeed(nowWeather.getJSONObject("now").getDouble("windSpeed"))
                .windDirection(nowWeather.getJSONObject("now").getString("windDir"))
                .visibility(nowWeather.getJSONObject("now").getDouble("vis"))
                .build();
    }

    private Date convertToDate(String apiTime) {
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(apiTime);
        return Date.from(offsetDateTime.toInstant());
    }

}
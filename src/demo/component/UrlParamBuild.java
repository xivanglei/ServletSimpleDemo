package demo.component;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:xianglei
 * Date: 2019-12-24 09:24
 * Description:get参数创建
 */
public class UrlParamBuild {

    private String mBaseUrl;
    private Map<String, String> mParams;

    private UrlParamBuild(String baseUrl) {
        mBaseUrl = baseUrl;
        mParams = new HashMap<>();
    }

    public static UrlParamBuild instance(String baseUrl) {
        return new UrlParamBuild(baseUrl);
    }

    public UrlParamBuild addParam(String key, String value) {
        mParams.put(key, value);
        return this;
    }

    public String toUrl() {
        if(mParams.size() == 0) return mBaseUrl;
        StringBuilder url = new StringBuilder(mBaseUrl);
        url.append("?");
        for(String key : mParams.keySet()) {
            url.append(key);
            url.append("=");
            url.append(mParams.get(key));
            url.append("&");
        }
        return url.substring(0, url.length() - 1);
    }
}

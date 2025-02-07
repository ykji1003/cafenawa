package com.cafenawa.common.helper;

import com.cafenawa.common.util.PropertyUtil;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;

public class PropertyHelper {
    private static Map<String, String> props;

    @Value("spring.profiles.active")
    private static String profileActiveName;

    public static String getProfileActiveName() {
        return profileActiveName;
    }

    static {
        try {
            props = PropertyUtil.getPropertiesAsMap(getSystemPropertyFile());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    /**
     * Key에 해당하는 시스템 변수를 가져온다.
     *
     * @param key String
     * @return props
     */
    public static String getProperty(String key) {
        return props.get(key);
    }

    /**
     * 실행 환경에 따른 properties 파일 선택
     * @return property
     */
    public static String getSystemPropertyFile() {
        String profileActiveName = getProfileActiveName();

                "application-" + profileActiveName + ".yml"



        return property;
    }

}

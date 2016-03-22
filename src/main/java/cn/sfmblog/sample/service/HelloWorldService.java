package cn.sfmblog.sample.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

/**
 * Hello World Service
 * Created by NikSun on 2016/3/22.
 */

@Service
public class HelloWorldService {
    private static final Log log = LogFactory.getLog(HelloWorldService.class);

    public String getDesc() {
        log.debug("getDesc() is executed!");
        return "Gradle + Spring MVC Hello World Example";
    }

    public String getTitle(String name) {
        log.debug("getTitle() is executed! $name: " + name);

        if (StringUtils.isEmpty(name)) {
            return "Hello World";
        } else {
            return "Hello " + name;
        }
    }

    public String getTitle() {
        log.debug("getTitle() is executed!");
        return "Hello World";
    }
}

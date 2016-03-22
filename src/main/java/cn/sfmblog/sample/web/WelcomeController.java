package cn.sfmblog.sample.web;

import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.sfmblog.sample.service.HelloWorldService;

/**
 * Welcome controller
 * Created by NikSun on 2016/3/22.
 */
@Controller
public class WelcomeController {
    private static final Log log = LogFactory.getLog(WelcomeController.class);
    private final HelloWorldService helloWorldService;

    @Autowired
    public WelcomeController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Map<String, Object> model) {
        log.debug("index() is executed!");
        model.put("title", helloWorldService.getTitle());
        model.put("msg", helloWorldService.getDesc());
        return "index";
    }

    @RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
    public ModelAndView hello(@PathVariable("name") String name) {
        log.debug("hello() is executed! $name: " + name);
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        model.addObject("title", helloWorldService.getTitle(name));
        model.addObject("msg", helloWorldService.getDesc());
        return model;
    }
}

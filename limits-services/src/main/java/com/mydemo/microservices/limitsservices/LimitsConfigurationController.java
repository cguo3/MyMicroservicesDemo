package com.mydemo.microservices.limitsservices;


import com.mydemo.microservices.limitsservices.bean.LimitConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

    Logger logger = LoggerFactory.getLogger(LimitsConfigurationController.class);
    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public LimitConfiguration retrieveLimitsFromConfigurations() {

        logger.info("-----> configuration: " + configuration.toString());
        LimitConfiguration limitConfiguration = new LimitConfiguration(configuration.getMaximum(),
                configuration.getMinimum());
        return limitConfiguration;
    }

//    @GetMapping("/fault-tolerance-example")
//    @HystrixCommand(fallbackMethod="fallbackRetrieveConfiguration")
//    public LimitConfiguration retrieveConfiguration() {
//        throw new RuntimeException("Not available");
//    }
//
//    public LimitConfiguration fallbackRetrieveConfiguration() {
//        return new LimitConfiguration(999, 9);
//    }

}
package com.ms.app.controllers;

import com.ms.app.configs.Configuration;
import com.ms.app.entities.LimitConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitConfigurationController {



	    @Autowired
	    private Configuration config;

	    @GetMapping("/limits")
	    public LimitConfiguration retrieveLimitFromConfiguration(){
	        return new LimitConfiguration(config.getMinimum(), config.getMaximum());
	    }

	    //That action is supported by a fallBack
	    @GetMapping("/fault-tolerance")
		@HystrixCommand(fallbackMethod = "fallBackRetrieveConfiguration")
	    public LimitConfiguration retrieveConfiguration() throws Exception {
	    	throw new Exception("Not available");
		}

		public LimitConfiguration fallBackRetrieveConfiguration() {
			return new LimitConfiguration(3,44);
		}
}

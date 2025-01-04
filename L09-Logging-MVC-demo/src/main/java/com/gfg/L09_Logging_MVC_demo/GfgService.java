package com.gfg.L09_Logging_MVC_demo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "gfg.service", name = "enable", havingValue = "true")
public class GfgService {

    public String getSessionDetails(){
        return "session details";
    }
}

package com.attrabit.wellax_.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
@ConfigurationProperties(prefix="twilio")
@Data
public class TwilioOTPConfig {
    private String accountSid;
    private String authToken;
    private String phoneNumber;
}

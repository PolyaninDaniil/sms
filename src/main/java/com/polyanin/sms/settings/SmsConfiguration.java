package com.polyanin.sms.settings;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class SmsConfiguration {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}



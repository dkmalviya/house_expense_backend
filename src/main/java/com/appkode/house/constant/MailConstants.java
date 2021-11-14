package com.appkode.house.constant;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class MailConstants {

    @Value("${spring.mail.host_address}")
    private String hostAddress;
}

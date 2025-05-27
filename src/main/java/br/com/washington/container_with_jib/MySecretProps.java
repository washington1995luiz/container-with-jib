package br.com.washington.container_with_jib;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@ConfigurationProperties(prefix = "my.secret")
@Component
public class MySecretProps {
    private String serverPort;
    private String value;
    // getters and setters
    public String getServerPort() {
        return serverPort;
    }

    public String getValue() {
        return value;
    }
}

package br.com.washington.container_with_jib;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
public class MySecretProps {
    @Value("${server_port}")
    private String serverPort;
    @Value("${value}")
    private String value;
    // getters and setters
    public String getServerPort() {
        return serverPort;
    }

    public String getValue() {
        return value;
    }

    public void setServerPort(String serverPort) {
        this.serverPort = serverPort;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

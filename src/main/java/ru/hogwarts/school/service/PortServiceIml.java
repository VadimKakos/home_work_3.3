package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class PortServiceIml implements PortService{

    @Value("${server.port}")
    private String port;

    public String getPort() {
        return port;
    }

    @Override
    public String toString() {
        return "PortServiceIml{" +
                "port='" + port + '\'' +
                '}';
    }
}

package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class PortServiceIml implements PortService {
    @Value("${server.port}")
    private String port;

    @Override
    public String getPort() {
        return port;
    }

    private final Logger logger = LoggerFactory.getLogger(PortService.class);

    @Override
    public Integer sum() {
        return IntStream.rangeClosed(1, 1_000_000).sum();
    }

    @Override
    public String toString() {
        return "PortServiceIml{" +
                "port='" + port + '\'' +
                '}';
    }
}

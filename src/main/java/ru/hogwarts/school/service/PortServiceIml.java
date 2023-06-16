package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class PortServiceIml implements PortService {

    @Value("8080")
    private String port;

    @Override
    public String getPort() {
        return port;
    }

    @Override
    public Integer sum() {
        return Stream.iterate(1, a -> a + 1)
                //.parallel()
                .limit(1000000)
                .mapToInt(Integer::intValue)
                .sum();
    }

    @Override
    public String toString() {
        return "PortServiceIml{" +
                "port='" + port + '\'' +
                '}';
    }
}

package br.com.bds;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.testcontainers.containers.MySQLContainer;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DataBaseLifecycle implements QuarkusTestResourceLifecycleManager {

    private static MySQLContainer<?> MYSQL = new MySQLContainer<>("mysql:8.0");

    @Override
    public Map<String, String> start() {
        MYSQL.start();
        Map<String, String> propertires = new HashMap<>();
        propertires.put("quarkus.datasource.jdbc.url", MYSQL.getJdbcUrl());
        propertires.put("quarkus.datasource.username", MYSQL.getUsername());
        propertires.put("quarkus.datasource.password", MYSQL.getPassword());
        return propertires;
    }

    @Override
    public void stop() {
        if(Objects.nonNull(MYSQL))
            MYSQL.stop();
    }
}

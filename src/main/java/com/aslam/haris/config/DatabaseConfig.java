package com.aslam.haris.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EntityScan("com.aslam.haris.entity")
@EnableJpaRepositories("com.aslam.haris.repository")
public class DatabaseConfig {

}

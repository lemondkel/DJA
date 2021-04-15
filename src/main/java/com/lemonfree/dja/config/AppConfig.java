package com.lemonfree.dja.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 웹 어플리케이션 설정용 파일
 *
 * @author l2jong
 * @since 2021-02-28
 */
@Configuration
@EnableJpaRepositories(value = "com.lemonfree.dja.repo")
@EntityScan(basePackages = {"com.lemonfree.dja.entity"})
public class AppConfig {
//
}

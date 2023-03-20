package org.inyestar.blog.persistence.jpa.ranking.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"org.inyestar.blog.persistence"})
@EnableJpaRepositories(basePackages = {"org.inyestar.blog.persistence"})
@Configuration
public class H2Config {
}

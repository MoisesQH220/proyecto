package com.utp.integrador.proyecto.config;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;
import java.util.concurrent.Executors;

@Configuration
@AllArgsConstructor
@EnableTransactionManagement
public class DatabaseConfiguration {

  @Bean
  Scheduler jdbcScheduler(
          @Value("${spring.datasource.hikari.max-connections:10}") int maxConnections) {
    return Schedulers.fromExecutor(Executors.newFixedThreadPool(maxConnections));
  }


  @Bean
  public Module datatypeHibernateModule() {
    return new Hibernate5Module()
            .enable(Hibernate5Module.Feature.FORCE_LAZY_LOADING)
            .enable(Hibernate5Module.Feature.SERIALIZE_IDENTIFIER_FOR_LAZY_NOT_LOADED_OBJECTS);
  }
}
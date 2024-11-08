package com.example.orders.Configuration;

import com.vladmihalcea.flexypool.FlexyPoolDataSource;
import com.vladmihalcea.flexypool.adaptor.HikariCPPoolAdapter;
import com.vladmihalcea.flexypool.config.FlexyPoolConfiguration;
import com.vladmihalcea.flexypool.connection.ConnectionDecoratorFactoryResolver;
import com.vladmihalcea.flexypool.event.*;
import com.vladmihalcea.flexypool.strategy.IncrementPoolOnTimeoutConnectionAcquisitionStrategy;
import com.vladmihalcea.flexypool.strategy.RetryConnectionAcquisitionStrategy;
import com.vladmihalcea.flexypool.strategy.UniqueNamingStrategy;
import com.zaxxer.hikari.HikariDataSource;
import io.micrometer.core.instrument.MeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;


@Configuration
public class FlexyPoolConfig {

    public static class ConnectionAcquisitionTimeThresholdExceededEventListener
            extends EventListener<ConnectionAcquisitionTimeThresholdExceededEvent> {

        public static final Logger LOGGER = LoggerFactory.getLogger(
                ConnectionAcquisitionTimeThresholdExceededEventListener.class);

        public ConnectionAcquisitionTimeThresholdExceededEventListener() {
            super(ConnectionAcquisitionTimeThresholdExceededEvent.class);
        }

        @Override
        public void on(ConnectionAcquisitionTimeThresholdExceededEvent event) {
            LOGGER.info("Caught event {}", event);
        }
    }

    public static class ConnectionLeaseTimeThresholdExceededEventListener
            extends EventListener<ConnectionLeaseTimeThresholdExceededEvent> {

        public static final Logger LOGGER = LoggerFactory.getLogger(
                ConnectionLeaseTimeThresholdExceededEventListener.class);

        public ConnectionLeaseTimeThresholdExceededEventListener() {
            super(ConnectionLeaseTimeThresholdExceededEvent.class);
        }

        @Override
        public void on(ConnectionLeaseTimeThresholdExceededEvent event) {
            LOGGER.info("Caught event {}", event);
        }
    }

    public static class ConnectionAcquisitionTimeoutEventListener
            extends EventListener<ConnectionAcquisitionTimeoutEvent> {

        public static final Logger LOGGER = LoggerFactory.getLogger(
                ConnectionAcquisitionTimeoutEventListener.class);

        public ConnectionAcquisitionTimeoutEventListener() {
            super(ConnectionAcquisitionTimeoutEvent.class);
        }

        @Override
        public void on(ConnectionAcquisitionTimeoutEvent event) {
            LOGGER.info("Caught event {}", event);
        }
    }

    /*@Autowired
    private HikariDataSource poolingDataSource;*/

    @Value("${flexy.pool.uniqueId}")
    private String uniqueId;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public HikariDataSource poolingDataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public FlexyPoolConfiguration<HikariDataSource> configuration() {
        return new FlexyPoolConfiguration.Builder<HikariDataSource>(
                uniqueId,
                poolingDataSource(),
                HikariCPPoolAdapter.FACTORY
        )
                .setConnectionProxyFactory(ConnectionDecoratorFactoryResolver.INSTANCE.resolve())
                .setMetricLogReporterMillis(TimeUnit.SECONDS.toMillis(5))
                .setMetricNamingUniqueName(UniqueNamingStrategy.INSTANCE)
                .setJmxEnabled(true)
                .setJmxAutoStart(true)
                .setConnectionAcquisitionTimeThresholdMillis(50L)
                .setConnectionLeaseTimeThresholdMillis(250L)
                .setEventListenerResolver(() -> Arrays.<EventListener<? extends Event>>asList(
                        new ConnectionAcquisitionTimeoutEventListener(),
                        new ConnectionAcquisitionTimeThresholdExceededEventListener(),
                        new ConnectionLeaseTimeThresholdExceededEventListener()
                ) )
                .setMetricsFactory(MicrometerMetricsFactory::new)
                .build();
    }

    @Bean(initMethod = "start", destroyMethod = "stop")
    public FlexyPoolDataSource dataSource() {
        FlexyPoolConfiguration<HikariDataSource> configuration = configuration();
        return new FlexyPoolDataSource<HikariDataSource>(configuration,
                new IncrementPoolOnTimeoutConnectionAcquisitionStrategy.Factory(5),
                new RetryConnectionAcquisitionStrategy.Factory(2)
        );
    }
}
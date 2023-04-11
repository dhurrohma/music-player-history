package org.example.config;

import org.example.controller.*;
import org.example.repository.*;
import org.example.service.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application-prod.properties")
public class BeanConfiguration {
    @Value("${client.header}")
    private String clientHeader;
    @Value("${driver}")
    private String dbDriver;
    @Value("${url}")
    private String url;
    @Value("${dbuser}")
    private String dbUser;
    @Value("${dbpassword}")
    private String dbPassword;

    @Bean
    @Scope("singleton")
    public GenreController getGenreController() { return new GenreController(getGenreService()); }

    @Bean
    @Scope("prototype")
    public IGenreService getGenreService() {
        return new GenreService(getGenreRepository());
    }

    @Bean
    @Scope("prototype")
    public IGenreRepository getGenreRepository() {
        return new GenreRepository(dataSource());
    }


    @Bean
    @Scope("singleton")
    public SingerController getSingerController() { return new SingerController(getSingerService()); }

    @Bean
    @Scope("prototype")
    public ISingerService getSingerService() {
        return new SingerService(getSingerRepository());
    }

    @Bean
    @Scope("prototype")
    public ISingerRepository getSingerRepository() {
        return new SingerRepository(dataSource());
    }

    @Bean
    @Scope("singleton")
    public SongWriterController getSongWriterController() { return new SongWriterController(getSongWriterService()); }

    @Bean
    @Scope("prototype")
    public ISongWriterService getSongWriterService() {
        return new SongWriterService(getSongWriterRepository());
    }

    @Bean
    @Scope("prototype")
    public ISongWriterRepository getSongWriterRepository() {
        return new SongWriterRepository(dataSource());
    }

    @Bean
    @Scope("singleton")
    public SongController getSongController() { return new SongController(getSongService()); }

    @Bean
    @Scope("prototype")
    public ISongService getSongService() {
        return new SongService(getSongRepository());
    }

    @Bean
    @Scope("prototype")
    public ISongRepository getSongRepository() {
        return new SongRepository(dataSource());
    }

    @Bean
    @Scope("singleton")
    public HistoryController getHistoryController() { return new HistoryController(getHistoryService()); }

    @Bean
    @Scope("prototype")
    public IHistoryService getHistoryService() {
        return new HistoryService(getHistoryRepository());
    }

    @Bean
    @Scope("prototype")
    public IHistoryRepository getHistoryRepository() {
        return new HistoryRepository(dataSource());
    }

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(url);
        driverManagerDataSource.setUsername(dbUser);
        driverManagerDataSource.setPassword(dbPassword);
        driverManagerDataSource.setDriverClassName(dbDriver);

        return driverManagerDataSource;
    }
}

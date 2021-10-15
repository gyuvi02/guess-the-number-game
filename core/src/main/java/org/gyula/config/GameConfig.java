package org.gyula.config;

import org.gyula.GuessCount;
import org.gyula.MaxNumber;
import org.gyula.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/game.properties")
public class GameConfig {

    // fields
    @Value("${game.maxNumber:99}")
    private int maxNumber;

    @Value("${game.guessCount:9}")
    private int guessCount;

    @Value("${game.minNumber:0}")
    private int minNumber;

    // bean methods
    @Bean
    @MaxNumber
    public int maxiNumber() {
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount() {
        return guessCount;
    }

    @Bean
    @MinNumber
    public int minNumber() {
        return minNumber;
    }

}

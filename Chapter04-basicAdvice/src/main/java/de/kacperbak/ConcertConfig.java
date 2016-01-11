package de.kacperbak;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class ConcertConfig {

    @Bean
    public Performance performance(){
        return new SuccessfulPerformance();
    }

    @Bean
    public Audience audience(){
        return new Audience();
    }
}

package soundsystem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class CDPlayerConfig {

    @Bean
    public BlankDisc americana(){
        List<String> tracks = new ArrayList<String>();
        tracks.add("Pretty Fly");
        tracks.add("Americana");
        tracks.add("Pay The Man");
        return new BlankDisc("Americana", "The Offspring", tracks);
    }

    @Bean
    public TrackCounter trackCounter(){
        return new TrackCounter();
    }
}

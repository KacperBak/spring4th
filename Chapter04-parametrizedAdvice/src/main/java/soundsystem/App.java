package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by bakka on 11.01.16.
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(CDPlayerConfig.class);
        BlankDisc americanaCompactDisc = context.getBean("americana", BlankDisc.class);
        americanaCompactDisc.play(0);
    }
}

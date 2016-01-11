package de.kacperbak;

import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * Created by bakka on 11.01.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConcertConfig.class, loader = AnnotationConfigContextLoader.class)
public class PerformanceTest {

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired
    private Performance performance;

    @Test
    public void controlledPerformanceTest(){
        String controlledPerformanceOutput = "Taking seats.\n" + "Silencing cell phones.\n" + "Performing awesome controlled performance!\n" + "CLAP! CLAP! CLAP!\n";
        performance.controlledPerformance();
        assertEquals(controlledPerformanceOutput, log.getLog());
    }

    @Test
    public void randomPerformanceTest(){
        String controlledPerformanceOutput = "Silencing cell phones.\n" + "Taking seats.\n" + "Performing awesome random performance!\n" + "CLAP! CLAP! CLAP!\n";
        performance.randomPerformance();
        assertEquals(controlledPerformanceOutput, log.getLog());
    }
}

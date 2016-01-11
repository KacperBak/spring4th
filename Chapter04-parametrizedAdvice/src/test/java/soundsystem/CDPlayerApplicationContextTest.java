package soundsystem;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CDPlayerConfig.class)
public class CDPlayerApplicationContextTest {

    @Rule
    public StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired
    private ApplicationContext context;

    @Test
    public void testPlaySpecificTrack(){
        CompactDisc compactDisc = context.getBean("americana", CompactDisc.class);
        compactDisc.play(2);
        assertEquals("Playing: Pay The Man\n", log.getLog());
    }

    @Test
    public void testTrackCounter(){
        CompactDisc compactDisc = (CompactDisc) context.getBean("americana");
        compactDisc.play(0);
        compactDisc.play(1);
        compactDisc.play(1);

        TrackCounter counter = context.getBean(TrackCounter.class);
        assertEquals(1, counter.getPlayCount(0));
        assertEquals(2, counter.getPlayCount(1));
        assertEquals(0, counter.getPlayCount(2));
    }
}

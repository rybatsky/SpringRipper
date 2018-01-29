package quoters;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class TerminatorQuoterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void sayQuoteTest() {
        TerminatorQuoter bean = context.getBean(TerminatorQuoter.class);
        bean.sayQuote();

        int repeat = bean.getRepeat();
        StringBuilder testSb = new StringBuilder();
        for (int i = 0; i < repeat; i++) {
            testSb.append("I'll be back\n");
        }

        assertEquals(testSb.toString(), outContent.toString());
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
    }
}
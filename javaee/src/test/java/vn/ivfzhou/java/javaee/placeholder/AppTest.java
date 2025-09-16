package vn.ivfzhou.java.javaee.placeholder;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

public class AppTest {

    @Test
    public void shouldAnswerWithTrue() throws IOException {
        InputStream stream = getClass().getResourceAsStream("/application.properties");
        byte[] bs = new byte[8 * 1024];
        for (int len = stream.read(bs); len != -1; len = stream.read(bs)) {
            System.out.println(new String(bs, 0, len));
        }
    }

}

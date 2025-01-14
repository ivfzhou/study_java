package cn.ivfzhou.java.javaee;

import java.io.IOException;
import java.io.InputStream;

public class TestPlaceholder {

    public static void main(String[] args) throws IOException {
        try (InputStream stream = TestPlaceholder.class.getResourceAsStream("/application.properties")) {
            byte[] bs = new byte[1024];
            for (int len = 0; len != -1; len = stream.read(bs)) {
                System.out.println(new String(bs));
            }
        }
    }

}

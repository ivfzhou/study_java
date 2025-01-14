package cn.ivfzhou.java.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logback {

    private final static Logger logger = LoggerFactory.getLogger(Logback.class);

    public static void main(String[] args) {
        logger.info("hello {}", "logback");
    }

}

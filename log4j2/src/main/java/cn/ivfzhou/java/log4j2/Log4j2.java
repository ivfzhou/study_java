package cn.ivfzhou.java.log4j2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4j2 {

    public static Logger logger = LoggerFactory.getLogger(Log4j2.class);

    public static void main(String[] args) {
        logger.info("hello {}{}", "log4j", 2);
    }

}

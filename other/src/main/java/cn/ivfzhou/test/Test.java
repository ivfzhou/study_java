package cn.ivfzhou.test;

import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.SignerInformation;
import org.bouncycastle.cms.SignerInformationStore;
import org.bouncycastle.util.Store;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Test {

    public static void main(String[] args) throws Exception {
        var zonedDateTime = java.time.ZonedDateTime.ofInstant(LocalDateTime.now().plusHours(8), ZoneOffset.ofHours(8), java.time.ZoneId.of("GMT"));
        var formatter = java.time.format.DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss zzz", java.util.Locale.US);
        System.out.println(zonedDateTime.format(formatter));
    }

}

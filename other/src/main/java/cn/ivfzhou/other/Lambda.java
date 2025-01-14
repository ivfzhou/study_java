package cn.ivfzhou.other;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2");
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        list.sort((String o1, String o2) -> {
            return o1.compareTo(o2);
        });

        list.sort((o1, o2) -> {
            return o1.compareTo(o2);
        });

        list.sort((o1, o2) -> o1.compareTo(o2));
    }

}

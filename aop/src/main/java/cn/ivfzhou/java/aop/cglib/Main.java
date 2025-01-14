package cn.ivfzhou.java.aop.cglib;

public class Main {

    public static void main(String[] args) {
        Target target = new Proxy<>(new Target()).proxy();
        System.out.println(target.run());
    }

}

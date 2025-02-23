package cn.ivfzhou.java.aop.jdk;

public class Main {

    public static void main(String[] args) {
        Target target = new Target();
        Proxy o = (Proxy) java.lang.reflect.Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), (proxy, method, args1) -> {
                    if (method.getName().equals("run")) {
                        System.out.println("begin");
                        Object invoke = method.invoke(target, args1);
                        System.out.println("end");
                        return new StringBuilder((String)invoke).reverse().toString();
                    } else {
                        System.err.println("no matching method");
                        return method.invoke(target, args1);
                    }
                });

        System.out.println(o.run());
    }

}

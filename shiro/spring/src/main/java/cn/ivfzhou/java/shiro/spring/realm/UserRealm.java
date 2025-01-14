package cn.ivfzhou.java.shiro.spring.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import javax.annotation.PostConstruct;

import cn.ivfzhou.java.shiro.spring.bean.User;

public class UserRealm extends AuthorizingRealm {

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        User u = (User) principals.getPrimaryPrincipal();
        System.out.println("UserRealm.doGetAuthorizationInfo: " + u.getName() + "-" + u.getPasswd());
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        HashSet<String> roles = new HashSet<>();
        roles.add("someone");
        authorizationInfo.setRoles(roles);
        authorizationInfo.addStringPermission("query");
        return authorizationInfo;
    }

    // 鉴权
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        Object principal = token.getPrincipal();
        System.out.println("UserRealm.doGetAuthenticationInfo: " + principal);
        User u = new User();
        u.setName("ivfzhou");
        u.setPasswd("123456");
        return new SimpleAuthenticationInfo(u, "123456", "ivfzhou");
    }

    @PostConstruct
    public void inits() {
        setCachingEnabled(true);
        setAuthenticationCachingEnabled(true);
        setAuthorizationCachingEnabled(true);
    }

    // 该方法定义在Realme中调用父类的方法清空缓存
    public void clearCache() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }

}

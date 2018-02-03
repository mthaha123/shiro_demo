package com.shiroDemo.common.realm;

import com.shiroDemo.common.util.MySimpleByteSource;
import com.shiroDemo.model.UUser;
import com.shiroDemo.user.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.Date;

public class SampleRealm extends AuthorizingRealm {

    private IUserService userService;

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    /**
     * 授权
     * @param principals 身份
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(userService.findRoles(username));
        authorizationInfo.setStringPermissions(userService.findPermissions(username));
        return authorizationInfo;
    }

    /**
     * 身份认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        UUser user =userService.findByUsername(username);
        if(user == null){
            throw new UnknownAccountException();//没找到账号
        }
        if(user.getStatus()==0){
            throw new LockedAccountException();//账号锁定
        }
        //更新登录时间 lastLoginTime
        user.setLastLoginTime(new Date());
        userService.updateByPrimaryKeySelective(user);
        //交给AuthenticationRealm使用CredentialsMatcher进行密码匹配
        //将credentialsMatcher赋值给realm，realm间接继承了AuthenticatingRealm,
        // 其在调用getAuthenticationInfo方法获取到authentication信息后，会使用credentialsMatcher来验证凭据是否匹配，如果不匹配抛出异常
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                username,//用户名
                user.getPwd(),//密码
                new MySimpleByteSource(user.getCredentialSalt()),
//                ByteSource.Util.bytes(user.getCredentialSalt()),//盐
                getName());//realm name
        return authenticationInfo;
    }
}

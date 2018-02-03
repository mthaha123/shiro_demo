package springTest;

import com.shiroDemo.model.UUser;
import com.shiroDemo.user.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import javax.annotation.Resource;

public class CacheTest extends BaseJunit4Test {
    @Resource
    private CacheManager cacheManager;
    @Resource
    private IUserService userService;

    @Test
    public void cacheTest(){
        Cache cache = cacheManager.getCache("user");
        cache.put("zhang","nihao");
        String o = (String) cache.get("zhang").get();
        System.out.println(o);
        Assert.assertNotNull(cache.get("zhang"));
    }

    @Test
    public void UUserTest(){
        UUser uUser = new UUser();
        uUser.setNickname("tian");
        uUser.setEmail("845421982@qq.com");
        uUser.setPwd("123654");
        userService.createUser(uUser);
    }
    @Test
    public void shiroTest(){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("845421982@qq.com", "123654");
        try{
            subject.login(token);
        }catch (AuthenticationException e){
            System.out.println("验证失败");
        }
        if(subject.isAuthenticated()==true){
            System.out.println("验证成功");
        }
    }




}

package com.springbootdemo.byb.login;

import com.springbootdemo.byb.User.mapper.UserMapper;
import com.springbootdemo.byb.User.model.User;
import com.springbootdemo.byb.base.model.AjaxMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@Api(value = "登录接口")
public class LoginController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/login")
    public String  loginIndex(){
        System.out.println("登陆-----------");
        return "login";
    }

    @ApiOperation(value="登陆", notes="登陆")
//    @ApiImplicitParams({
//
//            @ApiImplicitParam(paramType = "query", name = "username", value = "用户名", required = true, dataType = "String"),
//            @ApiImplicitParam(paramType = "query", name = "password", value = "密码", required = true, dataType = "String")
//
//    })
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request, User user){
        System.out.println(user.getName()+"-----------"+user.getPassword());
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();

        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPassword());
        // 执行认证登陆
        try {
            subject.login(token);
        }catch (Exception e){
            e.printStackTrace();
            return   "redirect:/loginerror";
        }
        //根据权限，指定返回数据
//        String role = userMapper.getRole(username);
//
        SavedRequest savedRequest = WebUtils.getSavedRequest(request);
        System.out.println(savedRequest.getRequestUrl());
        return "redirect:" + savedRequest.getRequestUrl();
    }


    @RequestMapping("/loginerror")
    public String  loginerror(){
        System.out.println("登陆-----------");
        return "/loginerror";
    }
}

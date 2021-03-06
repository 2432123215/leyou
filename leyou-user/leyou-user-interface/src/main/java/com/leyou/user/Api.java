package com.leyou.user;

import com.leyou.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


public interface Api {
    @GetMapping("query")
    public User queryUser(@RequestParam("username") String username, @RequestParam("password") String password);
}

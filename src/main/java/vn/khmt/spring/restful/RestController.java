/*
 *  Copyright 2016 luongthenhan
 */
package vn.khmt.spring.restful;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author TheNhan
 */
@Controller
@RequestMapping("/example")
public class RestController {

    @RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
    public @ResponseBody
    User getUser(@PathVariable String name) {
        User u = new User();
        u.setName(name);
        u.setAge(33);
        return u;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public @ResponseBody
    List<User> getUserList() {
        List<User> ul = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 3; i++) {
            User u = new User();
            u.setName("User" + i);
            u.setAge(r.nextInt(100));
            ul.add(u);
        }
        return ul;
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    @ResponseBody
    public String createUser(@RequestBody User u) {
        System.out.println(u);
        return "User created!";
    }
}

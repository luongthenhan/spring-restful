/*
 *  Copyright 2016 luongthenhan
 */
package vn.khmt.spring.restful;

import java.util.ArrayList;
import java.util.List;
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

    List<User> userList = new ArrayList<>();

    @RequestMapping(value = "/user/{str}", method = RequestMethod.GET)
    public @ResponseBody
    User getUser(@PathVariable String str) {
        try {
            int id = Integer.parseInt(str);
            for (User u : userList) {
                if (u.getId() == id) {
                    return u;
                }
            }
        } catch (NumberFormatException nfe) {
            System.err.println(nfe.getMessage());
            System.out.println("Find by name " + str);
            for (User u : userList) {
                if (u.getName().equalsIgnoreCase(str)) {
                    return u;
                }
            }
        }
        return null;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public @ResponseBody
    List<User> getUserList() {
        return userList;
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public @ResponseBody
    String createUser(@RequestBody User u) {
        u.setId(userList.size() + 1);
        System.out.println("Create: " + u);
        userList.add(u);
        return "User created!";
    }

    @RequestMapping(value = "/user/modify", method = RequestMethod.PUT)
    public @ResponseBody
    String modifyUser(@RequestBody User u) {
        System.out.println("Modify: " + u);
        for (User us : userList) {
            if (us.getId() == u.getId()) {
                if (u.getName() != null) {
                    us.setName(u.getName());
                }
                if (u.getAge() != null) {
                    us.setAge(u.getAge());
                }
                return "User modified!";
            }
        }
        return "User not found!";
    }

    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    String modifyUser(@PathVariable int id) {
        for (User us : userList) {
            if (us.getId() == id) {
                System.out.println("Delete: " + us);
                userList.remove(us);
                return "User deleted!";
            }
        }
        return "User not found!";
    }
}

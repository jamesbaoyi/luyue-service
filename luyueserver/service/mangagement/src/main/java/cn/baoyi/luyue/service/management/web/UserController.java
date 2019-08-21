package cn.baoyi.luyue.service.management.web;

import cn.baoyi.luyue.entity.management.User;
import cn.baoyi.luyue.service.management.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * @Author: qijigui
 * @CreateDate: 2019/5/5 15:48
 * @Description:
 */
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/getUsers")
    @ApiOperation(value = "获取用户信息")
    private List<User> getUsers() {
        return userRepository.findAll();
    }


    @PostMapping("/addUser")
    @ApiOperation("添加用户信息")
    private void addUser() {
        User user = new User();
        user.setId(1);
        user.setUserName("administrator");
        user.setMobile("123456789");
        user.setUserRealName("贝贝高");
        userRepository.save(user);
    }

    @PutMapping("editUser")
    @ApiOperation("修改用户信息")
    private void editUser(@RequestParam Integer userId) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(() -> new Exception("用户不存在"));
        user.setUserRealName("高贝贝");
        userRepository.save(user);
    }

    @PutMapping("deleteUserById")
    @ApiOperation("删除用户信息")
    private void deleteUserById(@RequestParam Integer userId) {
        userRepository.deleteById(userId);
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> numberTemp = new ArrayList<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(1);
        numbers.add(3);
        numbers.add(3);
        numbers.add(4);
        numbers.add(4);
        numbers.add(4);
        for(int i =numbers.size()-1;i>0;i--)
        {
            if(numbers.get(i)==4)
            {
                numbers.remove(numbers.get(i));
            }

        }
        System.out.println("所剩元素是:\t" + numbers);
    }


}

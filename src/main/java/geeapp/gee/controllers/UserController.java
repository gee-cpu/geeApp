package geeapp.gee.controllers;

import geeapp.gee.dto.UserDto;
import geeapp.gee.service.UserService;
import geeapp.gee.userdetailsrequestmodel.UserDetails;
import geeapp.gee.userdetailsresponsemodel.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    UserService userService;

    @GetMapping

      public String getUser(){   return   "user requested";}

    @PostMapping
    public UserRest user(@RequestBody UserDetails userDetails) {
        UserRest returnValue = new UserRest();
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);
        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, returnValue);
        return returnValue;


    }
  @PutMapping
    public String updateUser(){
        return   "user updated";
    }
    @DeleteMapping
    public String deleteUser(){
        return   "user deleted";
    }
}

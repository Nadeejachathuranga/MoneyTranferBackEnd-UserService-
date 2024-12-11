package com.EBanking_UserServices.UserServices.EBanking.controller;

import com.EBanking_UserServices.UserServices.EBanking.dto.UserDto;
import com.EBanking_UserServices.UserServices.EBanking.entity.User;
import com.EBanking_UserServices.UserServices.EBanking.responseMsg.ResponseMsg;
import com.EBanking_UserServices.UserServices.EBanking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/vi/EBanking/User")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getAll/{selecting}")
    public List<User> TestingApi(@PathVariable String selecting){
        System.out.println(selecting);
        if(selecting.startsWith("name")){
            System.out.println("pathVariable detected");
            List<User> users = userService.GetAllUser();
            List<User> matchingUsers = new ArrayList<>();

            String targetName="nadeeja";
            for (User student : users) {
                if (student.getFullName().equalsIgnoreCase(targetName)) {
                    matchingUsers.add(student);
                }
            }

            if (!matchingUsers.isEmpty()) {
                System.out.println("Matching users:");
                for (User user : matchingUsers) {
                    System.out.println(user);
                }
                return matchingUsers;
            } else {
                System.out.println("No users found with the name: " + targetName);
            }


        }else if (selecting.startsWith("contactNo")){
           int targetTpNo=715375239;
            List<User> byContact = userService.GetAllUser();
            ArrayList<User> matchingWithContact = new ArrayList<>();

            for (User contact:byContact){
                if (contact.getContactNo()==targetTpNo){
                    matchingWithContact.add(contact);
                }
            }
            if (!matchingWithContact.isEmpty()){
                return matchingWithContact;
            }else { System.out.println("No users found with the contact: " );}

        } else {
            return userService.GetAllUser();
        }
        return null;
    }

    @PostMapping("/saveUser")
    public ResponseMsg SaveNewUser(@RequestBody UserDto userDto){
        return userService.SaveUser(userDto);
    }

    @DeleteMapping(params = {"id"})
    public ResponseMsg dropUser(String id){
        System.out.println(id);
        return userService.DeleteUser(new UserDto(id));
    }

    @PutMapping("/updateUserInfo")
    public ResponseMsg updateUser(@RequestBody UserDto userDto){
        return userService.updateUser(userDto);
    }

    @GetMapping(params = {"id"})
    public ResponseMsg findUser( String id){
        return userService.findUser(new UserDto(id));
    }
}

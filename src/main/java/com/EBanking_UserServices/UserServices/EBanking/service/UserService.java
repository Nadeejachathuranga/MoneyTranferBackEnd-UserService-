package com.EBanking_UserServices.UserServices.EBanking.service;

import com.EBanking_UserServices.UserServices.EBanking.dto.UserDto;
import com.EBanking_UserServices.UserServices.EBanking.entity.User;
import com.EBanking_UserServices.UserServices.EBanking.repo.UserRepo;
import com.EBanking_UserServices.UserServices.EBanking.responseMsg.ErrorMsg;
import com.EBanking_UserServices.UserServices.EBanking.responseMsg.ResponseMsg;
import com.EBanking_UserServices.UserServices.EBanking.responseMsg.SuccessMsg;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.lang.Character.getType;

@Service
@Transactional
public class UserService {
 @Autowired
 private UserRepo userrepo;

 @Autowired
 private ModelMapper mapper;

 public ResponseMsg SaveUser(UserDto userDto){
     try {
         String getId = userrepo.gettingLastId();
         int id= Integer.parseInt(getId.substring(3));
         id++;
         String newId="aid"+id;
         System.out.println("new user Id " + newId);
         userDto.setUserId(newId);
         userrepo.save(mapper.map(userDto, User.class));
         return new SuccessMsg("New User Saved ", userDto);
     }catch (Exception e){
         System.out.println(e);
         return new ErrorMsg("New User Saving Failed.Try Again.");
     }
 }

 public ResponseMsg DeleteUser(UserDto userDto){
     try {
         User map = mapper.map(userDto, User.class);
         userrepo.delete(map);
         return new SuccessMsg(" is deleted. " ,userDto);
     }catch (Exception e){
         System.out.println(e);
         return new ErrorMsg(" User Deleting Failed.Try Again.");
     }
 }

 public List<User> GetAllUser(){
     try {
         List<User> all = userrepo.findAll();
         return mapper.map(all, new TypeToken<List<User>>() {
         }.getType());
     }catch(Exception e){
         System.out.println(e);
         return null;
     }
 }

 public ResponseMsg updateUser(UserDto userDto) {
     try {
         userrepo.save(mapper.map(userDto, User.class));
         return new SuccessMsg("User Updated!!",userDto);
     }catch (Exception e){
         return new ErrorMsg(" User Updating Failed.Try Again.");
     }
    }

 public ResponseMsg findUser(UserDto userDto){
     try {
         User map = mapper.map(userDto, User.class);
         User user = userrepo.findById(map.getuserId()).get();
         return new SuccessMsg("Success ", mapper.map(user,UserDto.class));
     }catch (Exception e){
       return new ErrorMsg("Try Again. cant find ");
     }
 }
}

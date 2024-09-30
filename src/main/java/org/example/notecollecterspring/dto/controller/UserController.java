package org.example.notecollecterspring.dto.controller;

import org.example.notecollecterspring.dto.dto.impl.UserDTO;
import org.example.notecollecterspring.dto.service.UserService;
import org.example.notecollecterspring.dto.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private  UserService userService;
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO saveUser(
            @RequestPart("firstName") String firstName,
            @RequestPart("lastName") String lastName,
            @RequestPart("email") String email,
            @RequestPart("password") String password,
            @RequestPart("profilepic")MultipartFile profilepic



            ) {
        System.out.println("profilepic"+profilepic);
        String base64 ="";
        try {
            byte [] bytesPropic=profilepic.getBytes();
            base64 =AppUtil.generateProfilePicToBase64(bytesPropic);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //profilepic ----> Base64
      /*  String base64 = AppUtil.generateProfilePicToBase64(profilepic);*/

        //UserId generate
       String userId = AppUtil.generateUserId();

        //Todo: Build the object
        var buildUserDTO= new UserDTO();
        buildUserDTO.setUserId(userId);
        buildUserDTO.setFirstName(firstName);
        buildUserDTO.setLastName(lastName);
        buildUserDTO.setEmail(email);
        buildUserDTO.setPassword(password);
        buildUserDTO.setProfilepic(base64);
        userService.saveUser(buildUserDTO);
        return buildUserDTO;
    }
    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO getSelectedUser(@PathVariable ("userId") String userId){
        return userService.getUser(userId);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)

    @DeleteMapping(value = "/{userId}")
    public void deleteUser(@PathVariable("userId") String userId){
        userService.deleteUser(userId);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getAllUsers(){
        return userService.getAllUser();
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(value ="/{userId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void updateUser(
            @RequestPart("firstName") String firstName,
            @RequestPart("lastName") String lastName,
            @RequestPart("email") String email,
            @RequestPart("password") String password,
            @RequestPart("profilepic")MultipartFile profilepic,
            @PathVariable("userId") String userId
    ){
        String base64 ="";
        try {
            byte [] bytesPropic=profilepic.getBytes();
            base64 =AppUtil.generateProfilePicToBase64(bytesPropic);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Todo: Build the object
        var buildUserDTO= new UserDTO();
        buildUserDTO.setUserId(userId);
        buildUserDTO.setFirstName(firstName);
        buildUserDTO.setLastName(lastName);
        buildUserDTO.setEmail(email);
        buildUserDTO.setPassword(password);
        buildUserDTO.setProfilepic(base64);
        userService.saveUser(buildUserDTO);

    }
}

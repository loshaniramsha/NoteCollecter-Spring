package org.example.notecollecterspring.dto.controller;

import org.example.notecollecterspring.dto.dto.impl.UserDTO;
import org.example.notecollecterspring.dto.service.UserService;
import org.example.notecollecterspring.dto.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
}

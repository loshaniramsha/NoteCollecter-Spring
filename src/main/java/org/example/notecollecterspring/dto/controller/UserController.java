package org.example.notecollecterspring.dto.controller;

import org.example.notecollecterspring.dto.dto.impl.UserDTO;
import org.example.notecollecterspring.dto.util.AppUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO saveUser(
                          @RequestPart("firstName") String firstName,
                          @RequestPart("lastName") String lastName,
                          @RequestPart("email") String email,
                          @RequestPart("password") String password,
                          @RequestPart("profilepic") String profilepic



    ) {
        //profilepic ----> Base64
        String base64 = AppUtil.generateProfilePicToBase64(profilepic);

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

        return buildUserDTO;

    }
}

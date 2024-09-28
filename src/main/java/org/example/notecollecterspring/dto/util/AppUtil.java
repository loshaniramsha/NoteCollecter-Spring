package org.example.notecollecterspring.dto.util;

import java.util.Base64;
import java.util.UUID;

public class AppUtil {
    public static String generateNoteId(){
        return "NOTE-"+UUID.randomUUID();
    }
    public static String generateUserId(){
        return "USER-"+UUID.randomUUID();
    }
    public static String generateProfilePicToBase64(byte[] profilepic){
        /*return Base64.getEncoder().encodeToString(profilepic.getBytes());*/
        return Base64.getEncoder().encodeToString(profilepic);
    }
}

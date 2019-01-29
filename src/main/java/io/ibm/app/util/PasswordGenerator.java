package io.ibm.app.util;

import java.util.UUID;

public class PasswordGenerator {

     public  String generatePassword(){

  UUID uuid =UUID.randomUUID();
  String seq=uuid.toString();
  String modifiedSeq=seq.replace("-","");

  String password=modifiedSeq.substring(3,11);
         return password;
    }


}

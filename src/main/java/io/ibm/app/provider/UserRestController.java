package io.ibm.app.provider;

import io.ibm.app.generator.UserIdGenerator;
import io.ibm.app.model.User;
import io.ibm.app.service.IUserService;
import io.ibm.app.service.impl.MailService;
import io.ibm.app.util.PasswordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    @Autowired
    private IUserService service;
    @Autowired
    private MailService mailService;

    private UserIdGenerator idGen;
    private PasswordGenerator pwdGen;


    public UserRestController(){
        pwdGen=new PasswordGenerator();
        idGen=new UserIdGenerator();
    }

    @PostMapping(produces = "text/plain")
    public ResponseEntity<?> saveUser(@RequestBody User user){

          System.out.println(user);
          String password=pwdGen.generatePassword();

          String id=service.saveUser(user);



        if(id!=null) {

            Map<String, Object> model = new HashMap<>();
            model.put("userName", user.getFirstName() + "  " + user.getLastName());
            model.put("password", password);
            model.put("regId", id);
            boolean b = mailService.sendEmail(user, model);
            if(b)
              return ResponseEntity.ok("The OTP(One Time Password) have been sent to "+user.getEmail());
            else
                return ResponseEntity.ok("Registration successful but otp has not sent to "+user.getEmail());
        }
          else {
            return ResponseEntity.badRequest().body("The Data has not formatted properly");
        }

    }
}

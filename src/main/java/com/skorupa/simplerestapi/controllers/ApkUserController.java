package com.skorupa.simplerestapi.controllers;

import com.skorupa.simplerestapi.model.ApkUser;
import com.skorupa.simplerestapi.model.VerificationToken;
import com.skorupa.simplerestapi.repository.UserRepository;
import com.skorupa.simplerestapi.repository.VerificationTokenRepository;
import com.skorupa.simplerestapi.services.MailSenderService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Optional;

import static com.skorupa.simplerestapi.security.PasswordConfig.passwordEncoder;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ApkUserController {


    private UserRepository userRepository;
    private VerificationTokenRepository verificationTokenRepository;
    private MailSenderService mailSenderService;

    public ApkUserController(UserRepository userRepository,
                             VerificationTokenRepository verificationTokenRepository,
                             MailSenderService mailSenderService) {
        this.userRepository = userRepository;
        this.verificationTokenRepository = verificationTokenRepository;
        this.mailSenderService = mailSenderService;
    }

    @PostMapping
    @RequestMapping({"/createuser"})
    public String create(@RequestBody ApkUser apkUser) {

        ApkUser userToFind = userRepository.findUserByEmail(apkUser.getUsername());
        ApkUser userNameToFind = userRepository.findUserByUsername(apkUser.getUsername());
        if (userNameToFind != null && userToFind != null) {
            return "User exist";
        } else {
            apkUser.setPassword(passwordEncoder().encode(apkUser.getPassword()));
           userRepository.save(apkUser);
           VerificationToken verificationToken = new VerificationToken(apkUser);
           verificationTokenRepository.save(verificationToken);

           mailSenderService.prepareAndSendByMail(apkUser.getEmail(), verificationToken.getToken());
           return "User successfuly created, verification mail was send to: " + apkUser.getEmail();
        }
    }


    @RequestMapping(value="/verify-user", method ={RequestMethod.GET, RequestMethod.POST})
    public ModelAndView confirmuserAccount(ModelAndView modelAndView, @RequestParam("code") String token){

        VerificationToken tokenToFind = verificationTokenRepository.findByToken(token);
        LocalDate dataNow = LocalDate.now();

        if(tokenToFind == null && tokenToFind.getExpireDate().isAfter(dataNow)){
            modelAndView.addObject("msg", "The link is invalid");
            modelAndView.setViewName("error");
        }else{
            ApkUser apkUserToChange = userRepository.findApkUserById(tokenToFind.getApkUser().getId());
            apkUserToChange.setEnabled(true);
            tokenToFind.setStatus("VERIFIED");
            verificationTokenRepository.save(tokenToFind);
            userRepository.save(apkUserToChange);
            modelAndView.setViewName("activatedPage");
        }
        return modelAndView;
    }
}
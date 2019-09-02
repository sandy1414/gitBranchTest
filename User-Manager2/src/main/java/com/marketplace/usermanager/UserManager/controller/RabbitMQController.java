package com.marketplace.usermanager.UserManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marketplace.usermanager.UserManager.Publisher.RabbitPublisher;
import com.marketplace.usermanager.UserManager.model.User;
import com.marketplace.usermanager.UserManager.service.UserService;


@RestController
public class RabbitMQController {
   
   @Autowired
   private RabbitPublisher publisher;
   
   @Autowired
   private UserService userService;
   
   @RequestMapping("/send")
   public String sendMessage(@RequestParam("msg") String msg){
      System.out.println(msg);
      for(int i =0; i<10;i++){
      publisher.produceMsg(msg);
      }
      return "Successfully Sent";
   }
   
   @RequestMapping(value="/addUser", method=RequestMethod.POST)
   public String getUserProfile(@RequestBody User usr) {
	   User newUser = userService.addUser(usr);
	   if(newUser != null) {
		   return "Success";
	   }
	   return "Something Wrong!";
   }
}
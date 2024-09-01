package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin("*")
public class AuthenticationController {
	@Autowired
	private UserService userService;
	

    @PostMapping("/validate-user")
    public ResponseEntity<String> checkUserSignInDetails(@RequestBody User user, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            session = request.getSession();
        }

        System.out.println("Session id: " + session.getId());
        session.setAttribute("userEmail", user.getEmail());
        String userEmail = (String) session.getAttribute("userEmail");
        System.out.println(userEmail);
        System.out.println(user.getEmail());
        String response = this.userService.checkSignInDetails(user);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get-session-data")
    public ResponseEntity<String> getData(HttpServletRequest request) 
    {     HttpSession   session = request.getSession(false);
        String userEmail = (String) session.getAttribute("userEmail");
        if (userEmail == null) {
            return new ResponseEntity<>("No user logged in", HttpStatus.NOT_FOUND);
        }
        System.out.println(userEmail);
        return new ResponseEntity<>(userEmail, HttpStatus.OK);
    }

    @GetMapping("/check-session-status")
    public ResponseEntity<String> getSessionStatus(HttpServletRequest request) {
        String msg;
//        if (this.userService.isSessionOver(request)) {
        HttpSession session = request.getSession(false);
        String userEmail = (String) session.getAttribute("userEmail");
        msg=userEmail==null? "Session is Over": "Session is not Over";
//        } else {
            ;
//        }
        System.out.println(msg);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        String userEmail = (String) session.getAttribute("userEmail");
        if (userEmail == null) {
            return new ResponseEntity<>("No user logged in", HttpStatus.NOT_FOUND);
        }
        System.out.println(userEmail);
        session.invalidate();
        return new ResponseEntity<>("Logged out successfully", HttpStatus.OK);
    }
	
	@PostMapping("/check-user")
	public ResponseEntity<Boolean> checkUserExistsWithEmail(@RequestBody String email) {
	    boolean userExists = this.userService.checkUserByEmail(email);
	    return ResponseEntity.ok(userExists);
	}

	 

}

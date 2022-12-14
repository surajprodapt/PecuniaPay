package com.pecuniaPay.registrationLogin.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pecuniaPay.registrationLogin.entities.Customer;
import com.pecuniaPay.registrationLogin.entities.ERole;
import com.pecuniaPay.registrationLogin.entities.Role;
import com.pecuniaPay.registrationLogin.entities.User;
import com.pecuniaPay.registrationLogin.repositories.CustomerRepository;
import com.pecuniaPay.registrationLogin.repositories.RoleRepository;
import com.pecuniaPay.registrationLogin.repositories.UserRepository;
import com.pecuniaPay.registrationLogin.security.jwt.JwtUtils;
import com.pecuniaPay.registrationLogin.security.payload.request.LoginRequest;
import com.pecuniaPay.registrationLogin.security.payload.request.SignupRequest;
import com.pecuniaPay.registrationLogin.security.payload.response.JwtResponse;
import com.pecuniaPay.registrationLogin.security.payload.response.MessageResponse;
import com.pecuniaPay.registrationLogin.services.UserDetailsImpl;
import com.pecuniaPay.registrationLogin.valueObjects.CustomerWallet;
//http://localhost:8060/login/api/auth/signup
//http://localhost:8060/login/api/auth/signin
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;
  
  @Autowired
	private CustomerRepository customerRepo;
  
  @Autowired
  private RestTemplate restTemplate;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();    
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());

    return ResponseEntity.ok(new JwtResponse(jwt, 
                         userDetails.getId(), 
                         userDetails.getUsername(), 
                         userDetails.getEmail(), 
                         roles));
  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Username is already taken!"));
    }

    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Email is already in use!"));
    }

    // Create new user's account
    User user = new User(signUpRequest.getUsername(), 
               signUpRequest.getEmail(),
               encoder.encode(signUpRequest.getPassword()));

//    Set<String> strRoles = signUpRequest.getRole();
//    Set<Role> roles = new HashSet<>();
//
//    if (strRoles == null) {
//      Role userRole = roleRepository.findByName(ERole.ROLE_USER)
//          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//      roles.add(userRole);
//    } else {
//      strRoles.forEach(role -> {
//        switch (role) {
//        case "admin":
//          Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
//              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//          roles.add(adminRole);
//
//          break;
//        case "mod":
//          Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
//              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//          roles.add(modRole);
//
//          break;
//        default:
//          Role userRole = roleRepository.findByName(ERole.ROLE_USER)
//              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//          roles.add(userRole);
//        }
//      });
//    }
//
//    user.setRoles(roles);
    CustomerWallet customerWallet = restTemplate.getForObject("http://localhost:8060/wallet/wallet/generatenewwallet", CustomerWallet.class);
	Customer cust = new Customer();
	cust.setFirstName(signUpRequest.getFirstName());
	cust.setLastName(signUpRequest.getLastName());
	cust.setMobileNumber(signUpRequest.getMobileNumber());
	cust.setUserDetails(user);
//	cust.setWalletId(null);
	cust.setWalletId(customerWallet.getWalletId());
	customerRepo.save(cust);
    userRepository.save(user);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }
}

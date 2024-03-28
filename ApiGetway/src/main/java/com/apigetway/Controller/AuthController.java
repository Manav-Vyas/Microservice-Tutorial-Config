package com.apigetway.Controller;

//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
//import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
//import org.springframework.security.oauth2.core.oidc.user.OidcUser;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.apigetway.authResponse.AuthResponseEntity;
//
//@RestController
//@RequestMapping("/auth")
public class AuthController {

//	private Logger logger = LoggerFactory.getLogger(AuthController.class);
//	
//	public ResponseEntity<AuthResponseEntity> login(
//			@RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient client,
//			@AuthenticationPrincipal OidcUser user,
//			Model model
//			){
//		logger.info("user email id : {} ", user.getEmail());
//		
//		AuthResponseEntity authResponse = new AuthResponseEntity();
//		
//		authResponse.setUserId(user.getEmail());
//		authResponse.setAccessToken(client.getAccessToken().getTokenValue());
//		authResponse.setRefreshToken(client.getRefreshToken().getTokenValue());
//		authResponse.setExpireAt(client.getAccessToken().getExpiresAt().getEpochSecond());
//		
//		List<String> authorities = user.getAuthorities().stream().map(grantedAuthority ->{
//			return grantedAuthority.getAuthority();
//		}).collect(Collectors.toList());
//		
//		authResponse.setAuthorities(authorities);
//		
//		return new ResponseEntity<>(authResponse,HttpStatus.OK);
//	}
	
//	@PreAuthorize("hasRole('user')")
//	@GetMapping("/user")
//	public ResponseEntity<String> normalUser(){
//		return ResponseEntity.ok("I am user");
//	}
//	
//	@PreAuthorize("hasRole('admin')")
//	@GetMapping("/admin")
//	public ResponseEntity<String> adminUser(){
//		return ResponseEntity.ok("I am admin");
//	}
//	
//	@PreAuthorize("hasRole('public')")
//	@GetMapping("/public")
//	public ResponseEntity<String> publicUser(){
//		return ResponseEntity.ok("I am public");
//	}
//	
	
}

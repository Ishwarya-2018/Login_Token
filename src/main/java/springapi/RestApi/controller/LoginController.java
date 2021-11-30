package springapi.RestApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springapi.RestApi.dto.LoginDTO;
import springapi.RestApi.model.Response;
import springapi.RestApi.service.ServiceInterface;


@RestController
@RequestMapping("/user")
public class LoginController {
	
	@Autowired
	private ServiceInterface service;

	@PostMapping("/login")
	public ResponseEntity<Response> loginUser(@RequestBody LoginDTO loginDto) {
		System.out.println(loginDto.getEmail());
		System.out.println(loginDto.getPassword());
		String token = service.login(loginDto);
		System.out.println(token);
		return ResponseEntity.status(HttpStatus.OK).body(new Response(token, HttpStatus.OK.value()));
	}	
}

package springapi.RestApi.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import springapi.RestApi.dto.LoginDTO;
import springapi.RestApi.model.Login;
import springapi.RestApi.repository.LoginRepository;
import springapi.RestApi.utils.JwtUtility;

@Service
public class ServiceImpl implements ServiceInterface{
	
	@Autowired
	private LoginRepository loginRepository;

	@Autowired
	private ModelMapper modelMapper;


	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;

	@Override
	public String login(LoginDTO loginDto) {
		String token = null;
		Optional<Login> userDetails = loginRepository.findByEmail(loginDto.getEmail());
		if (userDetails.isPresent()) 
//			if (userDetails.get().isIsverify() == true
//					&& bCryptPasswordEncoder.matches(loginDto.getPassword(), userDetails.get().getPassword())) {
//				System.out.println("Userid for generate token : "+userDetails.get().getId());
				token = JwtUtility.generateToken(userDetails.get().getId());
		return token;
	}

}

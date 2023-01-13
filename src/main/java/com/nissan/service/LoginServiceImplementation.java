package com.nissan.service;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.common.APIResponse;
import com.nissan.dto.LoginDTO;
import com.nissan.dto.SignUpDTO;
import com.nissan.model.Login;
import com.nissan.model.UserRegistration;
import com.nissan.repo.ILoginRepository;
import com.nissan.repo.IUserRegistrationRepository;
import com.nissan.util.JwtUtils;

@Service
public class LoginServiceImplementation implements ILoginService {

	@Autowired
	private IUserRegistrationRepository userRegistrationRepository;

	@Autowired
	private ILoginRepository loginRepository;

	@Autowired
	private JwtUtils jwtUtils;

	@Transactional
	@Override
	public APIResponse signUp(SignUpDTO signUpDTO) {

		APIResponse apiResponse = new APIResponse();
		Login login = new Login();

		login.setEmailId(signUpDTO.getEmailId());
		login.setPassword(signUpDTO.getPassword());
		login.setTypeId(signUpDTO.getTypeId());

		loginRepository.save(login);
		
		UserRegistration userRegistration = new UserRegistration();
		
		userRegistration.setFirstName(signUpDTO.getFirstName());
		userRegistration.setLastName(signUpDTO.getLastName());
		userRegistration.setAge(signUpDTO.getAge());
		userRegistration.setGender(signUpDTO.getGender());
		userRegistration.setAddress(signUpDTO.getAddress());
		userRegistration.setPhoneNumber(signUpDTO.getPhoneNumber());
		userRegistration.setLoginId(login.getLoginId());
		
		userRegistrationRepository.save(userRegistration);

		// generate token
		String token = jwtUtils.generateJwt(login);

		// storing more details
		Map<String, Object> data = new HashMap<>();
		data.put("accessToken", token);
		data.put("role", login.getTypeId());
		data.put("emailId", login.getEmailId());

		apiResponse.setData(data);

		return apiResponse;
	}

	@Override
	public APIResponse login(LoginDTO loginDTO) {
		APIResponse apiResponse = new APIResponse();

		//verify if it exists 
		Login login = loginRepository.findOneByEmailIdIgnoreCaseAndPassword(loginDTO.getEmailId(), loginDTO.getPassword());
		
		if(login == null) {
			apiResponse.setData("User login failed");
			return apiResponse;
		}

		// generate token
		String token = jwtUtils.generateJwt(login);

		// storing more details
		Map<String, Object> data = new HashMap<>();
		data.put("accessToken", token);
		data.put("role", login.getTypeId());
		data.put("emailId", login.getEmailId());

		apiResponse.setData(data);

		return apiResponse;
	}

}

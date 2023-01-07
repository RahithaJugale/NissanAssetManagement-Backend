package com.nissan.service;

import com.nissan.common.APIResponse;
import com.nissan.dto.LoginDTO;
import com.nissan.dto.SignUpDTO;

public interface ILoginService {

	//SignUp
		APIResponse signUp(SignUpDTO signUpDTO);
		
		//Login
		APIResponse login(LoginDTO loginDTO);
}

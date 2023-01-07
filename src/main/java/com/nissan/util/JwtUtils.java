package com.nissan.util;

import java.util.Date;

import com.nissan.common.AccessDeniedException;
import com.nissan.model.Login;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtils {

	//secret key
		private static String secret = "This_is_Nissan";

		//expiration time
		private static long expiryDuration = 60*60;
		
		//generate token: header.payload.signature
		public String generateJwt(Login login) {
			
			long milliTime = System.currentTimeMillis();
			long expiryTime = milliTime + expiryDuration * 1000;
			
			//set issuedTime and ExpiryTime
			Date issuedAt = new Date(milliTime);
			Date expiredAt = new Date(expiryTime);
			
			//claims
			Claims claim = Jwts.claims().setIssuer(login.getLoginId().toString()).setIssuedAt(issuedAt).setExpiration(expiredAt);
			
			//generate jwt using claims
			return Jwts.builder().setClaims(claim).signWith(SignatureAlgorithm.HS512, secret).compact();
		}
		
		//access denied
		public Claims verify(String authorization) throws Exception{
			
			try {
				
				Claims claim = Jwts.parser().setSigningKey(secret).parseClaimsJws(authorization).getBody();
				return claim;
				
			}catch(Exception e) {
				throw new AccessDeniedException("Sorry! Access denied");
			}
		}
}

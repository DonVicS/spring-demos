package org.victor.boot.security.tests;

import org.junit.Test;
import org.victor.boot.security.JwtManager;

import io.jsonwebtoken.impl.crypto.MacProvider;

public class JwtManagerTest {

//	@Autowired
	JwtManager jwtManager;

	public JwtManagerTest() {
		jwtManager = new JwtManager(); 
	}

	@Test
	public void testToken() {
		String id = "1";
		String issuer = "aaa";
		String subject = "aaa";
		long ttlMillis = 60000L;
		jwtManager.key = MacProvider.generateKey();
		String jwt = jwtManager.createJWT(id, issuer, subject, ttlMillis);
		System.out.println(jwt);
		jwtManager.parseJWT(jwt);
	}

}

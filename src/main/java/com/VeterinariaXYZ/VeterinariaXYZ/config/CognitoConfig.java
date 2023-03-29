package com.VeterinariaXYZ.VeterinariaXYZ.config;

import com.VeterinariaXYZ.VeterinariaXYZ.security.JwtConfiguration;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.jwk.source.RemoteJWKSet;
import com.nimbusds.jose.proc.JWSKeySelector;
import com.nimbusds.jose.proc.JWSVerificationKeySelector;
import com.nimbusds.jose.util.DefaultResourceRetriever;
import com.nimbusds.jose.util.ResourceRetriever;
import com.nimbusds.jwt.proc.ConfigurableJWTProcessor;
import com.nimbusds.jwt.proc.DefaultJWTProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;
import java.net.URL;

import static com.nimbusds.jose.JWSAlgorithm.RS256;

@Configuration
public class CognitoConfig {

	private final JwtConfiguration jwtConfiguration;

	public CognitoConfig(JwtConfiguration jwtConfiguration) {
		this.jwtConfiguration = jwtConfiguration;
	}

	@Value("${com.VeterinariaXYZ.cognito.userPoolIdFront}")
	private String userPoolIdFront;

	@Bean
	public ConfigurableJWTProcessor configurableJWTProcessor() throws MalformedURLException {
		ResourceRetriever resourceRetriever = new DefaultResourceRetriever(2000, 2000);
		URL jwkURL = new URL(this.jwtConfiguration.getJwkUrl(userPoolIdFront));
		JWKSource keySource = new RemoteJWKSet(jwkURL, resourceRetriever);
		ConfigurableJWTProcessor jwtProcessor = new DefaultJWTProcessor();
		JWSKeySelector keySelector = new JWSVerificationKeySelector(RS256, keySource);
		jwtProcessor.setJWSKeySelector(keySelector);
		return jwtProcessor;
	}
}

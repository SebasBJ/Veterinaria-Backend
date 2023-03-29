package com.VeterinariaXYZ.VeterinariaXYZ.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtConfiguration {
	@Value("${com.VeterinariaXYZ.cognito.userPoolIdFront}")
	private String region;
	private String userNameField = "cognito:username";
	private int connectionTimeout = 2000;
	private int readTimeout = 2000;
	private String httpHeader = "Authorization";

	public String getJwkUrl(String userPoolId) {
		return String.format("https://cognito-idp.%s.amazonaws.com/%s/.well-known/jwks.json", this.region,
						userPoolId);
	}

	public String getCognitoIdentityPoolUrl(String userPoolId) {
		return String.format("https://cognito-idp.%s.amazonaws.com/%s", this.region, userPoolId);
	}

	public String getUserNameField() {
		return userNameField;
	}

	public void setUserNameField(String userNameField) {
		this.userNameField = userNameField;
	}

	public int getConnectionTimeout() {
		return connectionTimeout;
	}

	public void setConnectionTimeout(int connectionTimeout) {
		this.connectionTimeout = connectionTimeout;
	}

	public int getReadTimeout() {
		return readTimeout;
	}

	public void setReadTimeout(int readTimeout) {
		this.readTimeout = readTimeout;
	}

	public String getHttpHeader() {
		return httpHeader;
	}

	public void setHttpHeader(String httpHeader) {
		this.httpHeader = httpHeader;
	}

}

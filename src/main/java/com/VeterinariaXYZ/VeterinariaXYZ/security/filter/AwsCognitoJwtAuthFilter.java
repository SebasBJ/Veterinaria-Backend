package com.VeterinariaXYZ.VeterinariaXYZ.security.filter;

import com.VeterinariaXYZ.VeterinariaXYZ.security.AwsCognitoIdTokenProcessor;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.proc.BadJOSEException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;

@Component
public class AwsCognitoJwtAuthFilter extends GenericFilter {

	private static final Log logger = LogFactory.getLog(AwsCognitoJwtAuthFilter.class);
	private AwsCognitoIdTokenProcessor cognitoIdTokenProcessor;

	public AwsCognitoJwtAuthFilter(AwsCognitoIdTokenProcessor cognitoIdTokenProcessor) {
		this.cognitoIdTokenProcessor = cognitoIdTokenProcessor;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		Authentication authentication;
		try {
			authentication = this.cognitoIdTokenProcessor.authenticate((HttpServletRequest) request);
			if (authentication != null) {
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		} catch (ParseException | BadJOSEException | JOSEException e) {
			logger.error("Cognito ID Token processing error", e);
			SecurityContextHolder.clearContext();
		}

		filterChain.doFilter(request, response);
	}
}

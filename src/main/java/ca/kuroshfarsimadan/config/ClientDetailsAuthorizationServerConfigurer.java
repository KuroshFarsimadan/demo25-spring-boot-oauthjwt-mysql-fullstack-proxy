package ca.kuroshfarsimadan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class ClientDetailsAuthorizationServerConfigurer extends AuthorizationServerConfigurerAdapter {

	/* 
	 * In the POSTMAN, in the header tab, set the authentication type as Basic and specify the
	 * username = kurosh-client-username, password = kurosh-secret-client-password, grant_type = password.
	 * 
	 * Also, remember to specify the body username, password, and grant_type based on the database values.
	 */
	
	static final String CLIEN_ID = "kurosh-client-username";
	static final String CLIENT_SECRET = "kurosh-secret-client-password";
	static final String GRANT_TYPE_PASSWORD = "password";
	static final String AUTHORIZATION_CODE = "authorization_code";
	static final String REFRESH_TOKEN = "refresh_token";
	static final String IMPLICIT = "implicit";
	static final String SCOPE_READ = "read";
	static final String SCOPE_WRITE = "write";
	static final String TRUST = "trust";
	static final int ACCESS_TOKEN_VALIDITY_SECONDS = 1*60*60;
	static final int FREFRESH_TOKEN_VALIDITY_SECONDS = 6*60*60;
	/*
	 * https://projects.spring.io/spring-security-oauth/docs/oauth2.html
	 * Configuring Client Details
	 * The ClientDetailsServiceConfigurer (a callback from your AuthorizationServerConfigurer) can be used to define an in-memory or JDBC implementation of the client details service. Important attributes of a client are
	 * 
	 * - clientId: (required) the client id.
	 * - secret: (required for trusted clients) the client secret, if any.
	 * - scope: The scope to which the client is limited. If scope is undefined or empty (the default) the client is not limited by scope.
	 * - authorizedGrantTypes: Grant types that are authorized for the client to use. Default value is empty.
	 * - authorities: Authorities that are granted to the client (regular Spring Security authorities).
	 * 
	 * Client details can be updated in a running application by access the underlying store directly (e.g. database tables in the case of JdbcClientDetailsService) or through the ClientDetailsManager interface (which both implementations of ClientDetailsService also implement).
	 */

	@Autowired
	private AuthenticationManager authenticationManager;

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey("as466gf");
		return converter;
	}

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {

		configurer
				.inMemory()
				.withClient(CLIEN_ID)
				.secret(CLIENT_SECRET)
				.authorizedGrantTypes(GRANT_TYPE_PASSWORD, AUTHORIZATION_CODE, REFRESH_TOKEN, IMPLICIT )
				.scopes(SCOPE_READ, SCOPE_WRITE, TRUST)
				.accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS).
				refreshTokenValiditySeconds(FREFRESH_TOKEN_VALIDITY_SECONDS);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore())
				.authenticationManager(authenticationManager)
				.accessTokenConverter(accessTokenConverter());
	}
}
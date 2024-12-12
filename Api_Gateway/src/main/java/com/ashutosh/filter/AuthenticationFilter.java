package com.ashutosh.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ashutosh.util.jwtService;
import com.google.common.net.HttpHeaders;

@Component
public class AuthenticationFilter extends  AbstractGatewayFilterFactory<AuthenticationFilter.Config>{
	
	@Autowired
	private RouteValidator validator;
	
	@Autowired
	private RestTemplate template;
	
	@Autowired
	jwtService jwtSer;
	
	
	public AuthenticationFilter(){
	
		super(Config.class);
	}
public static class Config{
	
}

@Override
public GatewayFilter apply(Config config) {
	
	return ((exchange,chain)->{
		if(validator.isSecured.test(exchange.getRequest())) {
			//header contians token  
			
			 if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
				 throw new RuntimeException("missing authroization token");
			 }
String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
		if(authHeader!=null && authHeader.startsWith("Bearer ")) {
			authHeader = authHeader.substring(7);
			
		}
		try {
			//template.getForObject("http://AuthenticationApi/validate?token="+authHeader,String.class);
		
			jwtSer.validateToken(authHeader);
		}
		catch(Exception e) {
			 System.out.println("Unauthorize access to application");
			 throw new RuntimeException("un authorized access to application");
		}
		
		
		}
		
		return chain.filter(exchange);
	});
}

}

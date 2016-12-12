package com.example.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import com.example.route.JdbcRouteLocator;
import com.example.route.RouteRepository;

@Configuration
@EnableZuulProxy
@EnableEurekaClient
public class ApiGatewayConfiguration {
	
	@Autowired
	protected ZuulProperties zuulProperties;

	@Autowired
	protected ServerProperties server;	
	
	@Autowired
	private RouteRepository routeRepository;
	
	@Order(Ordered.HIGHEST_PRECEDENCE)
	@Bean
	public RouteLocator routeLocator() {
		return new JdbcRouteLocator(this.server.getServletPrefix(),
				this.zuulProperties, this.routeRepository);
	}

}

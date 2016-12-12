package com.example.route;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.cloud.netflix.zuul.filters.SimpleRouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties.ZuulRoute;

public class JdbcRouteLocator extends SimpleRouteLocator {

	
	private RouteRepository repository;
	
	public JdbcRouteLocator(String servletPath, ZuulProperties properties, RouteRepository repository) {
		super(servletPath, properties);
		this.repository = repository;
	}

	protected Map<String, ZuulRoute> locateRoutes() {
		

		List<ZuulRoute> routes = repository.findAll();
		
		Map<String, ZuulRoute> routesMap =
			    routes.stream().collect(Collectors.toMap(ZuulRoute::getPath,
		                                          route -> route));
		
		return routesMap;
	}
	
}

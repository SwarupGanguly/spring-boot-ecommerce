package com.example.ecommerce.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer{

	private EntityManager entityManager;
	
	@Autowired
	public MyDataRestConfig(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		// TODO Auto-generated method stub
		RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
		exposeIds(config);
	}
	
	private void exposeIds(RepositoryRestConfiguration config) {
		
		//get a list of all entity classes from entity manager
		Set<EntityType<?>> entities=entityManager.getMetamodel().getEntities();
		
		//create an array of entity types
		List<Class> entityClasses=new ArrayList<>();
		
		for(EntityType tempEntityType:entities) {
			entityClasses.add(tempEntityType.getJavaType());
		}
		System.out.println("entity classes"+entityClasses);
		
		Class[] domainTypes=entityClasses.toArray(new Class[0]);
		System.out.println("domain types"+domainTypes);
		config.exposeIdsFor(domainTypes);
	}
}

package br.com.unlimitedapps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class UsuarioMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsuarioMicroserviceApplication.class, args);
	}

//	@Bean
//	BeanFactoryPostProcessor beanFactoryPostProcessor(ApplicationContext beanRegistry) {
//	    return beanFactory -> {
//	        genericApplicationContext(
//	          (BeanDefinitionRegistry) ((AnnotationConfigServletWebServerApplicationContext) beanRegistry)
//	            .getBeanFactory());
//	    };
//	}
//
//	void genericApplicationContext(BeanDefinitionRegistry beanRegistry) {
//	    ClassPathBeanDefinitionScanner beanDefinitionScanner = new ClassPathBeanDefinitionScanner(beanRegistry);
//	    beanDefinitionScanner.addIncludeFilter(removeModelAndEntitiesFilter());
//	    beanDefinitionScanner.scan("br.com.unlimitedapps");
//	}
//
//	static TypeFilter removeModelAndEntitiesFilter() {
//	    return (MetadataReader mr, MetadataReaderFactory mrf) -> !mr.getClassMetadata()
//	      .getClassName()
//	      .endsWith("Model");
//	}
}

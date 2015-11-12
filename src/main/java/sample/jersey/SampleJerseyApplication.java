/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.jersey;

import io.swagger.jaxrs.config.BeanConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class SampleJerseyApplication extends SpringBootServletInitializer {

	//https://github.com/swagger-api/swagger-core/wiki/Swagger-Core-Jersey-2.X-Project-Setup-1.5#using-the-application-class
	// http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#boot-features-jersey
	// http://stackoverflow.com/questions/20915528/how-can-i-register-a-secondary-servlet-with-spring-boot

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {


		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setVersion("1.0.2");
		beanConfig.setSchemes(new String[]{"http"});
		beanConfig.setHost("localhost:8002");
		beanConfig.setBasePath("/api");
		beanConfig.setResourcePackage("io.swagger.resources");
		beanConfig.setScan(true);

		return application.sources(SampleJerseyApplication.class);
	}

	public static void main(String[] args) {
		new SampleJerseyApplication()
				.configure(new SpringApplicationBuilder(SampleJerseyApplication.class))
				.run(args);
	}

}

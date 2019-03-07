package com.cg.payroll;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@SpringBootApplication(scanBasePackages= {"com.cg.payroll"})
@EntityScan(basePackages="com.cg.payroll.Beans")
@EnableJpaRepositories(basePackages="com.cg.payroll.daoservices")
@EnableWebMvc
public class CgPayrollPortalSpringBootMvcjpaDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(CgPayrollPortalSpringBootMvcjpaDataApplication.class, args);
	}

}

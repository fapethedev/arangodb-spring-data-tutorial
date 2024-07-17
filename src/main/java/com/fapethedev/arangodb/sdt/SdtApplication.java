package com.fapethedev.arangodb.sdt;

import com.fapethedev.arangodb.sdt.runner.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SdtApplication {

	public static void main(String[] args) {
		Class<?>[] runner = new Class<?>[]{
				CrudRunner.class,
				DerivedQueryRunner.class,
				AQLRunner.class,
				RelationsRunner.class,
				ByExampleRunner.class
		};
        System.exit(SpringApplication.exit(SpringApplication.run(runner, args)));
	}

}

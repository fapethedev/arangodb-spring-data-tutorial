package com.fapethedev.arangodb.sdt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SdtApplication {

	public static void main(String[] args) {
		Class<?>[] runner = new Class<?>[]{};
        System.exit(SpringApplication.exit(SpringApplication.run(runner, args)));
	}

}

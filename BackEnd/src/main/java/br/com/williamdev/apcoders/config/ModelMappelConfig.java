package br.com.williamdev.apcoders.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMappelConfig {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}

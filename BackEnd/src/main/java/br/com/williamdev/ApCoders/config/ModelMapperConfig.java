package br.com.williamdev.apcoders.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		
		var modelMapper =  new ModelMapper();
		
//		modelMapper.createTypeMap(Unidade.class, UnidadeDTO.class)
//		.<Long>addMapping(src -> src.getIdUnidade(),(dest, value) -> dest.setIdUnidadeDTO(value)); 
//		
//		
//		
//		modelMapper.createTypeMap(DespesaUnidade.class, DespesaDTO.class)
//		.<Long>addMapping(src -> src.getIdDespesa(),(dest, value) -> dest.setIdDespesaDTO(value));
	
		
		return modelMapper;
	}
}

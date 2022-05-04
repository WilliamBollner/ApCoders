package br.com.williamdev.apcoders.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.williamdev.apcoders.data.dto.DespesaDTO;
import br.com.williamdev.apcoders.data.dto.InquilinoDTO;
import br.com.williamdev.apcoders.data.dto.UnidadeDTO;
import br.com.williamdev.apcoders.data.entity.DespesaUnidade;
import br.com.williamdev.apcoders.data.entity.Inquilino;
import br.com.williamdev.apcoders.data.entity.Unidade;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		
		var modelMapper =  new ModelMapper();
		
		modelMapper.createTypeMap(Unidade.class, UnidadeDTO.class)
			.<Long>addMapping(src -> src.getIdUnidade(),(dest, value) -> dest.setIdUnidadeDTO(value)); 
		
		modelMapper.createTypeMap(Inquilino.class, InquilinoDTO.class)
		.<Long>addMapping(src -> src.getIdInquilino(),(dest, value) -> dest.setIdInquilinoDTO(value));
		
		modelMapper.createTypeMap(DespesaUnidade.class, DespesaDTO.class)
		.<Long>addMapping(src -> src.getIdDespesa(),(dest, value) -> dest.setIdDespesaDTO(value));
	
		
		return modelMapper;
	}
}

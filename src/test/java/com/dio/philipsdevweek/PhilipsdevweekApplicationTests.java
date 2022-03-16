package com.dio.philipsdevweek;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.dio.philipsdevweek.controller.RegiaoController;
import com.dio.philipsdevweek.entity.Regiao;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.qos.logback.core.status.Status;


//TESTES DE INTEGRAÇÃO(integrando a nossa aplicação com algo externo)

@SpringBootTest
@AutoConfigureMockMvc
class PhilipsdevweekApplicationTests {

	private final String url = "/regioes";
	
	//O mock faz a simulação dos dados a serem testados dentro
	//do contexto que nosso programa está. No caso, uma simula-
	//ção de uma requisição ao servidor
	@Autowired
	MockMvc mockMvc;
	
	//Vai pegar o objeto e transformar pra JSON(Método Post)
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private RegiaoController regiaoController;
	
	//Listar os objetos
	@Test
	public void getControllerTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(url))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	//Buscar pelo Id
	@Test
	public void getByIdControllerTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get(url + "/id/1"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	//Criar Regiao
	@Test
	public void postControllerTest() throws Exception {
		Regiao regiao = new Regiao("Noroeste", 57L);
		mockMvc.perform(MockMvcRequestBuilders.post(url + "/novo")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(regiao)))
		        .andExpect(MockMvcResultMatchers.status().isCreated());   
	}
	
	//Remover Regiao
		@Test
		public void deleteControllerTest() throws Exception {
			mockMvc.perform(MockMvcRequestBuilders.delete(url + "/remover/1")
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON))
			        .andExpect(MockMvcResultMatchers.status().isOk()); 
		}
	
	
	@Test
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}

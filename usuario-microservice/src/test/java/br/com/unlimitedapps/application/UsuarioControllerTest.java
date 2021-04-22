package br.com.unlimitedapps.application;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoClients;

import br.com.unlimitedapps.UsuarioMicroserviceApplicationTests;
import br.com.unlimitedapps.common.CommonUtils;
import br.com.unlimitedapps.domain.UsuarioService;
import br.com.unlimitedapps.infra.UsuarioMongoDbRepository;
import br.com.unlimitedapps.mock.UsuarioMock;


class UsuarioControllerTest extends UsuarioMicroserviceApplicationTests {

	private static MockMvc mockMvc;
	private static MongoTemplate mongoTemplate;
	private static UsuarioController usuarioController;
	private UsuarioDto usuarioDtoRetorno;

	
	@BeforeAll
	static void setUp() {
		mongoTemplate = new MongoTemplate( MongoClients.create(), "rest-cliente-testes");
		UsuarioMongoDbRepository usuarioRepository = new UsuarioMongoDbRepository(mongoTemplate);
		UsuarioService usuarioService = new UsuarioService(usuarioRepository);
		usuarioController = new UsuarioController(usuarioService);
		mockMvc = MockMvcBuilders.standaloneSetup(usuarioController).build();
	}
	
	@Test
	void deveIncluirComSucesso() throws Exception {
		criar();
	}

	
	@Test
	void deveAlterarComSucesso() throws Exception {
		criar();
		alterar();
	}
	
	@Test
	void deveExcluirComSucesso() throws Exception {
		criar();
		excluir();
	}
	
	@Test
	void deveBuscarPorIdComSucesso() throws Exception {
		criar();
		buscarIndentificador();
	}
	
	@Test
	void deveBuscarPorEmailComSucesso() throws Exception {
		criar();
		buscarEmail();
	}
	
	@Test
	void deveBuscarPorCPFComSucesso() throws Exception {
		criar();
		buscarCpf();
	}


	private void criar() throws Exception {
		MvcResult andReturn = mockMvc.perform(MockMvcRequestBuilders.post("/usuarios")
																	.contentType(MediaType.APPLICATION_JSON)
																	.accept(MediaType.APPLICATION_JSON)
				.content(UsuarioMock.mockIncluirFormValido().converterParaJSON()))
		.andExpect(MockMvcResultMatchers.status().isCreated())
		.andReturn();
		
		usuarioDtoRetorno = new ObjectMapper().readValue(andReturn.getResponse().getContentAsString(), UsuarioDto.class);
		
		System.out.println(usuarioDtoRetorno.getId());
	}

	private void alterar() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.put("/usuarios").contentType(MediaType.APPLICATION_JSON)
															   .content(UsuarioMock.mockAlterarFormValido(usuarioDtoRetorno.getId()).converterParaJSON()))
												   .andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	private void buscarEmail() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/usuarios/email")
											  .contentType(MediaType.APPLICATION_JSON)
											  .content("{ \"endereco\": \"" +usuarioDtoRetorno.getEmail()+"\" }"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	private void buscarCpf() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/usuarios/cpf")
					.contentType(MediaType.APPLICATION_JSON)
		 			.content("{ \"numero\": \"" +usuarioDtoRetorno.getCpf()+"\" }"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	private void buscarIndentificador() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/usuarios/{id}", usuarioDtoRetorno.getId())
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	private void excluir() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/usuarios/{id}", usuarioDtoRetorno.getId())
											  .contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	
	
	
	@AfterEach
	 void down() {
		mongoTemplate.dropCollection("usuario");
	}
	

}

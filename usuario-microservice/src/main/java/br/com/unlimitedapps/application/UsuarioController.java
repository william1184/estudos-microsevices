package br.com.unlimitedapps.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unlimitedapps.domain.Cpf;
import br.com.unlimitedapps.domain.Email;
import br.com.unlimitedapps.domain.Usuario;
import br.com.unlimitedapps.domain.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	private UsuarioService service;

	@Autowired
	public UsuarioController(UsuarioService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<UsuarioDto> incluirUsuario(@RequestBody UsuarioIncluirForm usuario) {
		
		Optional<Usuario> usuarioDb = service.incluirUsuario(usuario.converter());
		
		if(!usuarioDb.isPresent()) {
			return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
		}
		
		return new ResponseEntity<>( UsuarioDto.converter(usuarioDb.get()), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<UsuarioDto> alterarUsuario(@RequestBody UsuarioAlterarForm usuario) {
		
		Optional<Usuario> usuarioDb = service.atualizarUsuario(usuario.converter());
		
		if(!usuarioDb.isPresent()) {
			return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
		}
		
		return new ResponseEntity<>( UsuarioDto.converter(usuarioDb.get()), HttpStatus.OK);			
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDto> buscarUsuarioPorIndentificador(@PathVariable String id)  {
		
		Optional<Usuario> usuarioDb = service.buscarUsuarioPorIndentificador(id);
		
		if( !usuarioDb.isPresent() ) {
			return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
		}
		
		return new ResponseEntity<>( new UsuarioDto(usuarioDb.get()), HttpStatus.OK);
	}
	
	@GetMapping("/email")
	public ResponseEntity<UsuarioDto> buscarUsuarioPorEmail(@RequestBody Email email)  {
		
		Optional<Usuario> usuarioDb = service.buscarUsuarioPorEmail(email);
		
		if( !usuarioDb.isPresent() ) {
			return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
		}
		
		return new ResponseEntity<>( new UsuarioDto(usuarioDb.get()), HttpStatus.OK);
	}
	
	@GetMapping("/cpf")
	public ResponseEntity<UsuarioDto> buscarUsuarioPorCpf(@RequestBody Cpf cpf)  {
		
		Optional<Usuario> usuarioDb = service.buscarUsuarioPorCpf(cpf);
		
		if( !usuarioDb.isPresent() ) {
			return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
		}
		
		return new ResponseEntity<>( new UsuarioDto(usuarioDb.get()), HttpStatus.OK);
	}
	
	@GetMapping("/{pagina}/{quantidade}")
	public ResponseEntity<List<UsuarioDto>> buscarVariosUsuarios(@PathVariable String pagina, @PathVariable String quantidade)  {
		
		Optional<List<Usuario>> usuarios = service.buscarTodosUsuarios(Integer.parseInt(pagina), Integer.parseInt(quantidade));
		
		if( !usuarios.isPresent() ) {
			return ResponseEntity.badRequest().build();
		}
		
		return new ResponseEntity<>( UsuarioDto.converter(usuarios.get()), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletarUsuario(@PathVariable String id)  {
		
		service.deletarUsuario(id);
		
		return ResponseEntity.ok("Excluido com sucesso!");
	}
}

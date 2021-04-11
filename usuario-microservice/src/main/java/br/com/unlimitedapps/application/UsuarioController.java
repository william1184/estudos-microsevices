package br.com.unlimitedapps.application;

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

import br.com.unlimitedapps.domain.UsuarioModel;
import br.com.unlimitedapps.domain.UsuarioService;

public class UsuarioController {

	private UsuarioService service;

	@Autowired
	public UsuarioController(UsuarioService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<UsuarioDto> incluirUsuario(@RequestBody UsuarioIncluirForm usuario) {
		
		Optional<UsuarioModel> usuarioDb = service.incluirUsuario(usuario.converter());
		
		if(!usuarioDb.isPresent()) {
			return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
		}
		
		return new ResponseEntity<>( UsuarioDto.converter(usuarioDb.get()), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<UsuarioDto> alterarUsuario(@RequestBody UsuarioAlterarForm usuario) {
		
		Optional<UsuarioModel> usuarioDb = service.atualizarUsuario(usuario.converter());
		
		if(!usuarioDb.isPresent()) {
			return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
		}
		
		return new ResponseEntity<>( UsuarioDto.converter(usuarioDb.get()), HttpStatus.OK);			
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<UsuarioDto> buscarUsuarioPorEmail(@PathVariable String email)  {
		
		Optional<UsuarioModel> usuarioDb = service.buscarUsuarioPorEmail(email);
		
		if( !usuarioDb.isPresent() ) {
			return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
		}
		
		return new ResponseEntity<>( new UsuarioDto(usuarioDb.get()), HttpStatus.OK);
	}
	
//	@GetMapping("/{pagina}/{quantidade}")
//	public ResponseEntity<Page<UsuarioDto>> buscarVariosUsuarios(@PathVariable String pagina, @PathVariable String quantidade)  {
//		
//		Page<Usuario> usuarios = service.buscarTodosUsuarios(Integer.parseInt(pagina), Integer.parseInt(quantidade));
//		
//		if( usuarios == null ) {
//			return ResponseEntity.badRequest().build();
//		}
//		
//		return new ResponseEntity<>( UsuarioDto.converter(usuarios), HttpStatus.OK);
//	}
	
	@DeleteMapping("/{codigo}")
	public ResponseEntity<String> deletarUsuario(@PathVariable String codigo)  {
		
		service.deletarUsuario(codigo);
		
		return ResponseEntity.ok("Excluido com sucesso!");
	}
}

package com.yuri.mymanager.api.repositories;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.yuri.mymanager.api.entities.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@SuppressWarnings("static-access")
public class UsuarioRepositoryTest {
	@Autowired
	private UsuarioRepository usuarioRepository;

	GenericInfo info = new GenericInfo();

	@Before
	public void setUp() {
		usuarioRepository.save(info.usuario);
	}
	
	@After
	public void tearDown() {
		usuarioRepository.deleteAll();
	}
	
	//@Test
	public void testFindByEmail() {
		Usuario usuario = this.usuarioRepository.findByEmail(info.email);
		assertEquals(usuario.getEmail(), info.email);		
	}
	
}

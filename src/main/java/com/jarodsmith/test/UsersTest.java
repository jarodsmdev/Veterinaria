package com.jarodsmith.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.jarodsmith.model.Authorities;
import com.jarodsmith.model.Users;

public class UsersTest {
	@Test
	public void testConstructorAndGetters() {
	    // Arrange
	    String username = "johnDoe";
	    String password = "password123";
	    int enabled = 1;
	    List<Authorities> authorities = new ArrayList<>(); // Agrega instancias de Authorities según tus necesidades

	    // Act
	    Users user = new Users(username, password, enabled, authorities);

	    // Assert
	    assertEquals(username, user.getUsername());
	    assertEquals(password, user.getPassword());
	    assertEquals(enabled, user.getEnabled());
	    assertEquals(authorities, user.getAuthorities());
	}
	
	@Test
	public void testSetters() {
	    // Arrange
	    Users user = new Users();
	    String username = "johnDoe";
	    String password = "password123";
	    int enabled = 1;
	    List<Authorities> authorities = new ArrayList<>(); // Agrega instancias de Authorities según tus necesidades

	    // Act
	    user.setUsername(username);
	    user.setPassword(password);
	    user.setEnabled(enabled);
	    user.setAuthorities(authorities);

	    // Assert
	    assertEquals(username, user.getUsername());
	    assertEquals(password, user.getPassword());
	    assertEquals(enabled, user.getEnabled());
	    assertEquals(authorities, user.getAuthorities());
	}

	


}

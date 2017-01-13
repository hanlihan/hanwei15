package com.ittx.Student.ServletText;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ittx.Student.Servertimpl.UsersServerimpl;

import sun.print.resources.serviceui;

public class UsersServerimplTest {
    private UsersServerimpl serviceui = new UsersServerimpl();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testDeleteUsersById() {
		int id = 15;
		serviceui.deleteUsersById(id);
	}

}

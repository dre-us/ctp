package com.unal.ctm;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import com.unal.ctp.model.*;
import com.unal.ctp.data_structures.*;

/**
 * Unit test for simple App.
 */

public class AppTest {

	@Test
	public void shouldAnswerWithTrue() {
		assertTrue( true );
	}

	//@Test
	public void deberiaCompararDosCursos() {
		Course course1 = new Course("12345");
		Course course2 = new Course("12345");
		Course course3 = new Course("12346");
		assertTrue(course1.equals(course2));
		assertTrue(!course2.equals(course3));
	}

	//@Test
	public void deberiaInsertarCorrectamente() {
		ArrayList<Integer> lista = new ArrayList<Integer>();
		//lista.insertBack(3);
		//lista.insertBack(4);
		//lista.insertFront(1);
		//lista.insert(1, 2);
		//lista.insertFront(0);
		//lista.insertBack(5);
		//lista.insert(2);
		//lista.set(0, -1);
		String respuesta = "[-1, 1, 2, 3, 4, 5]";
		assertTrue(respuesta.equals(lista.toString()));
	}

	//@Test
	public void deberiaEncontrarCorrectamente() {
		ArrayList<Course> courses = new ArrayList<Course>();
		Course course1 = new Course("1234");
		courses.insert(course1);
		Course course2 = new Course("1234");
		int j = courses.find(course2);
		assertTrue(j >= 0);
	}
}

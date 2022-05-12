package com.unal.ctp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.IOException;
import com.unal.ctp.data_structures.*;
import com.unal.ctp.model.*;

public class App {

	public static void main(String[] args) throws IOException {
		App app = new App();
		app.input();
	}

	private void input() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("data/data.in"));
		String line;
		Degree degree = new Degree();
		degree.setId("2879");
		degree.setName("Ingenieria de sistemas y computacion");
		while ((line = br.readLine()) != null) {
			String[] dataCourse = line.split("[;] ");
			String[] requirements = dataCourse[dataCourse.length - 1].split("[\\[\\]]|[,] ");
			Course course = new Course(dataCourse[0], dataCourse[1], Integer.parseInt(dataCourse[2]), dataCourse[4]);
			for (int i = 1; i < requirements.length; ++i) {
				Condition condition = new Condition("2879", dataCourse[0]);
				Course requirement = new Course(requirements[i]);
				condition.insertCourse(requirement);
				course.insertCondition(condition);
			}
			degree.insertCourse(course);
		}
		degree.update();
		System.out.println(degree.toString());
	}
}

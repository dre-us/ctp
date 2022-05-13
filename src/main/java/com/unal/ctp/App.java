package com.unal.ctp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.IOException;
import com.unal.ctp.datastructures.*;
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
		ArrayList<Stack<Course>> ans = generateStacks(degree);
		System.out.println(degree.toString());
		System.out.println(ans.toString());
		System.out.println(ans.size());
	}

	private ArrayList<Stack<Course>> generateStacks(Degree degree) {
		ArrayList<Course> courses = degree.getCourses();
		ArrayList<Boolean> flags = new ArrayList<Boolean>();
		Stack<Course> explore = new Stack<Course>();
		for (int i = 0; i < courses.size(); ++i) flags.insertBack(false);
		for (int i = 0; i < courses.size(); ++i) {
			ArrayList<Condition> conditions = courses.get(i).getConditions();
			for (int j = 0; j < conditions.size(); ++j) {
				ArrayList<Course> requirements = conditions.get(j).getCourses();
				for (int k = 0; k < requirements.size(); ++k) {
					int n = courses.find(requirements.get(k));
					if (n != -1) flags.set(n, true);
				}
			}
		}
		ArrayList<Stack<Course>> stacks = new ArrayList<Stack<Course>>();
		for (int i = 0; i < courses.size(); ++i) {
			if (!flags.get(i))
				explore.push(courses.get(i));
		}
		while (!explore.empty()) {
			Course course = explore.top();
			explore.pop();
			Stack<Course> stack = new Stack<Course>();
			generateStack(course, stack, explore, stacks);
			stacks.insertBack(stack);
		}
		return stacks;
	}

	private void generateStack(Course course, Stack<Course> stack, Stack<Course> explore, ArrayList<Stack<Course>> stacks) {
		stack.push(course);
		ArrayList<Condition> conditions = course.getConditions();
		if (conditions.size() == 0) {
			stacks.insertBack(stack);
		} else if (conditions.size() == 1) {
			//conditions could have more than one course
			Course requirement = conditions.get(0).getCourses().get(0);
			generateStack(requirement, stack, explore, stacks);
		} else {
			for (int i = 0; i < conditions.size(); ++i) {
				ArrayList<Course> requirements = conditions.get(i).getCourses();
				for (int j = 0; j < requirements.size(); ++j) {
					explore.push(requirements.get(j));
					//requirement j shouldnt be pushed if it was already explored
				}
			}
		}
	}
}

package com.unal.ctp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.IOException;
import com.unal.ctp.datastructures.*;
import com.unal.ctp.model.*;
import java.util.Scanner;

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
		//System.out.println(degree.toString());
		//System.out.println(ans.toString());
		System.out.println(ans.size());
		functionalities(degree);
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
			flags.set(i, false);
		}
		while (!explore.empty()) {
			Course course = explore.top();
			explore.pop();
			int j = courses.find(course);
			if (flags.get(j)) continue;
			Stack<Course> stack = new Stack<Course>();
			generateStack(course, stack, explore, stacks);
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
					explore.insert(requirements.get(j));
					//requirement j shouldnt be pushed if it was already explored
				}
			}
		}
	}

	private void functionalities(Degree degree){
		System.out.println("Seleccione a continuación que desea hacer");
		System.out.println("1. Consultar asignatura");
		System.out.println("2. Creador de mallas");
		System.out.println("3. Editor de mallas");

		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();


		if (choice == 1){
			System.out.println("Escriba el codigo de la asignatura a buscar");
			Course courseSearched = new Course(scanner.next());
			System.out.println(" ");
			degree.findCourse(courseSearched);
		}
		else
			System.out.println("Función aún no disponible");
		scanner.close();

	}

	private ArrayList<Pensum> generatePensum(Degree degree) {
		ArrayList<Stack<Course>> stacks = generateStacks(degree);
		ArrayList<Course> curr_semester = new ArrayList<Course>();
		Pensum pensum = new Pensum();
		ArrayList<Pensum> pensums = new ArryList<Pensum>();
		generatePensum(stacks, 0, 1, curr_semester, pensum, pensums);
		return pensums;
	}


	private void generatePensum(ArrayList<Stack<Course>> stacks, int i, int semester, ArrayList<Course> curr_semester, Pensum pensum, ArrayList<Pensum> pensums) {
		if (i == stacks.size()) {
			if (semester > 20) {
				return;
			} else if (this.isValidPensum(pensum)) {
				pensums.insertBack(pensum);
				//crear metodos para realizar una copia de pensum, agregarlo por referencia es un error.
			} else if (this.isValidSemester(curr_semester)) {
				pensum.insertSemester(curr_semester);
				generatePensum(stacks, 0, semester + 1, new ArrayList<Course>(), pensum, pensums);
				pensum.deleteBack();
			}
		} else {
			while (stacks.get(i).empty()) ++i;
			if (i == stacks.size()) {
				generatePensum(stacks, i, semester, curr_semester, pensum, pensums);
			} else {
				Course course = stacks.get(i).top();
				generatePensum(stacks, i+1, semester, curr_semester, pensum, pensums);
				if (this.isValidCourse(course, curr_semester, pensum)) {
					stacks.get(i).pop();
					curr_semester.insertBack(course);
					generatePensum(stacks, i+1, semester, curr_semester, pensum, pensums);
					curr_semester.removeBack();
					stacks.get(i).push(course);
				} else {
					stacks.get(i).pop();
					generatePensum(stacks, i, semester, curr_semester, pensum, pensums);
					stacks.get(i).push(course);
				}
			}
		}
	}
}

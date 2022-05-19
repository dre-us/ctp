package com.unal.ctp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.unal.ctp.datastructures.*;
import com.unal.ctp.model.*;
import java.util.Scanner;
import java.time.*;

public class App {

	private ArrayList<Degree> degrees;
	private ArrayList<Pensum> pensums;
	private Scanner scanner;
	private App() {
		degrees = new ArrayList<Degree>();
		scanner = new Scanner(System.in);
	}

	public static void main(String[] args) throws IOException {
		App app = new App();
		app.input();
		app.functionalities();
	}

	private ArrayList<Pensum> getPensums() {
		return generatePensums(degrees.get(0));
	}


	private void input() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("data/data11.in"));
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
		br.close();
		degree.update();
		degrees.insertBack(degree);
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
			if (j == -1 || flags.get(j)) continue;
			else flags.set(j, true);
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
				for (int j = 0; j < requirements.size(); ++j)
					explore.insert(requirements.get(j));
			}
			stacks.insertBack(stack);
		}
	}

	private void functionalities(){
		System.out.println("Seleccione a continuación que desea hacer");
		System.out.println("1. Consultar asignatura");
		System.out.println("2. Creador de mallas");
		System.out.println("3. Mostrar malla");
		System.out.println("4. Editor de mallas");
		System.out.println("5. Salir");
		Degree degree = degrees.get(0);
		int choice = scanner.nextInt();
		if (choice == 1){
			System.out.println("Escriba el codigo de la asignatura a buscar");
			Course courseSearched = new Course(scanner.next());
			System.out.println();
			degree.findCourse(courseSearched);
			System.out.println();
		} else if (choice == 2) {
			long start = System.currentTimeMillis();
			pensums = generatePensums(degree);
			long end = System.currentTimeMillis();
			System.out.println("\nSe generaron " + pensums.size() + " pensums en " + (end-start) + "ms\n");
		} else if (choice == 3) {
			System.out.println("Escoja un numero entre 1 y " + pensums.size());
			int pensum = scanner.nextInt();
			if (1 <= pensum && pensum <= pensums.size()) {
				System.out.println();
				pensums.get(pensum-1).printPensum();
				System.out.println();
			}
		} else if (choice == 4) {
			System.out.println("\nFuncion aun no disponible\n");
		} else if (choice == 5) {
			scanner.close();
			return;
		} else {
			System.out.println("Función aún no disponible");
		}
		functionalities();

	}

	private ArrayList<Pensum> generatePensums(Degree degree) {
		ArrayList<Stack<Course>> stacks = generateStacks(degree);
		ArrayList<Course> curr_semester = new ArrayList<Course>(10);
		Pensum pensum = new Pensum();
		ArrayList<Pensum> pensums = new ArrayList<Pensum>();
		generatePensum(stacks, 0, 1, curr_semester, pensum, pensums);
		return pensums;
	}

	private boolean isValidPensum(Pensum pensum) {
		return pensum.getCourses().size() == this.degrees.get(0).getCourses().size();
	}

	private int sumCredits(ArrayList<Course> courses) {
		int cont = 0;
		for (int i = 0; i < courses.size(); ++i)
			cont += courses.get(i).getCredits();
		return cont;
	}

	private boolean isValidSemester(ArrayList<Course> courses) {
		int creditsPerSemester = sumCredits(courses);
		return 0 < creditsPerSemester && creditsPerSemester <= 20;
	}

	private boolean isValidCourse(Course course, ArrayList<Course> semester, Pensum pensum) {
		boolean validCourse = true;
		for (int i = 0; i < course.getConditions().size(); ++i)
			validCourse = validCourse && pensum.contains(course.getConditions().get(i).getCourses().get(0));
		return validCourse && sumCredits(semester) + course.getCredits() <= 20;
	}

	private void generatePensum(ArrayList<Stack<Course>> stacks, int i, int semester, ArrayList<Course> curr_semester, Pensum pensum, ArrayList<Pensum> pensums) {
		if (i == stacks.size()) {
			if (semester > 20) {
				return;
			} else if (this.isValidPensum(pensum)) {
				pensums.insertBack(pensum.copy());
			} else if (this.isValidSemester(curr_semester)) {
				pensum.insertSemester(curr_semester);
				generatePensum(stacks, 0, semester + 1, new ArrayList<Course>(10), pensum, pensums);
				pensum.removeBack();
			}
		} else if (stacks.get(i).empty()) {
			generatePensum(stacks, i + 1, semester, curr_semester, pensum, pensums);
		} else {
			Course course = stacks.get(i).top();
			if (curr_semester.find(course) != -1 || pensum.contains(course)) {
				stacks.get(i).pop();
				generatePensum(stacks, i, semester, curr_semester, pensum, pensums);
				stacks.get(i).push(course);
			} else if (this.isValidCourse(course, curr_semester, pensum)) {
				stacks.get(i).pop();
				curr_semester.insertBack(course);
				generatePensum(stacks, i + 1, semester, curr_semester, pensum, pensums);
				curr_semester.deleteBack();
				stacks.get(i).push(course);
			}
			generatePensum(stacks, i + 1, semester, curr_semester, pensum, pensums);
		}
	}
}

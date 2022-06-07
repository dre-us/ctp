package com.unal.edu.co.ctp.service;

import java.util.ArrayList;
import java.util.List;
import com.unal.edu.co.ctp.datastructures.Stack;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.unal.edu.co.ctp.model.Course;
import com.unal.edu.co.ctp.model.Pensum;
import com.unal.edu.co.ctp.model.PensumDTO;
import com.unal.edu.co.ctp.model.Condition;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class PensumService implements IPensumService {

	private ICourseService courseService;
	private List<Course> courses;
	private List<PensumDTO> pensums;

	@Autowired
	public PensumService(ICourseService courseService) {
		this.courseService = courseService;
		this.courses = courseService.findAll();
		this.pensums = generatePensums();
	}

	@Override
	public List<PensumDTO> findAll() {
		return pensums;
	}

	@Override
	public PensumDTO find(Integer pensum) {
		if (pensum >= 0 && pensum < pensums.size()) {
			return pensums.get(pensum);
		}
		return new PensumDTO();
	}

	private ArrayList<Stack<Course>> generateStacks() {
		ArrayList<Boolean> flags = new ArrayList<Boolean>();
		Stack<Course> explore = new Stack<Course>();
		for (int i = 0; i < courses.size(); ++i) flags.add(false);
		for (int i = 0; i < courses.size(); ++i) {
			ArrayList<Condition> conditions = courses.get(i).getConditions();
			for (int j = 0; j < conditions.size(); ++j) {
				ArrayList<Course> requirements = conditions.get(j).getCourses();
				for (int k = 0; k < requirements.size(); ++k) {
					int n = courses.indexOf(requirements.get(k));
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
			Course course = explore.peek();
			explore.pop();
			int j = courses.indexOf(course);
			if (j == -1 || flags.get(j)) continue;
			else flags.set(j, true);
			Stack<Course> stack = new Stack<Course>();
			generateStack(course, stack, explore, stacks, flags);
		}
		return stacks;
	}

	private void generateStack(Course course, Stack<Course> stack, Stack<Course> explore, ArrayList<Stack<Course>> stacks, ArrayList<Boolean> flags) {
		stack.push(course);
		ArrayList<Condition> conditions = course.getConditions();
		if (conditions.size() == 0) {
			stacks.add(stack);
		} else if (conditions.size() == 1) {
			//conditions could have more than one course
			Course requirement = conditions.get(0).getCourses().get(0);
			int i = courses.indexOf(requirement);
			if (i != -1 && !flags.get(i)) {
				flags.set(i, true);
				generateStack(requirement, stack, explore, stacks, flags);
			}
		} else if (conditions.size() > 1){
			for (int i = 0; i < conditions.size(); ++i) {
				ArrayList<Course> requirements = conditions.get(i).getCourses();
				for (int j = 0; j < requirements.size(); ++j) {
					int k = courses.indexOf(requirements.get(j));
					if (k != -1 && !flags.get(k))
						explore.push(requirements.get(j));
				}
			}
			stacks.add(stack);
		}
	}

	public ArrayList<PensumDTO> generatePensums() {
		ArrayList<Stack<Course>> stacks = generateStacks();
		ArrayList<Course> curr_semester = new ArrayList<Course>();
		Pensum pensum = new Pensum();
		ArrayList<PensumDTO> pensums = new ArrayList<PensumDTO>();
		generatePensum(stacks, 0, 1, curr_semester, pensum, pensums);
		return pensums;
	}

	private boolean isValidPensum(Pensum pensum) {
		return pensum.getCourses().size() == courses.size();
	}

	private int sumCredits(ArrayList<Course> courses) {
		int cont = 0;
		for (int i = 0; i < courses.size(); ++i)
			cont += courses.get(i).getCredits();
		return cont;
	}

	private boolean isValidSemester(ArrayList<Course> semester) {
		int creditsPerSemester = sumCredits(semester);
		return 0 < creditsPerSemester && creditsPerSemester <= 20;
	}

	private boolean isValidCourse(Course course, ArrayList<Course> semester, Pensum pensum) {
		boolean validCourse = true;
		for (int i = 0; i < course.getConditions().size(); ++i)
			validCourse = validCourse && pensum.contains(course.getConditions().get(i).getCourses().get(0));
		return validCourse && (sumCredits(semester) + course.getCredits()) <= 20;
	}

	private void generatePensum(ArrayList<Stack<Course>> stacks, int i, int semester, ArrayList<Course> curr_semester, Pensum pensum, ArrayList<PensumDTO> pensums) {
		if (i == stacks.size()) {
			//no hay mas pilas de donde sacar materias
			if (semester > 20) {
				//parar recursion, se excedio el limite de semestres
				return;
			} else if (this.isValidPensum(pensum)) {
				//guardar el pensum valido y parar la recursion
				pensums.add(pensum.getDTO());
			} else if (this.isValidSemester(curr_semester)) {
				//agregar el semestre valido al pensum que se esta creando
				pensum.insertSemester(curr_semester);
				//se inicia una nueva recursion, para el siguiente semestre
				generatePensum(stacks, 0, semester + 1, new ArrayList<Course>(10), pensum, pensums);
				pensum.removeBack();
			}
		} else if (stacks.get(i).empty()) {
			//la pila actual no tiene cursos, se inicia nueva recursion saltando la pila actual
			generatePensum(stacks, i + 1, semester, curr_semester, pensum, pensums);
		} else {
			Course course = stacks.get(i).peek();
			if (curr_semester.indexOf(course) != -1 || pensum.contains(course)) {
				//eliminar el curso que esta en el top de la pila actual porque ya esta en el semestre o pensum que se esta construyendo
				stacks.get(i).pop();
				generatePensum(stacks, i, semester, curr_semester, pensum, pensums);
				stacks.get(i).push(course);
			} else if (this.isValidCourse(course, curr_semester, pensum)) {
				//si el curso es valido para agregar, se agrega y se abre una nueva recursion saltando la pila actual
				//nota: para un mismo semestre no se pueden sacar dos cursos de una misma pila
				stacks.get(i).pop();
				curr_semester.add(course);
				generatePensum(stacks, i + 1, semester, curr_semester, pensum, pensums);
				curr_semester.remove(curr_semester.size() - 1);
				stacks.get(i).push(course);
			}
			//se abre una nueva recursion ignorando la pila actual
			//nota: esto es necesario para generar todas las posibilidades
			//por cada curso se debe ver el caso en el que se agrega y el caso en el que no se agrega al semestre actual
			generatePensum(stacks, i + 1, semester, curr_semester, pensum, pensums);
		}
	}
}

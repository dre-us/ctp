package com.unal.edu.co.ctp.controller;

import java.util.List;
import com.unal.edu.co.ctp.model.PensumDTO;
import com.unal.edu.co.ctp.service.IPensumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PensumController {

	@Autowired
	private IPensumService pensumService;

	@GetMapping(value = "/pensums")
	public List<PensumDTO> getPensums() {
		List<PensumDTO> pensums = pensumService.findAll();
		return pensums;
	}

	@GetMapping(value = "/pensum/{num}")
	public PensumDTO getPensum(@PathVariable Integer num) {
		return pensumService.find(num);
	}
}

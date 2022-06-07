package com.unal.edu.co.ctp.service;

import java.util.List;
import com.unal.edu.co.ctp.model.PensumDTO;

public interface IPensumService {

	abstract public List<PensumDTO> findAll();
	abstract public PensumDTO find(Integer pensum);

}

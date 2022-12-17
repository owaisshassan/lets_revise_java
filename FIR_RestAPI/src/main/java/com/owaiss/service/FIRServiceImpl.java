package com.owaiss.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.owaiss.exception.FIRException;

import com.owaiss.model.FIR;
import com.owaiss.repository.FIRRepo;

@Service
public class FIRServiceImpl implements FIRService{

	@Autowired
	private FIRRepo firDao;
	
	@Override
	public FIR file_fir(FIR fir) throws FIRException {

		Optional<FIR> fOpt= firDao.findById(fir.getFirId());
		
		if(fOpt.isPresent()) throw new FIRException("FIR already filed with this ID");
		fir.setTimeStamp(LocalDateTime.now());
		firDao.save(fir);
		
		
		return fir;
	}

}

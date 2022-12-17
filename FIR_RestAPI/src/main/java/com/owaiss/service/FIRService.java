package com.owaiss.service;

import com.owaiss.exception.FIRException;
import com.owaiss.model.FIR;

public interface FIRService {

	public FIR file_fir(FIR fir) throws FIRException;
}

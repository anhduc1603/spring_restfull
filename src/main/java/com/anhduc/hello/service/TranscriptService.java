package com.anhduc.hello.service;

import java.util.List;

import com.anhduc.hello.model.Employee;
import com.anhduc.hello.model.Transcript;

public interface TranscriptService {
	Transcript saveTrancript(Transcript transcript);
	List<Transcript> getAllTranscripts();
}

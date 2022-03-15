package com.anhduc.hello.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anhduc.hello.model.Employee;
import com.anhduc.hello.model.Transcript;
import com.anhduc.hello.repository.TrancriptReponsitory;
import com.anhduc.hello.service.TranscriptService;


@Service
public class TranscriptServiceImpl implements TranscriptService {

	@Autowired
	TrancriptReponsitory tranReponsitory;
	
	public TranscriptServiceImpl(TrancriptReponsitory tranReponsitory) {
		super();
		this.tranReponsitory = tranReponsitory;
	}
	
	@Override
	public Transcript saveTrancript(Transcript transcript) {
		return tranReponsitory.save(transcript);
	}

	@Override
	public List<Transcript> getAllTranscripts() {
		return tranReponsitory.findAll();
	}


}

package com.anhduc.hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anhduc.hello.model.Employee;
import com.anhduc.hello.model.Transcript;
import com.anhduc.hello.service.TranscriptService;

@RestController
@RequestMapping("/api/transcript")
public class TranscripController {
	
	@Autowired
	TranscriptService transcriptService;

	@PostMapping("save")
	public ResponseEntity<Transcript> saveEmployee(@RequestBody Transcript transcript){
		return new ResponseEntity<Transcript>(transcriptService.saveTrancript(transcript),
				HttpStatus.CREATED);
	}
	
	@GetMapping("all")
	public List<Transcript> getAllEmployee(){
		return transcriptService.getAllTranscripts();
	}
	
}

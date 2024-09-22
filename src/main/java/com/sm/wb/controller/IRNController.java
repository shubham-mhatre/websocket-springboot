package com.sm.wb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sm.wb.dto.ResponseDto;

@RestController
@RequestMapping("/irn")
public class IRNController {
	
	@Autowired
    private SimpMessagingTemplate messagingTemplate;
	
	@PostMapping("/generateIRN")
    public ResponseEntity<Object> generateIRN(@RequestBody String request) {
		
		messagingTemplate.convertAndSend("/topic/notifications", "Invoice generated successfully!");
		ResponseDto response=new ResponseDto();
		response.setMessage("Invoice generated successfully");
		return ResponseEntity.ok(response);
	}
	
	
	@PostMapping("/cancelIRN")
    public ResponseEntity<Object> cancelIRN(@RequestBody String request) {
		
		messagingTemplate.convertAndSend("/topic/notifications", "Invoice cancelled successfully!");
		ResponseDto response=new ResponseDto();
		response.setMessage("Invoice cancelled successfully");
		return ResponseEntity.ok(response);
	}

}

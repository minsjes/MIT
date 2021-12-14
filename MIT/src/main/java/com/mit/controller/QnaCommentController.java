package com.mit.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mit.domain.QnaCommentVO;
import com.mit.service.QnaCommentService;

@RestController
@RequestMapping("/qnaComment")
public class QnaCommentController {
	
private static final Logger logger = LoggerFactory.getLogger(QnaCommentController.class);
	
	@Inject
	private QnaCommentService service;
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody QnaCommentVO cvo) {
		ResponseEntity<String> entity = null;
		
		try {
			service.register(cvo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
			
			logger.info("reply get...");
		}
		
		return entity;
	}
	
	@RequestMapping(value = "/{commentNo}", method = RequestMethod.DELETE)
	public ResponseEntity<String> remove(@PathVariable("commentNo") int commentNo) { // 조금 다르게 함
		ResponseEntity<String> entity = null;
		
		try {
			service.remove(commentNo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
	@RequestMapping(value = "/all/{qnaNo}", method = {RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity<List<QnaCommentVO>> list(@PathVariable("qnaNo") int qnaNo) {
		ResponseEntity<List<QnaCommentVO>> entity = null;
		
		try {
			entity = new ResponseEntity<>(service.list(qnaNo), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
}

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

import com.mit.domain.FreeCommentVO;
import com.mit.service.FreeCommentService;

@RestController
@RequestMapping("/fcomment")
public class FreeCommentController {
	private static final Logger logger = LoggerFactory.getLogger(FreeCommentController.class);
	
	@Inject
	private FreeCommentService service;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody FreeCommentVO fcvo) {
		ResponseEntity<String> entity = null;

		try {
			service.register(fcvo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);

			logger.info("reply get...");
		}
		
		return entity;
	}

	@RequestMapping(value = "/{freeCommentNo}", method = RequestMethod.DELETE)
	public ResponseEntity<String> remove(@PathVariable("freeCommentNo") int commentNo) {
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

	@RequestMapping(value = "/all/{freeNo}", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<List<FreeCommentVO>> list(@PathVariable("freeNo") int freeNo) {
		ResponseEntity<List<FreeCommentVO>> entity = null;
		try {
			entity = new ResponseEntity<>(service.list(freeNo), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
}

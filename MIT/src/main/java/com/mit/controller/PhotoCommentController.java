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

import com.mit.domain.PhotoCommentVO;
import com.mit.service.PhotoCommentService;

@RestController
@RequestMapping("/pcomment")
public class PhotoCommentController {
	@Inject
	private PhotoCommentService service;
	
	private static final Logger logger = LoggerFactory.getLogger(PhotoCommentController.class);
	
	// 1.댓글 생성
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody PhotoCommentVO pcvo) {
		ResponseEntity<String> entity = null;

		try {
			service.add(pcvo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);

			logger.info("reply get.,...........");
		}
		return entity;
	}

	// 2.댓글 삭제
	@RequestMapping(value = "/{photoCommentNo}", method = RequestMethod.DELETE)
	public ResponseEntity<String> remove(@PathVariable("photoCommentNo") int commentNo) {

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

	// 3.댓글 전체 보기
	@RequestMapping(value = "/all/{photoNo}", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<List<PhotoCommentVO>> list(@PathVariable("photoNo") int photoNo) {
		ResponseEntity<List<PhotoCommentVO>> entity = null;
		try {
			entity = new ResponseEntity<>(service.list(photoNo), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}

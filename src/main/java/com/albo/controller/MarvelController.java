package com.albo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.albo.service.IMarvelService;

/***
 * API Marvel Controller
 * @author PaulM
 *
 */

@RestController
@RequestMapping("/marvel")
public class MarvelController {
	
	private static final Logger LOG =
            LoggerFactory.getLogger(MarvelController.class);

	@Autowired
	IMarvelService characterService;
	
	
	/***
	 * consultation of the collaborators of a character
	 * @param character nickname
	 * @return collaborators info
	 */
	@GetMapping("/colaborators/{character}")
	public ResponseEntity<?> getColaboratorInfo(@PathVariable String character) {
		try {
			return ResponseEntity.ok(characterService.getColaboratorInfo(character));
		}catch (Exception e) {
			LOG.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NO_CONTENT);
		}
	}
	
	/***
	 * Get Characters Info
	 * @return character data wrapper
	 */
	@GetMapping("/characters")
	public ResponseEntity<?> getCharacters() {
		try {
			return ResponseEntity.ok(characterService.getCharacters());
		}catch (Exception e) {
			LOG.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NO_CONTENT);
		}
	}

	/***
	 * Get Comics by chacacter
	 * @param character character
	 * @return Comic data wrapper
	 */
	@GetMapping("/comics/{character}")
	public ResponseEntity<?> getComics(@PathVariable int character) {
		try {
			return ResponseEntity.ok(characterService.getComics(character));
		}catch (Exception e) {
			LOG.error(e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NO_CONTENT);
		}
	}
	
}
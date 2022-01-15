package kodlamaio.hrms.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ResumeCoverLetterService;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.ResumeCoverLetter;

@RestController
@RequestMapping("/api/resumeCoverLetters")
public class ResumeCoverLetterController {
	
	private ResumeCoverLetterService resumeCoverLetterService;
	@Autowired
	public ResumeCoverLetterController(ResumeCoverLetterService resumeCoverLetterService) {
		this.resumeCoverLetterService=resumeCoverLetterService;
	}
	
	@GetMapping(value="/getAll")
	public ResponseEntity<?> getAll()  {
		
		return ResponseEntity.ok(this.resumeCoverLetterService.getAll());
	}
	
	@GetMapping(value="/getByResumeCoverLetterId")
	public ResponseEntity<?> getByResumeCoverLetterId(int id)  {
		
		return ResponseEntity.ok(this.resumeCoverLetterService.getByResumeCoverLetterId(id));
	}
	
	@GetMapping(value="/getAllByCandidate_id")
	public ResponseEntity<?> getAllByCandidate_id(int id)  {
		
		return ResponseEntity.ok(this.resumeCoverLetterService.getAllByCandidate_id(id));
	}

		
	@PostMapping(value="/update")
	public ResponseEntity<?> update(@Valid @RequestBody  ResumeCoverLetter resumeCoverLetter)  {
		
		return ResponseEntity.ok(this.resumeCoverLetterService.update(resumeCoverLetter));
	}
	
	@PostMapping(value="/add")
	public ResponseEntity<?> add(@Valid @RequestBody  ResumeCoverLetter resumeCoverLetter)  {
		
		return ResponseEntity.ok(this.resumeCoverLetterService.add(resumeCoverLetter));
	}
	
	@PostMapping(value="/delete")
	public ResponseEntity<?> delete(@Valid @RequestBody  ResumeCoverLetter resumeCoverLetter)  {
		
		return ResponseEntity.ok(this.resumeCoverLetterService.delete(resumeCoverLetter));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	    ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		
		Map<String, String> validationErrors = new HashMap<String, String>();
		
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors= new ErrorDataResult<Object>(validationErrors,"Doğrulama Hataları");
		
		return errors;
	}
}

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

import kodlamaio.hrms.business.abstracts.ResumeLanguageService;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResumeLanguage;

@RestController
@RequestMapping("/api/resumeLanguageController")
public class ResumeLanguageController {
	private ResumeLanguageService resumeLanguageService;
	@Autowired
	public ResumeLanguageController(ResumeLanguageService resumeLanguageService) {
		// XXX Auto-generated constructor stub
		this.resumeLanguageService=resumeLanguageService;
	}
	
	@GetMapping(value="/getAll")
	public ResponseEntity<?> getAll()  {
		
		return ResponseEntity.ok(this.resumeLanguageService.getAll());
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ResumeLanguage resumeLanguage) {
		
		return this.resumeLanguageService.add(resumeLanguage);
	}
	
	@PostMapping(value="/update")
	public ResponseEntity<?> update(@Valid @RequestBody  ResumeLanguage resumeLanguage)  {
		
		return ResponseEntity.ok(this.resumeLanguageService.update(resumeLanguage));
	}
	
	
	
	@PostMapping(value="/delete")
	public ResponseEntity<?> delete(@Valid @RequestBody  ResumeLanguage resumeLanguage)  {
		
		return ResponseEntity.ok(this.resumeLanguageService.delete(resumeLanguage));
	}
	
	@GetMapping(value="/getByResumeLanguageId")
	public ResponseEntity<?> getByLanguageId(int id)  {
		
		return ResponseEntity.ok(this.resumeLanguageService.getByLanguageId(id));
	}
	
	@GetMapping(value="/getAllByCandidate_id")
	public ResponseEntity<?> getAllByCandidate_id(int id)  {
		
		return ResponseEntity.ok(this.resumeLanguageService.getAllByCandidate_id(id));
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

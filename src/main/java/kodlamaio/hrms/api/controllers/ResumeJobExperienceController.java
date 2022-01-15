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

import kodlamaio.hrms.business.abstracts.ResumeJobExperienceService;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResumeJobExperience;

@RestController
@RequestMapping("/api/resumeJobExperience")
public class ResumeJobExperienceController {
	
	private ResumeJobExperienceService resumeJobExperienceService;
	@Autowired
	public ResumeJobExperienceController(ResumeJobExperienceService resumeJobExperienceService) {
		this.resumeJobExperienceService=resumeJobExperienceService;
	}
	
	@GetMapping(value="/getAll")
	public ResponseEntity<?> getAll()  {
		
		return ResponseEntity.ok(this.resumeJobExperienceService.getAll());
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody ResumeJobExperience resumeJobExperience) {
		
		return this.resumeJobExperienceService.add(resumeJobExperience);
	}
	
	
	
	@PostMapping(value="/update")
	public ResponseEntity<?> update(@Valid @RequestBody  ResumeJobExperience resumeJobExperience)  {
		
		return ResponseEntity.ok(this.resumeJobExperienceService.update(resumeJobExperience));
	}
	
	
	
	@PostMapping(value="/delete")
	public ResponseEntity<?> delete(@Valid @RequestBody  ResumeJobExperience resumeJobExperience)  {
		
		return ResponseEntity.ok(this.resumeJobExperienceService.delete(resumeJobExperience));
	}
	
	
	
	@GetMapping(value="/getByResumeJobExperienceId")
	public ResponseEntity<?> getByResumeJobExperienceId(int id)  {
		
		return ResponseEntity.ok(this.resumeJobExperienceService.getByResumeJobExperienceId(id));
	}
	
	@GetMapping(value="/getAllByCandidate_idOrderByEndYearDesc")
	public ResponseEntity<?> getAllByCandidate_idOrderByEndYearDesc(int id)  {
		
		return ResponseEntity.ok(this.resumeJobExperienceService.getAllByCandidate_idOrderByEndYearDesc(id));
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

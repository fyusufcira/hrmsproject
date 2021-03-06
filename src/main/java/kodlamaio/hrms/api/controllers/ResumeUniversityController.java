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
import kodlamaio.hrms.business.abstracts.ResumeUniversityService;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.ResumeUniversity;

@RestController
@RequestMapping("/api/resumeUniversity")
public class ResumeUniversityController {
	private ResumeUniversityService resumeUniversityService;
	@Autowired
	public ResumeUniversityController(ResumeUniversityService resumeUniversityService) {
		// XXX Auto-generated constructor stub
		this.resumeUniversityService=resumeUniversityService;
	}
	
	@GetMapping(value="/getAll")
	public ResponseEntity<?> getAll()  {
		
		return ResponseEntity.ok(this.resumeUniversityService.getAll());
	}
	
	@GetMapping(value="/getByUniversityId")
	public ResponseEntity<?> getByUniversityId(int id)  {
		
		return ResponseEntity.ok(this.resumeUniversityService.getByUniversityId(id));
	}
	
	@GetMapping(value="/getAllByCandidate_idOrderByGraduationYearAsc")
	public ResponseEntity<?> getAllByCandidate_idOrderByGraduationYearAsc(int id)  {
		
		return ResponseEntity.ok(this.resumeUniversityService.getAllByCandidate_idOrderByGraduationYearAsc(id));
	}
	@GetMapping(value="/getAllByCandidate_idOrderByGraduationYearDesc")
	public ResponseEntity<?> getAllByCandidate_idOrderByGraduationYearDesc(int id)  {
		
		return ResponseEntity.ok(this.resumeUniversityService.getAllByCandidate_idOrderByGraduationYearDesc(id));
	}

		
	@PostMapping(value="/update")
	public ResponseEntity<?> update(@Valid @RequestBody ResumeUniversity resumeUniversity)  {
		
		return ResponseEntity.ok(this.resumeUniversityService.update(resumeUniversity));
	}
	
	@PostMapping(value="/add")
	public ResponseEntity<?> add(@Valid @RequestBody ResumeUniversity resumeUniversity)  {
		
		return ResponseEntity.ok(this.resumeUniversityService.add(resumeUniversity));
	}
	
	@PostMapping(value="/delete")
	public ResponseEntity<?> delete(@Valid @RequestBody  ResumeUniversity resumeUniversity)  {
		
		return ResponseEntity.ok(this.resumeUniversityService.delete(resumeUniversity));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	    ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		
		Map<String, String> validationErrors = new HashMap<String, String>();
		
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors= new ErrorDataResult<Object>(validationErrors,"Do??rulama Hatalar??");
		
		return errors;
	}
	
}

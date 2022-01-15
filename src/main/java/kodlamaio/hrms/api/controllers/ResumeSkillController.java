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
import kodlamaio.hrms.business.abstracts.ResumeSkillService;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.ResumeSkill;

@RestController
@RequestMapping("/api/resumeSkill")
public class ResumeSkillController {
	
	private ResumeSkillService resumeSkillService;
	@Autowired
	public ResumeSkillController(ResumeSkillService resumeSkillService) {
		// XXX Auto-generated constructor stub
		this.resumeSkillService=resumeSkillService;
	}
	
	@GetMapping(value="/getAll")
	public ResponseEntity<?> getAll()  {
		
		return ResponseEntity.ok(this.resumeSkillService.getAll());
	}
	
	@GetMapping(value="/getBySkillId")
	public ResponseEntity<?> getBySkillId(int id)  {
		
		return ResponseEntity.ok(this.resumeSkillService.getBySkillId(id));
	}
	
	@GetMapping(value="/getAllByCandidate_id")
	public ResponseEntity<?> getAllByCandidate_id(int id)  {
		
		return ResponseEntity.ok(this.resumeSkillService.getAllByCandidateId(id));
	}

		
	@PostMapping(value="/update")
	public ResponseEntity<?> update(@Valid @RequestBody  ResumeSkill resumeSkill)  {
		
		return ResponseEntity.ok(this.resumeSkillService.update(resumeSkill));
	}
	
	@PostMapping(value="/add")
	public ResponseEntity<?> add(@Valid @RequestBody ResumeSkill resumeSkill)  {
		
		return ResponseEntity.ok(this.resumeSkillService.add(resumeSkill));
	}
	
	@PostMapping(value="/delete")
	public ResponseEntity<?> delete(@Valid @RequestBody  ResumeSkill resumeSkill)  {
		
		return ResponseEntity.ok(this.resumeSkillService.delete(resumeSkill));
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

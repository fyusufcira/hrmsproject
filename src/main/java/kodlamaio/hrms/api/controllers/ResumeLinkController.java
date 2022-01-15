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
import kodlamaio.hrms.business.abstracts.ResumeLinkService;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.ResumeLink;

@RestController
@RequestMapping("/api/resumeLink")
public class ResumeLinkController {
	
	private ResumeLinkService resumeLinkService;
	
	@Autowired
	public ResumeLinkController(ResumeLinkService resumeLinkService) {
		this.resumeLinkService=resumeLinkService;
	}
	
	@GetMapping(value="/getAll")
	public ResponseEntity<?> getAll()  {
		
		return ResponseEntity.ok(this.resumeLinkService.getAll());
	}
	
	@GetMapping(value="/getByLinkId")
	public ResponseEntity<?> getByLinkId(int id)  {
		
		return ResponseEntity.ok(this.resumeLinkService.getByLinkId(id));
	}
	
	@GetMapping(value="/getAllByCandidate_id")
	public ResponseEntity<?> getAllByCandidate_id(int id)  {
		
		return ResponseEntity.ok(this.resumeLinkService.getAllByCandidateId(id));
	}

		
	@PostMapping(value="/update")
	public ResponseEntity<?> update(@Valid @RequestBody  ResumeLink resumeLink)  {
		
		return ResponseEntity.ok(this.resumeLinkService.update(resumeLink));
	}
	
	@PostMapping(value="/add")
	public ResponseEntity<?> add(@Valid @RequestBody  ResumeLink resumeLink)  {
		
		return ResponseEntity.ok(this.resumeLinkService.add(resumeLink));
	}
	
	@PostMapping(value="/delete")
	public ResponseEntity<?> delete(@Valid @RequestBody  ResumeLink resumeLink)  {
		
		return ResponseEntity.ok(this.resumeLinkService.delete(resumeLink));
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

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
import kodlamaio.hrms.business.abstracts.ResumePhotoService;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.ResumePhoto;

@RestController
@RequestMapping("/api/resumePhoto")
public class ResumePhotoController {
	
	private ResumePhotoService resumePhotoService;
	@Autowired
	public ResumePhotoController(ResumePhotoService resumePhotoService) {
		// XXX Auto-generated constructor stub
		this.resumePhotoService=resumePhotoService;
	}
	
	@GetMapping(value="/getAll")
	public ResponseEntity<?> getAll()  {
		
		return ResponseEntity.ok(this.resumePhotoService.getAll());
	}
	
	@GetMapping(value="/getByPhotoId")
	public ResponseEntity<?> getByPhotokId(int id)  {
		
		return ResponseEntity.ok(this.resumePhotoService.getByPhotoId(id));
	}
	
	@GetMapping(value="/getByCandidate_id")
	public ResponseEntity<?> getByCandidate_id(int id)  {
		
		return ResponseEntity.ok(this.resumePhotoService.getByCandidateId(id));
	}

		
	@PostMapping(value="/update")
	public ResponseEntity<?> update(@Valid @RequestBody  ResumePhoto resumePhoto)  {
		
		return ResponseEntity.ok(this.resumePhotoService.update(resumePhoto));
	}
	
	@PostMapping(value="/add")
	public ResponseEntity<?> add(@Valid @RequestBody  ResumePhoto resumePhoto)  {
		
		return ResponseEntity.ok(this.resumePhotoService.add(resumePhoto));
	}
	
	@PostMapping(value="/delete")
	public ResponseEntity<?> delete(@Valid @RequestBody  ResumePhoto resumePhoto)  {
		
		return ResponseEntity.ok(this.resumePhotoService.delete(resumePhoto));
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

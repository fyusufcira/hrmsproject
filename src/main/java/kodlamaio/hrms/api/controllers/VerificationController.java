package kodlamaio.hrms.api.controllers;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms.business.abstracts.VerificationService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

@RestController
@RequestMapping
public class VerificationController {
	
	
	private VerificationService verificationService;

	public VerificationController(VerificationService verificationService) {
		super();
		this.verificationService = verificationService;
	}
		
	@PostMapping("/verificate")
	public Result Verificate() {
		this.verificationService.verificate();
		return new SuccessResult("Verificated.");
	}

}

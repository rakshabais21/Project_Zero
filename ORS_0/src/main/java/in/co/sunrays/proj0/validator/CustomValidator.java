package in.co.sunrays.proj0.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

// TODO: Auto-generated Javadoc
/**
 * The Class CustomValidator.
 */
public class CustomValidator implements ConstraintValidator<Custom, String>{
	
	/** The regex. */
	private String regex;
	
	/**
	 * Initialize.
	 *
	 * @param constraintAnnotation the constraint annotation
	 */
	public void initialize(Custom constraintAnnotation) {
		
		this.regex=constraintAnnotation.regex();	
	}

	/**
	 * Checks if is valid.
	 *
	 * @param value the value
	 * @param context the context
	 * @return true, if is valid
	 */
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null||value.toString().trim()==""){
			context.disableDefaultConstraintViolation();
			return true;
		} else if((value!=null||value.toString().trim()!="")&&value.matches(regex)) return true;
        //return false if nothing matches the input
        else return false;
	}

}

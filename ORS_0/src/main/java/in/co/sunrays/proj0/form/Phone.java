package in.co.sunrays.proj0.form;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import javax.validation.Constraint;
import javax.validation.Payload;

// TODO: Auto-generated Javadoc
/**
 * The Interface Phone.
 */
@Documented
@Constraint(validatedBy = PhoneValidator.class)
@Target( {ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public  @interface Phone {
	 
 	/**
 	 * Message.
 	 *
 	 * @return the string
 	 */
 	String message() default "{in.co.sunrays.proj0.form.PhoneValidator."+"message}";
	                           //{in.co.sunrays.proj0.form.PhoneValidator."+"message}
	                         /**
                           	 * Regex.
                           	 *
                           	 * @return the string
                           	 */
                           	// to read message from properties file
     String regex() default "\\d{10}";
	    
    	/**
    	 * Groups.
    	 *
    	 * @return the class[]
    	 */
    	Class<?>[] groups() default {};
	     
	    /**
    	 * Payload.
    	 *
    	 * @return the class<? extends payload>[]
    	 */
    	Class<? extends Payload>[] payload() default {};
}

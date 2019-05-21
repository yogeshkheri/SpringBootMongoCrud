package crud.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mongodb.MongoException;

@ControllerAdvice
public class ExceptionController {
 
    @ExceptionHandler(MongoException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionHandle handleValidationError(MongoException ex) {
     
        
        String defaultMessage = ex.getMessage();
        return new ExceptionHandle("same Name", defaultMessage);
    }
}
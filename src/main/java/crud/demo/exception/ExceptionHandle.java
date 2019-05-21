package crud.demo.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(content = Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExceptionHandle{
 
    private String errorCode;
    private String message;
 
    public ExceptionHandle(String errorCode, String message) {
        super();
        this.errorCode = errorCode;
        this.message = message;
    }
}
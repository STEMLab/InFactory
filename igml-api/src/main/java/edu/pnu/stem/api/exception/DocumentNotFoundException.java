package edu.pnu.stem.api.exception;
/**
 * 
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author hyung
 *
 */
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="requested Document is not found")
public class DocumentNotFoundException extends NullPointerException {

}

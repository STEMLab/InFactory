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
@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Document is not created")
public class UndefinedDocumentException extends NullPointerException {

}

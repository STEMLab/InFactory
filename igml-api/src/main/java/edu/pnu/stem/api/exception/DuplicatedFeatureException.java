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
@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Attempt to create Feature that has same key")
public class DuplicatedFeatureException extends RuntimeException {

}

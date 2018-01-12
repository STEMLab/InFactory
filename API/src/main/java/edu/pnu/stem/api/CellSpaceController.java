/**
 * 
 */
package edu.pnu.stem.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import edu.pnu.stem.feature.CellSpace;

/**
 * @author hyung
 *
 */
@Controller
public class CellSpaceController {
	
	@PostMapping(value = "/cellspace")
	public ResponseEntity<?> createCellSpace(@RequestBody CellSpace cellSpace) {

		//customerDAO.create(customer);

		return new ResponseEntity(null, HttpStatus.OK);
	}
	
}

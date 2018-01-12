/**
 * 
 */
package edu.pnu.stem.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import edu.pnu.stem.dao.IndoorFeaturesDAO;
import edu.pnu.stem.feature.IndoorFeatures;

/**
 * @author hyung
 *
 */
@Controller
public class IndoorFeaturesController {

	@PostMapping(value = "/indoorfeatures")
	public ResponseEntity<IndoorFeatures> createIndoorFeatures(@RequestBody IndoorFeatures indoorfeatures) {
		IndoorFeaturesDAO.createIndoorFeatures(docId, parentID, ID, primalSpaceFeatures, multiLayeredGraph)
		return new ResponseEntity<IndoorFeatures>(indoorfeatures, HttpStatus.OK);
	}
	
}

/**
 * 
 */
package edu.pnu.stem.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author hyung
 *
 */

@Controller
public class CalculatorController {
	@RequestMapping(value = "/calc/{op}/{left}/{right}", method = RequestMethod.GET)
	@ResponseBody
	public Calculation calculate(@PathVariable("op") String op, @PathVariable("left") Integer left,
			@PathVariable("right") Integer right) {
		Calculation result = new Calculation();
		result.setOperation(op);
		result.setLeft(left);
		result.setRight(right);
		return doCalc(result);
	}

	@RequestMapping(value = "/calc2", method = RequestMethod.POST)
	@ResponseBody
	public Calculation calculate(@RequestBody Calculation calc) {
		return doCalc(calc);
	}

	private Calculation doCalc(Calculation c) {
		String op = c.getOperation();
		int left = c.getLeft();
		int right = c.getRight();
		if (op.equalsIgnoreCase("subtract")) {
			c.setResult(left - right);
		} else if (op.equalsIgnoreCase("multiply")) {
			c.setResult(left * right);
		} else if (op.equalsIgnoreCase("divide")) {
			c.setResult(left / right);
		} else {
			c.setResult(left + right);
		}
		return c;
	}
	
	public class Calculation {
		private String op;
		private Integer left;
		private Integer right;
		private Integer result;
		
		public String getOperation() {
			return op;
		}
		public void setOperation(String op) {
			this.op = op;
		}
		public Integer getLeft() {
			return left;
		}
		public void setLeft(Integer left) {
			this.left = left;
		}
		public Integer getRight() {
			return right;
		}
		public void setRight(Integer right) {
			this.right = right;
		}
		public Integer getResult() {
			return result;
		}
		public void setResult(Integer result) {
			this.result = result;
		}
	}
}
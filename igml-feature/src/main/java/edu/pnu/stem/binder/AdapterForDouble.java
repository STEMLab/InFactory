package edu.pnu.stem.binder;


import java.math.BigDecimal;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class AdapterForDouble
    extends XmlAdapter<BigDecimal, Double>
{

	@Override
	public Double unmarshal(BigDecimal v) throws Exception {
		return new Double(v.toString());
	}

	@Override
	public BigDecimal marshal(Double v) throws Exception {
		return new BigDecimal(v.toString());
	}

}

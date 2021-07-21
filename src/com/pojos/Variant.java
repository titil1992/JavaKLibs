package com.pojos;

import com.annotations.JField;

public class Variant {
	@JField
	private int variantNo;
	
	@JField
	private String variantName;

	public int getVariantNo() {
		return variantNo;
	}

	public void setVariantNo(int variantNo) {
		this.variantNo = variantNo;
	}

	public String getVariantName() {
		return variantName;
	}

	public void setVariantName(String variantName) {
		this.variantName = variantName;
	}

	public Variant(int variantNo, String variantName) {
		super();
		this.variantNo = variantNo;
		this.variantName = variantName;
	}
	
	
}

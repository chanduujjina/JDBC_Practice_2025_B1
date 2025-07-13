package com.coolcoder.demo;

import java.io.FileInputStream;
import java.io.FileReader;

public class Documents {
	
	private Integer docId;
	
	private String docName;
	
	private String docType;
	
	private FileInputStream imageData;
	
	private FileReader textData;
	
	
	public Integer getDocId() {
		return docId;
	}

	public void setDocId(Integer docId) {
		this.docId = docId;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public FileInputStream getImageData() {
		return imageData;
	}

	public void setImageData(FileInputStream imageData) {
		this.imageData = imageData;
	}

	public FileReader getTextData() {
		return textData;
	}

	public void setTextData(FileReader textData) {
		this.textData = textData;
	}

	public Documents(Integer docId, String docName, String docType, FileInputStream imageData, FileReader textData) {
		super();
		this.docId = docId;
		this.docName = docName;
		this.docType = docType;
		this.imageData = imageData;
		this.textData = textData;
	}

	@Override
	public String toString() {
		return "Documents [docId=" + docId + ", docName=" + docName + ", docType=" + docType + ", imageData="
				+ imageData + ", textData=" + textData + "]";
	}


}

package com.prueba.dto.Dto;



public class PersonasDto {
	
	Integer id;
	String documentType;
	String document;
	String fullName;
	
	
	public PersonasDto(Integer id, String documentType, String document, String fullName) {
		this.id = id;
		this.documentType = documentType;
		this.document = document;
		this.fullName = fullName;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDocumentType() {
		return documentType;
	}


	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}


	public String getDocument() {
		return document;
	}


	public void setDocument(String document) {
		this.document = document;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	
	
}

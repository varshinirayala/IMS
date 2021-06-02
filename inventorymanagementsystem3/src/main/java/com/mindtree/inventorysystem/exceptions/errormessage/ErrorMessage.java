package com.mindtree.inventorysystem.exceptions.errormessage;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorMessage {
	private int errorCode;
	private String message;
	private Date date;
}

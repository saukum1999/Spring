package com.luv2code.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstrainValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
	
//	define default CourseCode value
	public String value() default "SAU";

//	define default CourseCode message
	public String message() default "must start with SAU";
	
//	define default groups
	public Class<?>[] groups() default{};
//	define default CourseCode payloade
	public Class<? extends Payload>[] payload() default {} ;
}

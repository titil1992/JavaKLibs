package com.annotations;


import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(ElementType.FIELD)
public @interface JField {
	public String value() default "";
	public boolean aggregation() default false;
	public boolean listify() default false;
	public boolean mapify() default false;
}

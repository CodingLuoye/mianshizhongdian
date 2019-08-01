package com.self.reflect.aspect;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 注解
 * @author YCKJ1409
 */
@Retention(RUNTIME)
@Target(TYPE)
public @interface Aspect {
	Class<?>[] value();
}

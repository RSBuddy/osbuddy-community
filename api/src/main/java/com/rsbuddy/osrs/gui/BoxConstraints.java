package com.rsbuddy.osrs.gui;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface BoxConstraints {
	int width() default -1; // just the max height, if -1 then WIDE
	int height() default -1; // just the max height, if -1 then BIG
	BoxLocation location() default BoxLocation.LEFT; // one of BoxLocation
}

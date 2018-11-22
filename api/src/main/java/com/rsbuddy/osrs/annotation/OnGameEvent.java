package com.rsbuddy.osrs.annotation;

import com.rsbuddy.osrs.game.GameEvent;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface OnGameEvent {
    GameEvent value();
    boolean requireLoggedIn() default true;
}

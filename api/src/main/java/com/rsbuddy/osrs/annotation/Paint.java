package com.rsbuddy.osrs.annotation;

import com.rsbuddy.osrs.game.ui.PaintHook;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Paint {
    PaintHook value();
}

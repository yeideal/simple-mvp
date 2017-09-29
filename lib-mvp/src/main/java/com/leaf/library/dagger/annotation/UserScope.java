package com.leaf.library.dagger.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by ye on 2016/4/14.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface UserScope {
}

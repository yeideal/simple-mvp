package com.leaf.library.dagger.annotation;

/**
 * Created by ye on 2016/4/13.
 */

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {
}

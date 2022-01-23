package org.roadtosenior.springripper.infrastructure.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface InjectRandomInt {

  int min();
  int max();
}

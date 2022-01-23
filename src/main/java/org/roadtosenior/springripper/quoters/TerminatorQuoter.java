package org.roadtosenior.springripper.quoters;

import lombok.Setter;
import org.roadtosenior.springripper.infrastructure.annotations.InjectRandomInt;
import org.roadtosenior.springripper.infrastructure.annotations.PostProxy;
import org.roadtosenior.springripper.infrastructure.annotations.Profiling;

@Setter
@Profiling
public class TerminatorQuoter implements Quoter {

  @InjectRandomInt(min = 2, max = 7)
  private int repeat;

  private String message;

  public TerminatorQuoter() {
    System.out.println("Phase 1 - Constructor");
  }

  public void init() {
    System.out.println("Phase 2 - init() method");
    System.out.println("repeat = " + repeat);
  }

  @Override
  @PostProxy
  public void sayQuote() {
    for (int i = 0; i < repeat; i++) {
      System.out.println("message = " + message);
    }
  }
}

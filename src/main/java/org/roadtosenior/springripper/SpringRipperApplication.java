package org.roadtosenior.springripper;

import org.roadtosenior.springripper.quoters.Quoter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringRipperApplication {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
//      context.getBean(Quoter.class).sayQuote();
  }
}

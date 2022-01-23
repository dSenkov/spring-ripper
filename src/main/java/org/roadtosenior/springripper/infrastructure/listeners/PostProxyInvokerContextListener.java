package org.roadtosenior.springripper.infrastructure.listeners;

import org.roadtosenior.springripper.infrastructure.annotations.PostProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.lang.reflect.Method;

public class PostProxyInvokerContextListener implements ApplicationListener<ContextRefreshedEvent> {

  @Autowired
  private ConfigurableListableBeanFactory beanFactory;

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    System.out.println("Phase 3 - on ContextRefreshedEvent");
    ApplicationContext context = event.getApplicationContext();
    for (String name : context.getBeanDefinitionNames()) {
      BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
      String originalClassName = beanDefinition.getBeanClassName();
      try {
        Class<?> originalClass = Class.forName(originalClassName);
        for (Method method : originalClass.getMethods()) {
          if (method.isAnnotationPresent(PostProxy.class)) {
            Object beanProxy = context.getBean(name);
            Method currentMethod = beanProxy.getClass().getMethod(method.getName(), method.getParameterTypes());
            currentMethod.invoke(beanProxy);
          }
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}

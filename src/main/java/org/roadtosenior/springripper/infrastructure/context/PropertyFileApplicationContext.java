package org.roadtosenior.springripper.infrastructure.context;

import org.roadtosenior.springripper.quoters.Quoter;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

public class PropertyFileApplicationContext extends GenericApplicationContext {

    public PropertyFileApplicationContext(String fileName) {
        PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(this);
        int beansAmount = reader.loadBeanDefinitions(fileName);
        System.out.println("Found " + beansAmount + " beans.");
        refresh();
    }

    public static void main(String[] args) {
        PropertyFileApplicationContext context = new PropertyFileApplicationContext("context.properties");
        context.getBean(Quoter.class).sayQuote();
    }
}

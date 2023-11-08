package dev.n9mac.pharaoh.learncorespringframework.ch01iocc

import org.springframework.beans.factory.groovy.GroovyBeanDefinitionReader
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader
import org.springframework.context.ApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext
import org.springframework.context.support.GenericApplicationContext
import org.springframework.context.support.GenericGroovyApplicationContext
import spock.lang.Specification

class ApplicationContextTestSpecification extends Specification {

    def "should ApplicationContext create simple Bean base on  XML-based configuration"() {
        given:
        ApplicationContext appContext = new ClassPathXmlApplicationContext("/ch01iocc/ctx-01.xml")

        when:
        Mbean1 mbean1 = appContext.getBean("mbean1",Mbean1.class)

        then:
        mbean1.getMbeanName() == "Mbean1"
        mbean1.getNames() == "Mbean2-->Mbean3-->Mbean1"
    }


    def "should ApplicationContext create simple Bean base on  Groovy-based configuration"() {
        given:
        ApplicationContext appContext = new GenericGroovyApplicationContext("/ch01iocc/ctx-01.groovy")

        when:
        Mbean1 mbean1 = appContext.getBean("mbean1",Mbean1.class)

        then:
        mbean1.getMbeanName() == "Mbean1"
        mbean1.getNames() == "Mbean2-->Mbean3-->Mbean1"
    }

    def "should ApplicationContext create simple Bean base on combined Groovy-based and XML configurations"() {
        given:
        GenericApplicationContext appContext = new GenericApplicationContext();
        // load partial configuration in Groovy DSL format
        new GroovyBeanDefinitionReader(appContext).loadBeanDefinitions("/ch01iocc/ctx-01-partial.groovy")
        // Load partial configuration in XML format
        new XmlBeanDefinitionReader(appContext).loadBeanDefinitions("/ch01iocc/ctx-01-partial.xml")
        appContext.refresh()

        when:
        Mbean1 mbean1 = appContext.getBean("mbean1",Mbean1.class)

        then:
        mbean1.getMbeanName() == "Mbean1"
        mbean1.getNames() == "Mbean2-->Mbean3-->Mbean1"
    }
}
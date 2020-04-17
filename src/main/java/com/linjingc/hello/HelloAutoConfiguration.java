package com.linjingc.hello;

import com.linjingc.hello.config.HelloProperties;
import com.linjingc.hello.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//当类路径classpath下有指定的类的情况下进行自动配置
@ConditionalOnClass(HelloService.class)
//开启读取自动配置
@EnableConfigurationProperties(HelloProperties.class)
//如果获取不到属性配置 则使用默认的
@ConditionalOnProperty(prefix = "spring.hello", value = "enabled", matchIfMissing = true)
public class HelloAutoConfiguration {
	@Autowired
	private HelloProperties properties;


	@Bean
	//// 当Spring Context中不存在该Bean时，自动配置HelloService类
	@ConditionalOnMissingBean(HelloService.class)
	public HelloService helloService() {
		HelloService helloService = new HelloService(properties);
		return helloService;
	}
	/**
	 * @See @ConditionalOnClass：当类路径classpath下有指定的类的情况下进行自动配置
	 *
	 * @See @ConditionalOnMissingBean:当容器(Spring Context)中没有指定Bean的情况下进行自动配置
	 *
	 * @See @ConditionalOnProperty(prefix = “example.service”, value = “enabled”, matchIfMissing = true)，当配置文件中example.service.enabled=true时进行自动配置，如果没有设置此值就默认使用matchIfMissing对应的值
	 *
	 * @See @ConditionalOnMissingBean，当Spring Context中不存在该Bean时。
	 *
	 * @See @ConditionalOnBean:当容器(Spring Context)中有指定的Bean的条件下
	 *
	 * @See @ConditionalOnMissingClass:当类路径下没有指定的类的条件下
	 *
	 *  @See @ConditionalOnExpression:基于SpEL表达式作为判断条件
	 *
	 * @See @ConditionalOnJava:基于JVM版本作为判断条件
	 *
	 * @See @ConditionalOnJndi:在JNDI存在的条件下查找指定的位置
	 *
	 * @See @ConditionalOnNotWebApplication:当前项目不是Web项目的条件下
	 *
	 * @See @ConditionalOnWebApplication:当前项目是Web项目的条件下
	 *
	 * @See @ConditionalOnResource:类路径下是否有指定的资源
	 *
	 * @See @ConditionalOnSingleCandidate:当指定的Bean在容器中只有一个，或者在有多个Bean的情况下，用来指定首选的Bean
	 */
}

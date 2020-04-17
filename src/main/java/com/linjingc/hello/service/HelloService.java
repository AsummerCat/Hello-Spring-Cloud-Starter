package com.linjingc.hello.service;

import com.linjingc.hello.config.HelloProperties;

public class HelloService {
	private HelloProperties helloProperties;

	public HelloService(HelloProperties helloProperties) {
		this.helloProperties = helloProperties;
	}

	public String heelloWord() {
		String say = helloProperties.getName() + "对世界说" + "我" + helloProperties.getAge() + "岁了" + ",来自" + helloProperties.getAddress();
		return say;
	}
}

package com.boot.interfaceDemo;

import org.springframework.stereotype.Component;

//@Component("MyImplA")
@Component					// @Component  kewal ye bhi likh skte hai, Yana pe @Component() ke brackets me if we don't write "MyImplA" then byDefault camelCase "myImplA" naam se obj bana dega; 
public class MyImplA implements InterfaceZ {

	@Override
	public void m1() {
		System.out.println(">>>>>>> Inside MyImplA method");
	}

	
}

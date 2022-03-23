package com.boot.interfaceDemo;

import org.springframework.stereotype.Component;

//@Component("MyImplB")
@Component					// @Component  kewal ye bhi likh skte hai, Yana pe @Component() ke brackets me if we don't write "MyImplB" then byDefault camelCase "myImplB" naam se obj bana dega; 
public class MyImplB implements InterfaceZ {

	@Override
	public void m1() {
		System.out.println(">>>>>>> Inside MyImplB method");
		
	}

}

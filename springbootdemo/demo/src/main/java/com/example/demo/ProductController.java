package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/products") //http://localhost:8080/products
////http://localhost:8080/products ==> ProductController prodObj=ioc.getProductController();
public class ProductController {


	@RequestMapping(value="/electronics")
	////http://localhost:8080/products/electronics===>prodObj.getElectronicProducts();
     public String getElectronicProducts() {
    	 return "Electrionis Products are ==> TV,WASHING MACHINE...";
     }


	@RequestMapping(value="/kids")
	////http://localhost:8080/products/electronics===>prodObj.getElectronicProducts();
     public String getKidsroducts() {
    	 return "Kids Products are ==> TOYS, DRESSES..";
     }

}

package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.example.model.Product;
import com.example.service.ShopService;

@RestController
public class ShopController {

		private final ShopService ShopService;

		@Autowired
		public ShopController(ShopService ShopService) {
			this.ShopService = ShopService;
		}

		@RequestMapping(value = "/getDiscount", method = RequestMethod.GET, produces = "application/json")
		public Product getDiscount(@RequestParam(required = true) Double value) throws IllegalArgumentException {
			
			if (value.equals(new Double(0l))) {
				throw new IllegalArgumentException("Argumento inválido");
			}
			
			/*
			 * try { Thread.sleep(5000); } catch (InterruptedException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 */
			
			Product product = new Product();
			product.setValue(value);
			ShopService.getProductDiscount(product);
			
			return product;
		}
		
		@ExceptionHandler({ IllegalArgumentException.class })
	    public ResponseEntity<Object> handleAccessDeniedException(
	      Exception ex, WebRequest request) {
	        return new ResponseEntity<Object>(
	          "Access denied message here", new HttpHeaders(), HttpStatus.BAD_REQUEST);
	    }
}

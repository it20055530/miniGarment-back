package com.example.demo.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Model.T_Order;
import com.example.demo.Repository.T_OrderRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class T_OrderController {
	
	@Autowired
	private T_OrderRepository t_orderrepository;
	
	//get all order
	@GetMapping("/orders")
	public List<T_Order> getAllOrder(){
		return t_orderrepository.findAll();
	}
	
	//create order api
	@PostMapping("/orders")
	public T_Order createOrder(@RequestBody T_Order t_order) {
		return t_orderrepository.save(t_order);
	}
	
	//get order by Id api
	@GetMapping("/orders/{id}")
	public ResponseEntity<T_Order> getOrderByID(@PathVariable Long id) {
		
		T_Order t_order = t_orderrepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Item not exist with id :" + id ));
		return ResponseEntity.ok(t_order);
	}
	
	//update order api
	@PutMapping("/orders/{id}")
	public ResponseEntity<T_Order> updateOrder(@PathVariable Long id,@RequestBody T_Order t_orderDetails){
		T_Order t_order = t_orderrepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Order not exist with id :" + id ));
		
		t_order.setId(t_orderDetails.getId());
		t_order.setDate(t_orderDetails.getDate());
		t_order.setSupplier(t_orderDetails.getSupplier());
		t_order.setItemcode(t_orderDetails.getItemcode());
		t_order.setItemname(t_orderDetails.getItemname());
		t_order.setQty(t_orderDetails.getQty());
		t_order.setUnit(t_orderDetails.getUnitprice());
		t_order.setTotalprice(t_orderDetails.getTotalprice());
		
		T_Order updatedOrder = t_orderrepository.save(t_order);
		return ResponseEntity.ok(updatedOrder);
		
	}
	
	//delete order
		@DeleteMapping("/orders/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteOrder(@PathVariable Long id){
			
			T_Order t_order = t_orderrepository.findById(id)
					.orElseThrow(()-> new ResourceNotFoundException("Item not exist with id :" + id ));
			
			t_orderrepository.delete(t_order);
			Map<String, Boolean> response = new HashMap<>();
			response.put("delete", Boolean.TRUE);
			return ResponseEntity.ok(response);
	
		}
}

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
import com.example.demo.Model.T_Stock;
import com.example.demo.Repository.T_StockRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class T_StockController {
	
	@Autowired
	private T_StockRepository t_stockrepository;
	
	//get all stock
	
	@GetMapping("/stocks")
	public List<T_Stock> getAllStocks(){
		return t_stockrepository.findAll();
	}
	
	//create stock api
	@PostMapping("/stocks")
	public T_Stock createStock(@RequestBody T_Stock t_stock) {
		return t_stockrepository.save(t_stock);
	}
	
	//get stock by Id api
	@GetMapping("/stocks/{itemcode}")
	public ResponseEntity<T_Stock> getStockByItemcode(@PathVariable String itemcode) {
		
		T_Stock t_stock = t_stockrepository.findById(itemcode)
				.orElseThrow(()-> new ResourceNotFoundException("Item not exist with item code :" + itemcode ));
		return ResponseEntity.ok(t_stock);
	}
	
	//update stock api
	@PutMapping("/stocks/{itemcode}")
	public ResponseEntity<T_Stock> updateStock(@PathVariable String itemcode,@RequestBody T_Stock t_stockitemDetails){
		T_Stock t_stock = t_stockrepository.findById(itemcode)
				.orElseThrow(()-> new ResourceNotFoundException("Item not exist with item code :" + itemcode ));
		
		t_stock.setItemcode(t_stockitemDetails.getItemcode());
		t_stock.setFabrictype(t_stockitemDetails.getFabrictype());
		t_stock.setColour(t_stockitemDetails.getColour());
		t_stock.setQty(t_stockitemDetails.getQty());
		t_stock.setReceivedqty(t_stockitemDetails.getReceivedqty());
		t_stock.setUsedqty(t_stockitemDetails.getUsedqty());
		t_stock.setDamagedqty(t_stockitemDetails.getDamagedqty());
		t_stock.setReturnqty(t_stockitemDetails.getReturnqty());
		t_stock.setPrice(t_stockitemDetails.getPrice());
		
		T_Stock updatedStock = t_stockrepository.save(t_stock);
		return ResponseEntity.ok(updatedStock);
		
	}
	
	//delete stock item
		@DeleteMapping("/stocks/{itemcode}")
		public ResponseEntity<Map<String, Boolean>> deleteStockItem(@PathVariable String itemcode){
			
			T_Stock t_stock = t_stockrepository.findById(itemcode)
					.orElseThrow(()-> new ResourceNotFoundException("Item not exist with item code :" + itemcode ));
			
			t_stockrepository.delete(t_stock);
			Map<String, Boolean> response = new HashMap<>();
			response.put("delete", Boolean.TRUE);
			return ResponseEntity.ok(response);
	
		}
}

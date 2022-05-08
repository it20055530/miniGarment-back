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
import com.example.demo.Model.C_Machine;
import com.example.demo.Repository.C_MachineRepository;

@CrossOrigin(origins = "http://localhost:3001")
@RestController
@RequestMapping("/api/v1")
public class C_MachineController {
	
	@Autowired
	private C_MachineRepository c_machinerepository;
	
	//get all machine
	
	@GetMapping("/machine")
	public List<C_Machine> getAllMachines(){
		return c_machinerepository.findAll();
	}
	
	//create machine api
	@PostMapping("/machines")
	public C_Machine createMachine(@RequestBody C_Machine c_machine) {
		return c_machinerepository.save(c_machine);
	}
	
	//get machine by Id api
	@GetMapping("/machines/{machinenumber}")
	public ResponseEntity<C_Machine> getMachineByMachinenumber(@PathVariable String machinenumber) {
		
		C_Machine c_machine = c_machinerepository.findById(machinenumber)
				.orElseThrow(()-> new ResourceNotFoundException("Machine not exist with machine number :" + machinenumber ));
		return ResponseEntity.ok(c_machine);
	}
	
	//update matchine api
	@PutMapping("/machines/{machinenumber}")
	public ResponseEntity<C_Machine> updateMachine(@PathVariable String machinenumber,@RequestBody C_Machine c_machinemachineDetails){
		C_Machine c_machine = c_machinerepository.findById(machinenumber)
				.orElseThrow(()-> new ResourceNotFoundException("Machine not exist with machine number :" + machinenumber ));
		
		c_machine.setMachinenumber(c_machinemachineDetails.getMachinenumber());
		c_machine.setMachinemodel(c_machinemachineDetails.getMachinemodel());
		c_machine.setDateoflastrepair(c_machinemachineDetails.getDateoflastrepair());
		c_machine.setDateofnextrepair(c_machinemachineDetails.getDateofnextrepair());
		c_machine.setReplacedparts(c_machinemachineDetails.getReplacedparts());
		c_machine.setRepaircharge(c_machinemachineDetails.getRepaircharge());
		
		C_Machine updatedMachine = c_machinerepository.save(c_machine);
		return ResponseEntity.ok(updatedMachine);
		
	}
	
	//delete machine
		@DeleteMapping("/machines/{machinenumber}")
		public ResponseEntity<Map<String, Boolean>> deleteMachine(@PathVariable String machinenumber){
			
			C_Machine c_machine = c_machinerepository.findById(machinenumber)
					.orElseThrow(()-> new ResourceNotFoundException("Machine not exist with machine number :" + machinenumber ));
			
			c_machinerepository.delete(c_machine);
			Map<String, Boolean> response = new HashMap<>();
			response.put("delete", Boolean.TRUE);
			return ResponseEntity.ok(response);
	
		}
}

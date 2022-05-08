package com.example.demo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Model.C_Machine;
@Repository
public interface C_MachineRepository extends JpaRepository<C_Machine, String>{}
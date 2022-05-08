package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.T_Stock;

@Repository
public interface T_StockRepository extends JpaRepository<T_Stock, String>{

}

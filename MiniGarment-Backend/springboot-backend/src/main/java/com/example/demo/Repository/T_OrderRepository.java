package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.T_Order;

@Repository
public interface T_OrderRepository  extends JpaRepository<T_Order, Long>{

}

package com.suswagata.Customer_Log.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.suswagata.Customer_Log.dto.CustomerDTO;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerDTO, String> {

	public ArrayList<CustomerDTO> findByDate(String date);

}

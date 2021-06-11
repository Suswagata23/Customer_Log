package com.suswagata.Customer_Log.Rest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.suswagata.Customer_Log.dto.CustomerDTO;
import com.suswagata.Customer_Log.repository.CustomerRepository;


@RestController
public class CustomerRestController{
	
	public static final Logger logger = LoggerFactory.getLogger(CustomerRestController.class);
	
	@Autowired
	CustomerRepository userJpaRepository;
	
	@GetMapping(value="/checkIn")
	public void checkin(@RequestParam("name") String name) {
		CustomerDTO logModel = new CustomerDTO();
		logModel.setName(name);
		logModel.setLogType("IN");
		logModel.setDate(LocalDate.now().toString());
		String time = LocalTime.now().toString();
		logModel.setTime(time);
		logModel.setId(name, time);
		userJpaRepository.save(logModel);
	}
	
	@GetMapping(value="/checkOut")
	public void checkout(@RequestParam("name") String name) {
		CustomerDTO logModel = new CustomerDTO();
		logModel.setName(name);
		logModel.setLogType("OUT");
		logModel.setDate(LocalDate.now().toString());
		String time = LocalTime.now().toString();
		logModel.setTime(time);
		logModel.setId(name, time);
		userJpaRepository.save(logModel);
	}
	
	@GetMapping(value="/getLog")
	public List<CustomerDTO> getLogByDate(String date){
		String[] dateComp = date.split("/");
		int year=Integer.parseInt(dateComp[0]),month=Integer.parseInt(dateComp[1]),dayOfMonth=Integer.parseInt(dateComp[2]);
		LocalDate localdate=LocalDate.of(year, month, dayOfMonth);
		List<CustomerDTO> logModel = new ArrayList<>();
		userJpaRepository.findByDate(localdate.toString()).forEach(logModel::add);
		return logModel;
	}
	
	@GetMapping(value="/getAllLog")
	public List<CustomerDTO> getAllLog(){
		List<CustomerDTO> logModel = new ArrayList<>();
		userJpaRepository.findAll().forEach(logModel::add);
		return logModel;
	}

}

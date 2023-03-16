package com.vtalent.insurance.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.vtalent.insurance.model.ActualYear;
import com.vtalent.insurance.model.Customer;
import com.vtalent.insurance.model.UsaZipInfo;
import com.vtalent.insurance.model.Year;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {

	@GetMapping("/")
	public String init(HttpServletRequest req, HttpServletResponse res) {
		return "vehicle";
	}
	
	@PostMapping("/success")
	public String success(HttpServletRequest req, HttpServletResponse res) {
		return "driver";
	}

}

package com.credmarg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credmarg.entity.Vendor;
import com.credmarg.repository.VendorRepository;

@Service
public class VendorService {

	@Autowired
	private VendorRepository vendorRepository;

	public Vendor save(Vendor vendor) {
		return vendorRepository.save(vendor);
	}

	public List<Vendor> findAll() {
		return vendorRepository.findAll();
	}

	public Vendor findById(String email) {
		return vendorRepository.findById(email).orElse(null);
	}
}

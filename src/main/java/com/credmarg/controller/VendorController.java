package com.credmarg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credmarg.entity.Vendor;
import com.credmarg.service.EmailService;
import com.credmarg.service.VendorService;

@RestController
@RequestMapping("/vendors")
public class VendorController {

	@Autowired
	private VendorService vendorService;
	@Autowired
	private EmailService emailService;

	@PostMapping
	public Vendor createVendor(@RequestBody Vendor vendor) {
		return vendorService.save(vendor);
	}

	@GetMapping
	public List<Vendor> getAllVendors() {
		return vendorService.findAll();
	}

	@PostMapping("/sendEmail")
	public void sendEmail(@RequestBody List<String> vendorEmails) {
		for (String email : vendorEmails) {
			Vendor vendor = vendorService.findById(email);
			if (vendor != null) {
				String subject = "Payment Notification";
				String body = String.format("Sending payments to vendor %s at UPI %s", vendor.getName(),
						vendor.getUpi());
				emailService.sendEmail(email, subject, body);
			}
		}
	}
}

package com.swift.ihikerz.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swift.ihikerz.models.Hiker;
import com.swift.ihikerz.repositories.HikerRepository;

@RestController
@RequestMapping("/api/hiker")
@CrossOrigin(origins = "http://localhost:4200")
public class HikerController {

	@Autowired
	private HikerRepository hikerRepository;

	@GetMapping
	public List<Hiker> findAllHikers() {
		return hikerRepository.findAll();
	}

	@PostMapping
	public Hiker submit(@Validated @RequestBody Hiker hiker) {
		hiker.setStatus("APPROVED");
		hiker.setSubmitDate(new Date(System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(30)));
		return hikerRepository.save(hiker);

	}

	@GetMapping("/{name}")
	public List<Hiker> findByName(@PathVariable(value = "name") String name) {

		if (!StringUtils.hasText(name)) {
			return Collections.emptyList();
		}
		List<Hiker> hikers = hikerRepository.findAll();
		if (!CollectionUtils.isEmpty(hikers)) {
			List<Hiker> results = new ArrayList<>();
			for (Hiker hiker : hikers) {
				if (hiker.getName().equalsIgnoreCase(name)) {
					Date now = new Date();
					if (!"CANCELLED".equalsIgnoreCase(hiker.getStatus()) && now.after(hiker.getSubmitDate())) {
						hiker.setStatus("APPROVED");
						hikerRepository.save(hiker);
					}
					results.add(hiker);
				}
			}
			return results;
		}

		return Collections.emptyList();

	}

	@PutMapping("/cancel")
	public void cancelPermit(@Validated @RequestBody Hiker hiker) {
		List<Hiker> allHikers = hikerRepository.findAll();

		if (!CollectionUtils.isEmpty(allHikers)) {

			for (Hiker eachHiker : allHikers) {
				if (hiker.getName().equalsIgnoreCase(eachHiker.getName())) {
					eachHiker.setStatus("CANCELLED");
					hikerRepository.save(eachHiker);
				}
			}
		}
	}

}

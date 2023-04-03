package com.mvc.saveTravel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.saveTravel.models.Travel;
import com.mvc.saveTravel.repositories.TravelRepository;

@Service
public class TravelService {

	@Autowired
	private TravelRepository  tRepo;
	
	public List<Travel> getAllTravel() {
		return tRepo.findAll();
	}
	
	public Travel createTravel(Travel travel) {
		return tRepo.save(travel);
	}
	
	public Travel getTravelById(Long id) {
		
		Optional<Travel> t = tRepo.findById(id);
		if (t.isPresent()) {
			return t.get();
		}
		return null;
	}
	
	public void deleteById(Long id) {
		tRepo.deleteById(id);
	}
}

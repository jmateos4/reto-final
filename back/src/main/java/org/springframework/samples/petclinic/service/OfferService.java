package org.springframework.samples.petclinic.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Offer;
import org.springframework.samples.petclinic.repository.OfferRepository;
import org.springframework.stereotype.Service;

@Service
public class OfferService{
	
	@Autowired
	OfferRepository offerRepository;
	
	public List<Offer> findAll(){
		return this.offerRepository.findAll();
	}
	
	public Offer findById(Integer id){
		return this.offerRepository.getOne(id);
	}
	
	public void delete(Integer id){
		
		if(this.findById(id) != null) {
			this.offerRepository.delete(id);
		}
	}
	
	public Offer addOffer(Offer o){
		return this.offerRepository.save(o);
	}
	
	public List<Offer> getValids(){
		return this.offerRepository.findByExpireDateAfter(new Date());
	}
}

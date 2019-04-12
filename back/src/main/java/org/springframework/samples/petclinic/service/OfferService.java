package org.springframework.samples.petclinic.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Offer;
import org.springframework.samples.petclinic.repository.OfferRepository;
import org.springframework.stereotype.Service;

@Service
public class OfferService {

	@Autowired
	private OfferRepository or;
	
	public Offer findOne(Integer id) {
		return or.findOne(id);
	}
	
	public List <Offer> findAllOffers() {
		return or.findAll();
	}
	
	public Offer createOffer(Offer offer) {
		return or.save(offer);
	}
	
	public void deleteOffer(Integer id) {
		if (or.findOne(id) != null) {
			or.delete(id);
		}
	}
	
	public void updateOffer(Integer id) {
		Offer of = or.findOne(id);
		if ( or.findOne(id) != null) {
			or.save(of);
		} else {
			
		}
	}
	
	public List <Offer> findNextOfferByExpireDate() {
		return or.findByExpireDateAfter(new Date());
	}
	
	
	

}

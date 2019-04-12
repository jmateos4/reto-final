package org.springframework.samples.petclinic.rest;

import java.util.Collection;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.model.Offer;
import org.springframework.samples.petclinic.service.OfferService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
@RequestMapping("/api/offers")
public class OfferRestController {

	@Autowired
	private OfferService os;
	
	// Listar todas las ofertas
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Collection<Offer>> getOfferList() {
		Collection<Offer> offers = this.os.findAllOffers();
		if (offers.isEmpty()) {
			return new ResponseEntity<Collection<Offer>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Collection<Offer>>(offers, HttpStatus.OK);
	}
	
	// Encontrar una oferta por Id
	@RequestMapping(value = "/{offerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Offer> getOffer(@PathVariable("offerId") int offerId) {
		Offer offer = null;
		offer = this.os.findOne(offerId);
		if (offer == null) {
			return new ResponseEntity<Offer>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Offer>(offer, HttpStatus.OK);
	}
	
	// Añadir oferta
	@RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Offer> addOffer(@RequestBody @Valid Offer offer, BindingResult bindingResult,
			UriComponentsBuilder ucBuilder) {
		BindingErrorsResponse errors = new BindingErrorsResponse();
		HttpHeaders headers = new HttpHeaders();
		if (bindingResult.hasErrors() || (offer == null)) {
			errors.addAllErrors(bindingResult);
			headers.add("errors", errors.toJSON());
			return new ResponseEntity<Offer>(headers, HttpStatus.BAD_REQUEST);
		}
		this.os.createOffer(offer);
		headers.setLocation(ucBuilder.path("/api/offers/{id}").buildAndExpand(offer.getId()).toUri());
		return new ResponseEntity<Offer>(offer, headers, HttpStatus.CREATED);
	}
	

	// Actualizar oferta a partir del Id
	@RequestMapping(value = "/{offerId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Offer> updateOffer(@PathVariable("offerId") int offerId, @RequestBody @Valid Offer offer,
			BindingResult bindingResult, UriComponentsBuilder ucBuilder) {
		BindingErrorsResponse errors = new BindingErrorsResponse();
		HttpHeaders headers = new HttpHeaders();
		if (bindingResult.hasErrors() || (offer == null)) {
			errors.addAllErrors(bindingResult);
			headers.add("errors", errors.toJSON());
			return new ResponseEntity<Offer>(headers, HttpStatus.BAD_REQUEST);
		}
		Offer currentOffer = this.os.findOne(offerId);
		if (currentOffer == null) {
			return new ResponseEntity<Offer>(HttpStatus.NOT_FOUND);
		}
		currentOffer.setTitle(offer.getTitle());
		currentOffer.setDescription(offer.getDescription());
		currentOffer.setDiscount(offer.getDiscount());
		currentOffer.setExpireDate(offer.getExpireDate());
		this.os.createOffer(currentOffer);
		return new ResponseEntity<Offer>(currentOffer, HttpStatus.NO_CONTENT);
	}
	
	//  Borrar oferta a partir del Id
		@RequestMapping(value = "/{ownerId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		@Transactional
		public ResponseEntity<Void> deleteOffer(@PathVariable("offerId") int offerId) {
			Offer offer = this.os.findOne(offerId);
			if (offer == null) {
				return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
			this.os.deleteOffer(offer.getId());
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	 
	// Listar las fechas a partir del dia de hoy
	 @RequestMapping(value = "/valids", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public ResponseEntity<Collection<Offer>> getValidsOffers() {
			Collection<Offer> offers = this.os.findNextOfferByExpireDate();
			if (offers.isEmpty()) {
				return new ResponseEntity<Collection<Offer>>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Collection<Offer>>(offers, HttpStatus.OK);
		}
	
	


}

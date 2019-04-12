package org.springframework.samples.petclinic.repository;

<<<<<<< HEAD

=======
>>>>>>> fa5bec2bcbe771042e5f61992d848b9e1d02f5de
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.petclinic.model.Offer;

<<<<<<< HEAD
public interface OfferRepository extends JpaRepository<Offer, Integer> {
	
	List<Offer> findByExpireDateAfter(Date now);
=======
public interface OfferRepository extends JpaRepository<Offer,Integer> {
	
	List<Offer> findByExpireDateAfter(Date today);
>>>>>>> fa5bec2bcbe771042e5f61992d848b9e1d02f5de
}

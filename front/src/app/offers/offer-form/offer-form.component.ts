import { Component, OnInit } from '@angular/core';
import { Offer } from '../offer';
import { HandleError } from 'app/error.service';
import { OfferService } from '../offer.service';

@Component({
  selector: 'app-offer-form',
  templateUrl: './offer-form.component.html',
  styleUrls: ['./offer-form.component.css']
})
export class OfferFormComponent implements OnInit {

  offer : Offer;
  private errorMessage: HandleError;
  
  constructor(private offerService : OfferService) { }

  ngOnInit() {
  }

  onSubmit(offer:Offer){
  
    this.offerService.addOffer(offer).subscribe(
      new_offer => {
        this.offer = new_offer;
      },
      error => this.errorMessage = <any>error
    );
  }

}

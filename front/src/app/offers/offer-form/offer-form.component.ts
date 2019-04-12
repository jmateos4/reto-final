import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Offer } from '../offer';
import { OfferService } from '../offer.service';

@Component({
  selector: 'app-offer-form',
  templateUrl: './offer-form.component.html',
  styleUrls: ['./offer-form.component.css']
})
export class OfferFormComponent implements OnInit {

  offer: Offer;
  added_success: boolean = false;
  errorMessage: string;
  @Output() onNew = new EventEmitter<Offer>();

  constructor(private offerService : OfferService) {
    this.offer = <Offer>{};
  }

  ngOnInit() {
  }

  onSubmit(offer: Offer) {
    offer.id = null;
    this.offerService.addOffer(offer).subscribe(
      new_offer => {
        this.offer = new_offer;
        this.added_success = true;
        this.onNew.emit(this.offer) ;
      },
      error => this.errorMessage = <any>error
    );
}


}

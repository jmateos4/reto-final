import { Component, OnInit } from '@angular/core';
import { Offer } from '../offer';
import { Router } from '@angular/router';
import { OfferService } from '../offer.service';

@Component({
  selector: 'app-offer-list',
  templateUrl: './offer-list.component.html',
  styleUrls: ['./offer-list.component.css']
})
export class OfferListComponent implements OnInit {

  offers: Offer[];
  errorMessage: string;
  response_status: number;
  is_insert: boolean = false;

  constructor(private offerService: OfferService, private router: Router) {
    this.offers = [];
  }

  ngOnInit() {
    this.offerService.getOffers().subscribe(
      offers => this.offers = offers,
      error => this.errorMessage = <any> error);
  }

  deleteOffer(offer: Offer) {
    this.offerService.deleteOffer(offer.id.toString()).subscribe(
      response => {
        this.response_status = response;
        this.offers = this.offers.filter(current_item => !(current_item.id === offer.id));
      },
      error => this.errorMessage = <any> error);
  }

  onNewOffer(new_offer: Offer){
    this.offers.push(new_offer);
    this.showAddOfferComponent();
  }

  showAddOfferComponent() {
    this.is_insert = !this.is_insert;
  }

  showEditOfferComponent(updated_offer: Offer) {
    this.router.navigate(['/offers', updated_offer.id.toString(), 'edit']);
  }

  gotoHome() {
    this.router.navigate(['/welcome']);
  }

}
import { Component, OnInit } from '@angular/core';
import { Offer } from '../offer';
import { Router } from '@angular/router';

@Component({
  selector: 'app-offer-list',
  templateUrl: './offer-list.component.html',
  styleUrls: ['./offer-list.component.css']
})
export class OfferListComponent implements OnInit {

  offer: Offer[];

  is_insert: boolean = false;


  constructor(private router: Router) { }

  ngOnInit() {
  }

 
  goFormOffer() {
    this.router.navigate(['/offersAdd']);
  }

  gotoHome() {
    this.router.navigate(['/welcome']);
  }

}

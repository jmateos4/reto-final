import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { OfferValidComponent } from './offer-valid/offer-valid.component';
import { OfferFormComponent } from './offer-form/offer-form.component';
import { OfferListComponent } from './offer-list/offer-list.component';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [OfferValidComponent, OfferFormComponent, OfferListComponent]
})
export class OffersModule { }

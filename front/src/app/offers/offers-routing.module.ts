import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import { OfferListComponent } from './offer-list/offer-list.component';
import { OfferFormComponent } from './offer-form/offer-form.component';
import { OfferValidComponent } from './offer-valid/offer-valid.component';

const offerRoutes: Routes = [
  {path: 'offers', component: OfferListComponent},
  {path: 'offers/form', component: OfferFormComponent},
  {path: 'offers/valid', component: OfferValidComponent}
];

@NgModule({
  imports: [RouterModule.forChild(offerRoutes)],
  exports: [RouterModule]
})

export class OffersRoutingModule {
}
import { Injectable } from '@angular/core';
<<<<<<< HEAD
import { OwnerService } from 'app/owners/owner.service';
=======
import { environment } from 'environments/environment';
import { HandleError, HttpErrorHandler } from 'app/error.service';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Offer } from './offer';
import { catchError } from 'rxjs/operators';
>>>>>>> fa5bec2bcbe771042e5f61992d848b9e1d02f5de

@Injectable({
  providedIn: 'root'
})
export class OfferService {

  private entity_url = environment.REST_API_URL + 'offer';

  private handlerError: HandleError;


  constructor(private http: HttpClient, private httpErrorHandler: HttpErrorHandler) {
    this.handlerError = httpErrorHandler.createHandleError('OfferService');
  }

  getOffers(): Observable<Offer[]> {
    return this.http.get<Offer[]>(this.entity_url)
      .pipe(
        catchError(this.handlerError('getOffers', []))
      );
  }

  getOfferById(offer_id: string): Observable<Offer> {
    return this.http.get<Offer>(this.entity_url + '/' + offer_id)
      .pipe(
        catchError(this.handlerError('getOfferById', {} as Offer))
      );
  }

  addOffer(offer: Offer): Observable<Offer> {
    return this.http.post<Offer>(this.entity_url, offer)
      .pipe(
        catchError(this.handlerError('addOffer', offer))
      );
  }

  updateOffer(offer_id: string, offer: Offer): Observable<Offer> {
    return this.http.put<Offer>(this.entity_url + '/' + offer_id, offer)
      .pipe(
        catchError(this.handlerError('updateOffer', offer))
      );
  }

  deleteOffer(offer_id: string): Observable<number> {
    return this.http.delete<number>(this.entity_url + '/' + offer_id)
      .pipe(
        catchError(this.handlerError('deleteOffer', 0))
      );

  }


}

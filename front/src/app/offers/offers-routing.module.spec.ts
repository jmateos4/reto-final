import { OffersRoutingModule } from './offers-routing.module';

describe('OffersRoutingModule', () => {
  let offersRoutingModule: OffersRoutingModule;

  beforeEach(() => {
    offersRoutingModule = new OffersRoutingModule();
  });

  it('should create an instance', () => {
    expect(offersRoutingModule).toBeTruthy();
  });
});

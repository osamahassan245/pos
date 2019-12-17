import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { PosTestModule } from '../../../test.module';
import { WEBSERVICEComponent } from 'app/entities/webservice/webservice.component';
import { WEBSERVICEService } from 'app/entities/webservice/webservice.service';
import { WEBSERVICE } from 'app/shared/model/webservice.model';

describe('Component Tests', () => {
  describe('WEBSERVICE Management Component', () => {
    let comp: WEBSERVICEComponent;
    let fixture: ComponentFixture<WEBSERVICEComponent>;
    let service: WEBSERVICEService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [PosTestModule],
        declarations: [WEBSERVICEComponent],
        providers: []
      })
        .overrideTemplate(WEBSERVICEComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(WEBSERVICEComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(WEBSERVICEService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new WEBSERVICE(123)],
            headers
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.wEBSERVICES[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});

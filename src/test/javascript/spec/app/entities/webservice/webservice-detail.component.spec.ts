import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { PosTestModule } from '../../../test.module';
import { WEBSERVICEDetailComponent } from 'app/entities/webservice/webservice-detail.component';
import { WEBSERVICE } from 'app/shared/model/webservice.model';

describe('Component Tests', () => {
  describe('WEBSERVICE Management Detail Component', () => {
    let comp: WEBSERVICEDetailComponent;
    let fixture: ComponentFixture<WEBSERVICEDetailComponent>;
    const route = ({ data: of({ wEBSERVICE: new WEBSERVICE(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [PosTestModule],
        declarations: [WEBSERVICEDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(WEBSERVICEDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(WEBSERVICEDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should call load all on init', () => {
        // GIVEN

        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.wEBSERVICE).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});

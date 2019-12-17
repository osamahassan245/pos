import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { PosTestModule } from '../../../test.module';
import { WEBSERVICEUpdateComponent } from 'app/entities/webservice/webservice-update.component';
import { WEBSERVICEService } from 'app/entities/webservice/webservice.service';
import { WEBSERVICE } from 'app/shared/model/webservice.model';

describe('Component Tests', () => {
  describe('WEBSERVICE Management Update Component', () => {
    let comp: WEBSERVICEUpdateComponent;
    let fixture: ComponentFixture<WEBSERVICEUpdateComponent>;
    let service: WEBSERVICEService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [PosTestModule],
        declarations: [WEBSERVICEUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(WEBSERVICEUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(WEBSERVICEUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(WEBSERVICEService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new WEBSERVICE(123);
        spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.update).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));

      it('Should call create service on save for new entity', fakeAsync(() => {
        // GIVEN
        const entity = new WEBSERVICE();
        spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.create).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));
    });
  });
});

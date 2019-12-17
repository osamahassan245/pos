import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { PosTestModule } from '../../../test.module';
import { WEBSERVICEDeleteDialogComponent } from 'app/entities/webservice/webservice-delete-dialog.component';
import { WEBSERVICEService } from 'app/entities/webservice/webservice.service';

describe('Component Tests', () => {
  describe('WEBSERVICE Management Delete Component', () => {
    let comp: WEBSERVICEDeleteDialogComponent;
    let fixture: ComponentFixture<WEBSERVICEDeleteDialogComponent>;
    let service: WEBSERVICEService;
    let mockEventManager: any;
    let mockActiveModal: any;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [PosTestModule],
        declarations: [WEBSERVICEDeleteDialogComponent]
      })
        .overrideTemplate(WEBSERVICEDeleteDialogComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(WEBSERVICEDeleteDialogComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(WEBSERVICEService);
      mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
      mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
    });

    describe('confirmDelete', () => {
      it('Should call delete service on confirmDelete', inject(
        [],
        fakeAsync(() => {
          // GIVEN
          spyOn(service, 'delete').and.returnValue(of({}));

          // WHEN
          comp.confirmDelete(123);
          tick();

          // THEN
          expect(service.delete).toHaveBeenCalledWith(123);
          expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
          expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
        })
      ));
    });
  });
});

import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IWEBSERVICE } from 'app/shared/model/webservice.model';
import { WEBSERVICEService } from './webservice.service';
import { WEBSERVICEDeleteDialogComponent } from './webservice-delete-dialog.component';

@Component({
  selector: 'jhi-webservice',
  templateUrl: './webservice.component.html'
})
export class WEBSERVICEComponent implements OnInit, OnDestroy {
  wEBSERVICES: IWEBSERVICE[];
  eventSubscriber: Subscription;

  constructor(protected wEBSERVICEService: WEBSERVICEService, protected eventManager: JhiEventManager, protected modalService: NgbModal) {}

  loadAll() {
    this.wEBSERVICEService.query().subscribe((res: HttpResponse<IWEBSERVICE[]>) => {
      this.wEBSERVICES = res.body;
    });
  }

  ngOnInit() {
    this.loadAll();
    this.registerChangeInWEBSERVICES();
  }

  ngOnDestroy() {
    this.eventManager.destroy(this.eventSubscriber);
  }

  trackId(index: number, item: IWEBSERVICE) {
    return item.id;
  }

  registerChangeInWEBSERVICES() {
    this.eventSubscriber = this.eventManager.subscribe('wEBSERVICEListModification', () => this.loadAll());
  }

  delete(wEBSERVICE: IWEBSERVICE) {
    const modalRef = this.modalService.open(WEBSERVICEDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.wEBSERVICE = wEBSERVICE;
  }
}

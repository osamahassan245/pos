import { Component } from '@angular/core';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IWEBSERVICE } from 'app/shared/model/webservice.model';
import { WEBSERVICEService } from './webservice.service';

@Component({
  templateUrl: './webservice-delete-dialog.component.html'
})
export class WEBSERVICEDeleteDialogComponent {
  wEBSERVICE: IWEBSERVICE;

  constructor(
    protected wEBSERVICEService: WEBSERVICEService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  clear() {
    this.activeModal.dismiss('cancel');
  }

  confirmDelete(id: number) {
    this.wEBSERVICEService.delete(id).subscribe(() => {
      this.eventManager.broadcast({
        name: 'wEBSERVICEListModification',
        content: 'Deleted an wEBSERVICE'
      });
      this.activeModal.dismiss(true);
    });
  }
}

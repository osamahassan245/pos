import { Component, OnInit } from '@angular/core';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { IWEBSERVICE, WEBSERVICE } from 'app/shared/model/webservice.model';
import { WEBSERVICEService } from './webservice.service';

@Component({
  selector: 'jhi-webservice-update',
  templateUrl: './webservice-update.component.html'
})
export class WEBSERVICEUpdateComponent implements OnInit {
  isSaving: boolean;

  editForm = this.fb.group({
    id: [],
    gID: [],
    cPT: [],
    wSNAM: [],
    dESCRIPTION: [],
    eNDPOINT: [],
    wSDL: [],
    uSERNAME: [],
    pASSWORD: [],
    tIMEOUT: []
  });

  constructor(protected wEBSERVICEService: WEBSERVICEService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ wEBSERVICE }) => {
      this.updateForm(wEBSERVICE);
    });
  }

  updateForm(wEBSERVICE: IWEBSERVICE) {
    this.editForm.patchValue({
      id: wEBSERVICE.id,
      gID: wEBSERVICE.gID,
      cPT: wEBSERVICE.cPT,
      wSNAM: wEBSERVICE.wSNAM,
      dESCRIPTION: wEBSERVICE.dESCRIPTION,
      eNDPOINT: wEBSERVICE.eNDPOINT,
      wSDL: wEBSERVICE.wSDL,
      uSERNAME: wEBSERVICE.uSERNAME,
      pASSWORD: wEBSERVICE.pASSWORD,
      tIMEOUT: wEBSERVICE.tIMEOUT
    });
  }

  previousState() {
    window.history.back();
  }

  save() {
    this.isSaving = true;
    const wEBSERVICE = this.createFromForm();
    if (wEBSERVICE.id !== undefined) {
      this.subscribeToSaveResponse(this.wEBSERVICEService.update(wEBSERVICE));
    } else {
      this.subscribeToSaveResponse(this.wEBSERVICEService.create(wEBSERVICE));
    }
  }

  private createFromForm(): IWEBSERVICE {
    return {
      ...new WEBSERVICE(),
      id: this.editForm.get(['id']).value,
      gID: this.editForm.get(['gID']).value,
      cPT: this.editForm.get(['cPT']).value,
      wSNAM: this.editForm.get(['wSNAM']).value,
      dESCRIPTION: this.editForm.get(['dESCRIPTION']).value,
      eNDPOINT: this.editForm.get(['eNDPOINT']).value,
      wSDL: this.editForm.get(['wSDL']).value,
      uSERNAME: this.editForm.get(['uSERNAME']).value,
      pASSWORD: this.editForm.get(['pASSWORD']).value,
      tIMEOUT: this.editForm.get(['tIMEOUT']).value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IWEBSERVICE>>) {
    result.subscribe(() => this.onSaveSuccess(), () => this.onSaveError());
  }

  protected onSaveSuccess() {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError() {
    this.isSaving = false;
  }
}

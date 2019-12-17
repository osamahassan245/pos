import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IWEBSERVICE } from 'app/shared/model/webservice.model';

@Component({
  selector: 'jhi-webservice-detail',
  templateUrl: './webservice-detail.component.html'
})
export class WEBSERVICEDetailComponent implements OnInit {
  wEBSERVICE: IWEBSERVICE;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ wEBSERVICE }) => {
      this.wEBSERVICE = wEBSERVICE;
    });
  }

  previousState() {
    window.history.back();
  }
}

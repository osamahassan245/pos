import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { Observable, of } from 'rxjs';
import { map } from 'rxjs/operators';
import { WEBSERVICE } from 'app/shared/model/webservice.model';
import { WEBSERVICEService } from './webservice.service';
import { WEBSERVICEComponent } from './webservice.component';
import { WEBSERVICEDetailComponent } from './webservice-detail.component';
import { WEBSERVICEUpdateComponent } from './webservice-update.component';
import { IWEBSERVICE } from 'app/shared/model/webservice.model';

@Injectable({ providedIn: 'root' })
export class WEBSERVICEResolve implements Resolve<IWEBSERVICE> {
  constructor(private service: WEBSERVICEService) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IWEBSERVICE> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(map((wEBSERVICE: HttpResponse<WEBSERVICE>) => wEBSERVICE.body));
    }
    return of(new WEBSERVICE());
  }
}

export const wEBSERVICERoute: Routes = [
  {
    path: '',
    component: WEBSERVICEComponent,
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'WEBSERVICES'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: WEBSERVICEDetailComponent,
    resolve: {
      wEBSERVICE: WEBSERVICEResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'WEBSERVICES'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: WEBSERVICEUpdateComponent,
    resolve: {
      wEBSERVICE: WEBSERVICEResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'WEBSERVICES'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: WEBSERVICEUpdateComponent,
    resolve: {
      wEBSERVICE: WEBSERVICEResolve
    },
    data: {
      authorities: ['ROLE_USER'],
      pageTitle: 'WEBSERVICES'
    },
    canActivate: [UserRouteAccessService]
  }
];

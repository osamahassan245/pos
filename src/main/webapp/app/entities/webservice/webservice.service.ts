import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IWEBSERVICE } from 'app/shared/model/webservice.model';

type EntityResponseType = HttpResponse<IWEBSERVICE>;
type EntityArrayResponseType = HttpResponse<IWEBSERVICE[]>;

@Injectable({ providedIn: 'root' })
export class WEBSERVICEService {
  public resourceUrl = SERVER_API_URL + 'api/webservices';

  constructor(protected http: HttpClient) {}

  create(wEBSERVICE: IWEBSERVICE): Observable<EntityResponseType> {
    return this.http.post<IWEBSERVICE>(this.resourceUrl, wEBSERVICE, { observe: 'response' });
  }

  update(wEBSERVICE: IWEBSERVICE): Observable<EntityResponseType> {
    return this.http.put<IWEBSERVICE>(this.resourceUrl, wEBSERVICE, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IWEBSERVICE>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IWEBSERVICE[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<any>> {
    return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }
}

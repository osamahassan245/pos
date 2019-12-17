export interface IWEBSERVICE {
  id?: number;
  gID?: number;
  cPT?: string;
  wSNAM?: string;
  dESCRIPTION?: string;
  eNDPOINT?: string;
  wSDL?: string;
  uSERNAME?: string;
  pASSWORD?: string;
  tIMEOUT?: string;
}

export class WEBSERVICE implements IWEBSERVICE {
  constructor(
    public id?: number,
    public gID?: number,
    public cPT?: string,
    public wSNAM?: string,
    public dESCRIPTION?: string,
    public eNDPOINT?: string,
    public wSDL?: string,
    public uSERNAME?: string,
    public pASSWORD?: string,
    public tIMEOUT?: string
  ) {}
}

export class PRMPackageRegion {
  idPays: number;
  idRegion: number;
  dtCreate: Date;
  dtModif: Date;
  ordRegion: number;
  refUser: string;
  regionName: string;
  version: number;

  constructor(
    idPays: number = 0,
    idRegion: number = 0,
    dtCreate: Date = new Date(),
    dtModif: Date = new Date(),
    ordRegion: number = 0,
    refUser: string = '',
    regionName: string = '',
    version: number = 0
  ) {
    this.idPays = idPays;
    this.idRegion = idRegion;
    this.dtCreate = dtCreate;
    this.dtModif = dtModif;
    this.ordRegion = ordRegion;
    this.refUser = refUser;
    this.regionName = regionName;
    this.version = version;
  }
}

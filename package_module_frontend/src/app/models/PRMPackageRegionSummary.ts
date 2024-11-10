export class PRMPackageRegionSummary {
    idPays: number;
    idRegion: number;
    regionName: string;
  
    constructor(idPays: number, idRegion: number, regionName: string) {
      this.idPays = idPays;
      this.idRegion = idRegion;
      this.regionName = regionName;
    }
  }
  
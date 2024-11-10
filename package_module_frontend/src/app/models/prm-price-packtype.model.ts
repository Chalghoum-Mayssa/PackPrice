export class PrmPricePacktype {
  id: PrmPricePacktypeId;
  typepackName: string;
  typepackAbrv: string;
  ordPacktype: number;
  refUser: string;
  dtCreate: Date;
  dtModif: Date;
  version: number;
  position?: number;  // Ajouter la propriété position

  constructor(
    id: PrmPricePacktypeId,
    typepackName: string,
    typepackAbrv: string,
    ordPacktype: number,
    refUser: string,
    dtCreate: Date,
    dtModif: Date,
    version: number,
    position?: number  // Ajouter la propriété position au constructeur
  ) {
    this.id = id;
    this.typepackName = typepackName;
    this.typepackAbrv = typepackAbrv;
    this.ordPacktype = ordPacktype;
    this.refUser = refUser;
    this.dtCreate = dtCreate;
    this.dtModif = dtModif;
    this.version = version;
    this.position = position;  // Initialiser la propriété position
  }
}

export class PrmPricePacktypeId {
  idEntite: number;
  idTypepack: number;

  constructor(idEntite: number, idTypepack: number) {
    this.idEntite = idEntite;
    this.idTypepack = idTypepack;
  }
}

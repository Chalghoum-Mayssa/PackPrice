import { PRMPackageRegion } from './PRMPackageRegion';

export const REGIONS: PRMPackageRegion[] = [
  {
    idPays: 1,
    idRegion: 1,
    dtCreate: new Date('2021-01-01'),
    dtModif: new Date('2021-06-01'),
    ordRegion: 1,
    refUser: 'user1',
    regionName: 'Region A',
    version: 1
  },
  {
    idPays: 1,
    idRegion: 2,
    dtCreate: new Date('2021-02-01'),
    dtModif: new Date('2021-06-02'),
    ordRegion: 2,
    refUser: 'user2',
    regionName: 'Region B',
    version: 1
  },
  {
    idPays: 2,
    idRegion: 1,
    dtCreate: new Date('2021-03-01'),
    dtModif: new Date('2021-06-03'),
    ordRegion: 3,
    refUser: 'user3',
    regionName: 'Region C',
    version: 1
  }
];

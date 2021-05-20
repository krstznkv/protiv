import {Report} from './report';
import {Station} from './station';

export interface NaturalFocusOfPlague extends Report{
  id: number;
  station: Station;
  year: number;
  month: number;
  area_fiz: number;
  area_oper: number;
  nocit: number;
  blox: number;
  orud_pole: number;
  orud_punkt: number;
  enter: number;
  bac_nosit: number;
  krov_all: number;
  krov_blox: number;
}

import {Station} from './station';

export interface EpEx {
  id: number;
  station: Station;
  year: number;
  month: number;
  area_pole: number;
  area_punkt: number;
  orud_pole: number;
  orud_punkt: number;
  mites_km: number;
  mites_h: number;
  mammals_rodents: number;
  mammals_insectivores: number;
  mammals_predators: number;
  mammals_others: number;
  birds: number;
  arthropods_blox: number;
  arthropods_mites: number;
  arthropods_komar: number;
  arthropods_other: number;
  pogadki: number;
  water: number;
  other: number;
}

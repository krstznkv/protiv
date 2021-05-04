import {Station} from '../../model/station';

export interface User {
  station: Station;
  username: string;
  password: string;
  roles: string[];
}

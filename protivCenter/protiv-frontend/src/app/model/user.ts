import {Station} from './station';

export interface User {
  username: string;
  password: string;
  roles: string[];
  station: Station;
}

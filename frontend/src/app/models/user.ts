import { Reservation } from "./reservation";

export interface User {
  email: string;
  firstname: string;
  lastname: string;
  password: string;
  guests: number;
  allergy: string;
  roleName: string;
  reservationList: Reservation[];
}


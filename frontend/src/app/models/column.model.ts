import { Professionals } from '../interfaces/professionals.interface';

export class Column {
  constructor(public name: string, public tasks: Professionals[]) {}
}
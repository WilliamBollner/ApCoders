import { Despesa } from "./despesa";
import { Inquilino } from "./inquilino";

export class Unidade {
    idUnidade?: number;
    proprietario?: string;
    condominio?: string;
    endereco?: string;
    inquilino?: Inquilino;
    despesa?: Despesa[];

    constructor(obj: Partial<Unidade>){
        Object.assign(this, obj)
    }
}

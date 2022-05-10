import { Despesa } from "./despesa";
import { Inquilino } from "./inquilino";

export class Unidade {
    id?: number;
    proprietarioUnidade?: string;
    condominioUnidade?: string;
    enderecoUnidade?: string;
    inquilino?: Inquilino;
    despesa?: Despesa[];

    constructor(obj: Partial<Unidade>){
        Object.assign(this, obj)
    }
}

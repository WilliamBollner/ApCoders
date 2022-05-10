export class Inquilino {

    id?: number;
    nomeInquilino?: string;
    idadeInquilino?: number;
    sexoInquilino?: string;
    telefoneInquilino?: number;
    emailInquilino?: string;

    constructor(obj: Partial<Inquilino>){
        Object.assign(this, obj)
    }

}

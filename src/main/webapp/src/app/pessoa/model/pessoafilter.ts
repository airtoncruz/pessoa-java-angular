import {userLang} from "../../common";

export class Pessoafilter {

  dsNome: string;
  cpf: string;
  dtNascimento: string;
  email: string;
  page: number = 0;
  size: number = 10;
  totalElements: number;

  build(): String {

    let retorno: String = "";

    retorno = retorno.concat(`?page=${this.page}`);
    retorno = retorno.concat(`&size=${this.size}`);
    retorno = retorno.concat(`&language=${userLang}`);

    if (this.dsNome != "" && this.dsNome != undefined) {

      retorno = retorno.concat(`&dsNome=${this.dsNome}`);
    }

    if (this.cpf != "" && this.cpf != undefined) {

      if (retorno.includes("?")) {

        retorno = retorno.concat(`&cpf=${this.cpf}`);
      }
    }

    if (this.dtNascimento != "" && this.dtNascimento != undefined) {

      if (retorno.includes("?")) {

        retorno = retorno.concat(`&dtNascimento=${this.dtNascimento}`);
      }
    }

    if (this.email != "" && this.email != undefined) {

      if(retorno.includes("?")) {

        retorno = retorno.concat(`&email=${this.email}`);
      }
    }

    return retorno;
  }

}

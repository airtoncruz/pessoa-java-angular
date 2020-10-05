export class Page<T> {

  content: T[] = [];
  totalPages: number;
  totalElements: number;

  //pagina atual
  number: number;
  //total por pagina
  size: number;
}

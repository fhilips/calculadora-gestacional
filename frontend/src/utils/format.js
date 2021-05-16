const dataFormatada = (data) => {
    var dataFormatada = new Date(data),
        dia  = (dataFormatada.getDate()+1).toString().padStart(2, '0'),
        mes  = (dataFormatada.getMonth()+1).toString().padStart(2, '0'), //+1 pois no getMonth Janeiro começa com zero.
        ano  = dataFormatada.getFullYear();
    return dia+"/"+mes+"/"+ano;
}

export default dataFormatada;
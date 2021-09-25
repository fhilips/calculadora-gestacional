import { format, parseISO } from "date-fns";

const dataFormatada = (data) => {
  return format(parseISO(data), "dd/MM/yyyy");
};

export default dataFormatada;

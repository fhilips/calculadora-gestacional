import { Table } from "react-bootstrap";
import dataFormatada from "../../utils/format";

type ResponseData = {
  dataProvavelDoParto: string;
  dataUltimaMenstruacao: string;
  idadeGestacional: string;
  dataMorfoPrimeiroTri: string;
  dataMorfoSegundoTri: string;
};
type Props = {
  responseData: ResponseData;
};

const DataTable = ({ responseData }: Props) => {
  return (
    <>
      <h4 className="mt-4 mb-4">Informações da gestante</h4>
      <Table striped hover>        
        <tbody>
          <tr>
            <td>Data Provavel do Parto:</td>
            <td>{dataFormatada(responseData.dataProvavelDoParto)}</td>
          </tr>
          <tr>
            <td>Data última menstruacao:</td>
            <td>{dataFormatada(responseData.dataUltimaMenstruacao)}</td>
          </tr>
          <tr>
            <td>Idade gestacional:</td>
            <td>{responseData.idadeGestacional}</td>
          </tr>
          <tr>
            <td>Data Morfologico 1 trimestre:</td>
            <td>{responseData.dataMorfoPrimeiroTri}</td>
          </tr>
          <tr>
            <td>Data Morfologico 2 trimestre:</td>
            <td>{responseData.dataMorfoSegundoTri}</td>
          </tr>
        </tbody>
      </Table>
    </>
  );
};

export default DataTable;

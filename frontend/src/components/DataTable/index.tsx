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
            <td><strong>Data provável do parto:</strong></td>
            <td>{dataFormatada(responseData.dataProvavelDoParto)}</td>
          </tr>
          <tr>
            <td><strong>Data da última menstruação:</strong></td>
            <td>{dataFormatada(responseData.dataUltimaMenstruacao)}</td>
          </tr>
          <tr>
            <td><strong>Idade gestacional:</strong></td>
            <td>{responseData.idadeGestacional}</td>
          </tr>
          <tr>
            <td><strong>Data morfológico 1 trimestre:</strong></td>
            <td>{responseData.dataMorfoPrimeiroTri}</td>
          </tr>
          <tr>
            <td><strong>Data morfológico 2 trimestre:</strong></td>
            <td>{responseData.dataMorfoSegundoTri}</td>
          </tr>
        </tbody>
      </Table>
    </>
  );
};

export default DataTable;

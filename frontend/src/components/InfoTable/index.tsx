import { Table } from "react-bootstrap";
import dataFormatada from "../../utils/format";

type ResponseData = {
  dataProvavelDoParto: string;
  dataUltimaMenstruacao: string;
  idadeGestacional: string;
};
type Props = {
  responseData: ResponseData;
};

const InfoTable = ({ responseData }: Props) => {
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
        </tbody>
      </Table>
    </>
  );
};

export default InfoTable;

import { useState } from "react";
import { useForm } from "react-hook-form";
import { Button } from "react-bootstrap";
import axios from "axios";
import InfoTable from "../../components/DataTable";
import MainCard from "../../components/Card";
import dataFormatada from "../../utils/format";
import { BASE_URL } from "../../utils/request";
import "./styles.css";

type ResponseData = {
  dataProvavelDoParto: string;
  dataUltimaMenstruacao: string;
  idadeGestacional: string;
  dataMorfoPrimeiroTri: string;
  dataMorfoSegundoTri: string;
};
type FormData = {
  data?: string;
  criterioCalculo?: string;
  semanas?: number;
  dias?: number;
};

const Home = () => {
  const {
    register,
    handleSubmit,
    formState: { errors },
    watch,
  } = useForm<FormData>();
  const [responseData, setResponseData] = useState<ResponseData>({
    dataProvavelDoParto: '',
    dataUltimaMenstruacao: '',
    idadeGestacional: '',
    dataMorfoPrimeiroTri: '',
    dataMorfoSegundoTri: '',
  });
  const watchCriterioCalculo = watch("criterioCalculo");

  const onSubmit = (data: FormData) => {
    console.log(data);
    axios
      .post(`${BASE_URL}/`, {
        data: dataFormatada(data?.data),
        criterioCalculo: data?.criterioCalculo,
        semanas: data?.semanas,
        dias: data?.dias,
      })
      .then((response) => {
        setResponseData(response.data);
      })
      .catch((err) => {
        console.log(err.data);
      });
  };

  return (
    <>
    <div className="home-container">
       <MainCard title={"Calculadora Gestacional"}>

        <form onSubmit={handleSubmit(onSubmit)}>
          <div className="input-container mb-2">
            <div className="input-item">
              <label>Critério</label>
              <select
                className="form-control"
                defaultValue={""}
                {...register("criterioCalculo", {
                  required: "Campo obrigatório",
                })}
              >
                <option value={"DATA_PROVAVEL_DO_PARTO"}>
                  Data provável do parto
                </option>
                <option value={"DATA_ULTIMA_MENSTRUACAO"}>
                  Data da última menstruação
                </option>
                <option value={"DATA_GESTACIONAL_ATUAL"}>
                  Idade gestacional atual
                </option>
                <option value={"DATA_EXAME_ANTERIOR"}>
                  Idade gestacional em um exame anterior
                </option>
              </select>
            </div>
            <div
              className={`input-item ${
                watchCriterioCalculo === "DATA_GESTACIONAL_ATUAL"
                  ? "not-display" : ""}`}
            >
              <label>Data</label>
              <input
                className="form-control"
                type="date"
                {...register("data")}
                defaultValue="yyyy-MM-dd"
              />
            </div>
            <div className="line-input-sepator" />
            {(watchCriterioCalculo === "DATA_GESTACIONAL_ATUAL" ||
              watchCriterioCalculo === "DATA_EXAME_ANTERIOR") && (
              <>
                <div className="input-item ">
                  <label>Semanas</label>
                  <input
                    className="form-control"
                    type="number"
                    {...register("semanas", {
                      required: "Campo obrigatório",
                      max: 40,
                      min: 0,
                    })}
                    placeholder="Semanas"
                  />
                  {errors.semanas?.type === "max" &&
                    "Semanas não pode ser maior do que 40!"}
                  {errors.semanas?.type === "min" &&
                  "Semanas não pode ser negativo!"}
                </div>
                <div className="input-item">
                  <label>Dias</label>
                  <input
                    className="form-control"
                    type="number"
                    {...register("dias", {
                      required: "Campo obrigatório",
                      max: 6,
                      min: 0
                    })}
                    placeholder="Dias"
                  />
                  {errors.dias?.type === "max" &&
                    "Dias não pode ser maior do que 6!"}
                  {errors.dias?.type === "min" &&
                  "Dias não pode ser negativo!"}
                </div>
              </>
            )}
          </div>

          <Button className="mt2" type="submit" variant="secondary" block>
            CALCULAR
          </Button>
          {responseData.dataProvavelDoParto !== "" && (
            <InfoTable responseData={responseData} />
          )}
        </form>
      </MainCard>
    </div>
   
         
     
    </>
  );
};

export default Home;

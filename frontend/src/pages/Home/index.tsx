import {  useState } from "react";
import { useForm } from "react-hook-form";
import axios from "axios";
import dataFormatada from "../../utils/format";
import { BASE_URL } from "../../utils/request";
import InfoTable from "../../components/InfoTable";
import { Button } from 'react-bootstrap';
import "./styles.css";


type ResponseData = {
  dataProvavelDoParto: string;
  dataUltimaMenstruacao: string;
  idadeGestacional: string;
};
type FormData = {
  data?: string;
  criterioCalculo?: string;
  semanas?: number;
  dias?: number;
};

const Home = () => {
  const { register, handleSubmit, formState: { errors }, watch } = useForm<FormData>();
  const [responseData, setResponseData] = useState<ResponseData>({
    dataProvavelDoParto: "",
    dataUltimaMenstruacao: "",
    idadeGestacional: "",
  });
  const watchCriterioCalculo = watch("criterioCalculo");

  const onSubmit = (data: FormData) => {
    console.log(data)
    axios.post(`${BASE_URL}/`, {
        data: dataFormatada(data?.data),
        criterioCalculo: data?.criterioCalculo,
        semanas: data?.semanas,
        dias: data?.dias,
      })
      .then((response) => {        
        setResponseData(response.data);
      })
      .catch((message) => {console.log(message)});    
  };

  return (
    <>    
      <div className="container">
        <div className="calculadora-card">
          <h1>Calculadora Gestacional</h1>

          <form onSubmit={handleSubmit(onSubmit)}>

            <div className="input-container mb-2">
              <div className="input-item">                           
                <label>Critério</label>
                <select
                  className="form-control"                  
                  defaultValue={""}                   
                  {...register("criterioCalculo", { required: "Campo obrigatório" })}
                  >
                  <option value={"DATA_PROVAVEL_DO_PARTO"}>Data provável do parto</option>
                  <option value={"DATA_ULTIMA_MENSTRUACAO"}>Data da última menstruação</option>
                  <option value={"DATA_GESTACIONAL_ATUAL"}>Idade gestacional atual</option>
                  <option value={"DATA_EXAME_ANTERIOR"}>Idade gestacional em um exame anterior</option>
                </select>                                            
              </div>
              <div className={`input-item ${watchCriterioCalculo === 'DATA_GESTACIONAL_ATUAL' ? 'not-display' : ''}`}>
              <label>Data</label>
              <input 
                  className="form-control"  
                  type="date"
                  {...register("data")}
                  defaultValue="yyyy-MM-dd" />  
              </div>
              <div className="line-input-sepator"/>
                {(watchCriterioCalculo === "DATA_GESTACIONAL_ATUAL" ||
                  watchCriterioCalculo === "DATA_EXAME_ANTERIOR") && (
                  <>
                    <div className="input-item ">
                      <label>Semanas</label>
                      <input 
                        className="form-control"  
                        type="number"
                        {...register("semanas", { required: "Campo obrigatório", max: 40})}                      
                        placeholder="Semanas" />
                         {errors.semanas?.type === "max" && "Semanas não pode ser maior do que 40!"}
                    </div>
                    <div className="input-item">
                      <label>Dias</label> 
                      <input 
                        className="form-control"  
                        type="number"
                        {...register("dias", { required: "Campo obrigatório", max: 6 })}                     
                        placeholder="Dias" />
                        {errors.dias?.type === "max" && "Dias não pode ser maior do que 6!"}
                          
                    </div> 
                                    
                  </>
                )}
            </div>                          
            
            <Button  
                className="mt2"              
                type="submit"
                variant="secondary"
                block>
                CALCULAR
              </Button>  
          </form>
          {responseData.dataProvavelDoParto !== '' && 
          (<InfoTable responseData={responseData}/>)
          }          
        </div>             
       
      </div>
    </>
  );
};

export default Home;

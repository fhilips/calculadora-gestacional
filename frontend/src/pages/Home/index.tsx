import {
  Box,
  Button,
  FormControl,
  InputLabel,
  MenuItem,
  Select,
  TextField,
} from "@material-ui/core";
import { useState } from "react";

import "./styles.css";

const Home = () => {
  const [criterio, setCriterio] = useState();

  const handleChange = (event: any) => {
    setCriterio(event.target.value);
  };
  return (
    <>
      <Box className="container">
        <div className="calculadora-card">
          <h1>Calculadora Gestacional</h1>
          <div className="input-container">
            <div className="criterio-container">
              <FormControl className="select">
                <InputLabel id="select-label">Critério</InputLabel>
                <Select
                  labelId="select-label"
                  id="select"
                  value={criterio}
                  defaultValue={10}
                  onChange={handleChange}
                >
                  <MenuItem value={10}>Data provável do parto</MenuItem>
                  <MenuItem value={20}>Data da última menstruação</MenuItem>
                  <MenuItem value={30}>Data de exame anterior</MenuItem>
                </Select>
              </FormControl>
              <TextField
                id="date"
                label="Data"
                type="date"
                defaultValue="00-00-0000"
                InputLabelProps={{
                  shrink: true,
                }}
              />        
            </div>            
            <div className="data-container">
            {criterio === 10 && 
                <div>
                  <TextField id="basic" label="Semanas" />
                  <TextField id="dias-basic" label="Dias" />
                </div>}
            </div>
            <Button fullWidth variant="contained" size="large" disableElevation>
              calcular
            </Button>
           
          </div>
        </div>
      </Box>
    </>
  );
};

export default Home;

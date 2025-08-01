import axios from 'axios';

const SALIDA_API_URL = 'http://localhost:8080/api/salidas';

export const obtenerSalidas = () => {
  return axios.get(SALIDA_API_URL);
};

export const crearSalida = (salida) => {
  return axios.post(SALIDA_API_URL, salida);
};

export const obtenerSalidaPorId = (id) => {
  return axios.get(`${SALIDA_API_URL}/${id}`);
};

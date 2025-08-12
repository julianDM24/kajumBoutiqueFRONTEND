import axios from 'axios';

const API_URL = 'http://localhost:8080/api/clientes';

const getClientes = () => {
  return axios.get(API_URL);
};

const ClienteService = {
  getClientes,
};

export default ClienteService;

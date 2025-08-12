import axios from 'axios';

const API_URL = 'http://localhost:8080/api/ventadetalles';

const getVentaDetalles = () => axios.get(API_URL);

const crearVentaDetalle = (ventaDetalle) => axios.post(API_URL, ventaDetalle);

const obtenerVentaDetalle = (id) => axios.get(`${API_URL}/${id}`);

const actualizarVentaDetalle = (id, ventaDetalle) => axios.put(`${API_URL}/${id}`, ventaDetalle);

const eliminarVentaDetalle = (id) => axios.delete(`${API_URL}/${id}`);

const VentaDetalleService = {
  getVentaDetalles,
  crearVentaDetalle,
  obtenerVentaDetalle,
  actualizarVentaDetalle,
  eliminarVentaDetalle,
};

export default VentaDetalleService;

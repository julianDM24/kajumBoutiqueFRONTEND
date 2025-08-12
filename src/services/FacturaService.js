// src/services/FacturaService.js
import axios from 'axios';

const FACTURA_API_URL = 'http://localhost:8080/api/facturas';

// Obtener todas las facturas
export const obtenerFacturas = () => {
  return axios.get(FACTURA_API_URL);
};

// Crear una factura nueva
export const crearFactura = (factura) => {
  return axios.post(FACTURA_API_URL, factura);
};

// Obtener una factura por ID
export const obtenerFacturaPorId = (id) => {
  return axios.get(`${FACTURA_API_URL}/${id}`);
};

// Actualizar factura
export const actualizarFactura = (id, factura) => {
  return axios.put(`${FACTURA_API_URL}/${id}`, factura);
};

// Eliminar factura
export const eliminarFactura = (id) => {
  return axios.delete(`${FACTURA_API_URL}/${id}`);
};

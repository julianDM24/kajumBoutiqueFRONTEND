// src/services/VentaService.js
import axios from 'axios';

const API_URL = 'http://localhost:8080/api/ventas';

export const obtenerVentas = () => axios.get(API_URL);
export const obtenerVentasSinFactura = () => axios.get(`${API_URL}/sin-factura`);
export const crearVenta = (venta) => axios.post(API_URL, venta);
export const obtenerVentaPorId = (id) => axios.get(`${API_URL}/${id}`);
export const actualizarVenta = (id, venta) => axios.put(`${API_URL}/${id}`, venta);
export const eliminarVenta = (id) => axios.delete(`${API_URL}/${id}`);

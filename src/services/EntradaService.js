// src/services/EntradaService.js
import axios from 'axios';

const API_URL = 'http://localhost:8080/api/entradas'; // Ajusta si tu endpoint es diferente

export const getEntradas = async () => {
  const response = await axios.get(API_URL);
  return response.data;
};

export const getEntradaById = async (id) => {
  const response = await axios.get(`${API_URL}/${id}`);
  return response.data;
};

export const createEntrada = async (entrada) => {
  const response = await axios.post(API_URL, entrada);
  return response.data;
};

export const updateEntrada = async (id, entrada) => {
  const response = await axios.put(`${API_URL}/${id}`, entrada);
  return response.data;
};

export const deleteEntrada = async (id) => {
  const response = await axios.delete(`${API_URL}/${id}`);
  return response.data;
};


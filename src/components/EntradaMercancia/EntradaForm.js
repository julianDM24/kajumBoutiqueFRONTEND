// src/components/EntradaForm.js
import React, { useState, useEffect } from 'react';
import axios from 'axios';

const EntradaForm = ({ onGuardarEntrada }) => {
  const [cantidad, setCantidad] = useState('');
  const [usuarioSeleccionado, setUsuarioSeleccionado] = useState('');
  const [codigoPrenda, setCodigoPrenda] = useState('');
  const [usuarios, setUsuarios] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/api/usuarios')
      .then(response => setUsuarios(response.data))
      .catch(error => console.error('Error al obtener usuarios:', error));
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();

    const entrada = {
      codigo_prenda: codigoPrenda,
      cantidad_entrada: parseInt(cantidad),
      fecha_entrada: new Date().toISOString().split('T')[0],
      usuario: {
        idUsuario: parseInt(usuarioSeleccionado)
      }
    };

    axios.post('http://localhost:8080/api/entradas', entrada)
      .then(response => {
        alert('Entrada registrada correctamente');
        setCodigoPrenda('');
        setCantidad('');
        setUsuarioSeleccionado('');
        if (onGuardarEntrada) {
          onGuardarEntrada(response.data);
        }
      })
      .catch(error => {
        console.error('Error al registrar entrada:', error);
      });
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label>Código de Prenda:</label>
        <input
          type="text"
          value={codigoPrenda}
          onChange={(e) => setCodigoPrenda(e.target.value)}
          required
        />
      </div>
      <div>
        <label>Cantidad:</label>
        <input
          type="number"
          value={cantidad}
          onChange={(e) => setCantidad(e.target.value)}
          required
        />
      </div>
      <div>
        <label>Usuario:</label>
        <select
          value={usuarioSeleccionado}
          onChange={(e) => setUsuarioSeleccionado(e.target.value)}
          required
        >
          <option value="">Seleccione un usuario</option>
          {usuarios.map(usuario => (
            <option key={usuario.idUsuario} value={usuario.idUsuario}>
              {usuario.nombre}
            </option>
          ))}
        </select>
      </div>
      <button type="submit">Registrar Entrada</button>
    </form>
  );
};

export default EntradaForm;


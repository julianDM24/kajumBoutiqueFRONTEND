import React, { useState, useEffect } from 'react';
import { crearSalida } from '../../services/SalidaService';
import { getUsuarios } from '../../services/UsuarioService';

const SalidaForm = () => {
  const [codigoPrenda, setCodigoPrenda] = useState('');
  const [cantidad, setCantidad] = useState('');
  const [usuarioId, setUsuarioId] = useState('');
  const [usuarios, setUsuarios] = useState([]);

  useEffect(() => {
    getUsuarios().then(res => {
      setUsuarios(res.data);
    }).catch(error => {
      console.error('Error al obtener usuarios:', error);
    });
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();

    const salida = {
      codigo_prenda: codigoPrenda,
      cantidad_salida: parseInt(cantidad),
      fecha_salida: new Date().toISOString().split('T')[0],
      usuario: { id: usuarioId }
    };

    crearSalida(salida)
      .then(() => {
        alert('Salida registrada correctamente');
        setCodigoPrenda('');
        setCantidad('');
        setUsuarioId('');
      })
      .catch(error => {
        console.error('Error al registrar salida:', error);
      });
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Registrar Salida de Mercancía</h2>
      <input
        type="text"
        value={codigoPrenda}
        onChange={(e) => setCodigoPrenda(e.target.value)}
        placeholder="Código de prenda"
        required
      />
      <input
        type="number"
        value={cantidad}
        onChange={(e) => setCantidad(e.target.value)}
        placeholder="Cantidad"
        required
      />
      <select
        value={usuarioId}
        onChange={(e) => setUsuarioId(e.target.value)}
        required
      >
        <option value="">Selecciona un usuario</option>
        {usuarios.map(usuario => (
          <option key={usuario.id} value={usuario.id}>
            {usuario.nombre}
          </option>
        ))}
      </select>
      <button type="submit">Registrar salida</button>
    </form>
  );
};

export default SalidaForm;

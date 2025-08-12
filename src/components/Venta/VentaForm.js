// src/components/Venta/VentaForm.js
import React, { useEffect, useState } from 'react';
import ClienteService from '../../services/ClienteService';
import { getUsuarios } from '../../services/UsuarioService';
import { crearVenta } from '../../services/VentaService';

const VentaForm = () => {
  const [fechaVenta, setFechaVenta] = useState('');
  const [clienteSeleccionado, setClienteSeleccionado] = useState('');
  const [usuarioSeleccionado, setUsuarioSeleccionado] = useState('');
  const [clientes, setClientes] = useState([]);
  const [usuarios, setUsuarios] = useState([]);

  useEffect(() => {
    ClienteService.getClientes()
      .then((response) => setClientes(response.data))
      .catch((error) => console.error('Error al obtener clientes:', error));

    getUsuarios()
      .then((response) => setUsuarios(response.data))
      .catch((error) => console.error('Error al obtener usuarios:', error));
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();

    const nuevaVenta = {
      fecha_venta: fechaVenta,
      cliente: { id_cliente: clienteSeleccionado },
      usuario: { id_usuario: usuarioSeleccionado },
    };

    crearVenta(nuevaVenta)
      .then((response) => {
        console.log('Venta creada:', response.data);
        // Puedes limpiar el formulario o redirigir si lo deseas
      })
      .catch((error) => {
        console.error('Error al crear venta:', error);
      });
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Registrar Venta</h2>

      <label>Fecha de Venta:</label>
      <input
        type="date"
        value={fechaVenta}
        onChange={(e) => setFechaVenta(e.target.value)}
        required
      />

      <label>Cliente:</label>
      <select
        value={clienteSeleccionado}
        onChange={(e) => setClienteSeleccionado(e.target.value)}
        required
      >
        <option value="">Seleccione un cliente</option>
        {clientes.map((cliente) => (
          <option key={cliente.id_cliente} value={cliente.id_cliente}>
            {cliente.nombre}
          </option>
        ))}
      </select>

      <label>Usuario:</label>
      <select
        value={usuarioSeleccionado}
        onChange={(e) => setUsuarioSeleccionado(e.target.value)}
        required
      >
        <option value="">Seleccione un usuario</option>
        {usuarios.map((usuario) => (
          <option key={usuario.id_usuario} value={usuario.id_usuario}>
            {usuario.nombre}
          </option>
        ))}
      </select>

      <button type="submit">Guardar Venta</button>
    </form>
  );
};

export default VentaForm;

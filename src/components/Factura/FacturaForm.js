import React, { useState, useEffect } from 'react';
import axios from 'axios';

const FacturaForm = () => {
  const [fechaEmision, setFechaEmision] = useState('');
  const [formaPago, setFormaPago] = useState('EFECTIVO');
  const [clienteId, setClienteId] = useState('');
  const [usuarioId, setUsuarioId] = useState('');
  const [ventaId, setVentaId] = useState('');
  const [clientes, setClientes] = useState([]);
  const [usuarios, setUsuarios] = useState([]);
  const [ventas, setVentas] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/api/clientes')
      .then(response => setClientes(response.data))
      .catch(error => console.error('Error al obtener clientes:', error));

    axios.get('http://localhost:8080/api/usuarios')
      .then(response => setUsuarios(response.data))
      .catch(error => console.error('Error al obtener usuarios:', error));

    axios.get('http://localhost:8080/api/ventas')
      .then(response => setVentas(response.data))
      .catch(error => console.error('Error al obtener ventas:', error));
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();

    const factura = {
      fecha_emision: fechaEmision,
      formaPago: formaPago, // ✅ corregido
      cliente: { id_cliente: parseInt(clienteId) },
      usuario: { idUsuario: parseInt(usuarioId) },
      venta: { id_venta: parseInt(ventaId) }
    };

    axios.post('http://localhost:8080/api/facturas', factura)
      .then(response => {
        console.log('Factura registrada:', response.data);
        alert('Factura registrada exitosamente');
      })
      .catch(error => {
        console.error('Error al registrar factura:', error);
        alert('Error al registrar factura');
      });
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>Fecha de Emisión:</label>
      <input
        type="date"
        value={fechaEmision}
        onChange={(e) => setFechaEmision(e.target.value)}
        required
      />

      <label>Forma de Pago:</label>
      <select
        value={formaPago}
        onChange={(e) => setFormaPago(e.target.value)}
        required
      >
        <option value="EFECTIVO">Efectivo</option>
        <option value="TARJETA">Tarjeta</option>
        <option value="TRANSFERENCIA">Transferencia</option>
      </select>

      <label>Cliente:</label>
      <select
        value={clienteId}
        onChange={(e) => setClienteId(e.target.value)}
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
        value={usuarioId}
        onChange={(e) => setUsuarioId(e.target.value)}
        required
      >
        <option value="">Seleccione un usuario</option>
        {usuarios.map((usuario) => (
          <option key={usuario.idUsuario} value={usuario.idUsuario}>
            {usuario.nombre}
          </option>
        ))}
      </select>

      <label>Venta:</label>
      <select
        value={ventaId}
        onChange={(e) => setVentaId(e.target.value)}
        required
      >
        <option value="">Seleccione una venta</option>
        {ventas.map((venta) => (
          <option key={venta.id_venta} value={venta.id_venta}>
            Venta #{venta.id_venta}
          </option>
        ))}
      </select>

      <button type="submit">Registrar Factura</button>
    </form>
  );
};

export default FacturaForm;

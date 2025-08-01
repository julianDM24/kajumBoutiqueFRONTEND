import React, { useEffect, useState } from 'react';
import axios from 'axios';

const FacturaList = () => {
  const [facturas, setFacturas] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/api/facturas')
      .then(res => setFacturas(res.data))
      .catch(err => console.error('Error al obtener facturas:', err));
  }, []);

  return (
    <div>
      <h2>Facturas Registradas</h2>
      <table border="1">
        <thead>
          <tr>
            <th>ID</th>
            <th>Fecha Emisión</th>
            <th>Forma de Pago</th>
            <th>Cliente</th>
            <th>Usuario</th>
            <th>Venta</th>
          </tr>
        </thead>
        <tbody>
          {facturas.map(f => (
            <tr key={f.id_factura}>
              <td>{f.id_factura}</td>
              <td>{f.fecha_emision}</td>
              <td>{f.formaPago}</td>
              <td>{f.cliente ? f.cliente.nombre : 'Sin cliente'}</td>
              <td>{f.usuario ? f.usuario.nombre : 'Sin usuario'}</td>
              <td>{f.venta ? f.venta.id_venta : 'Sin venta'}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default FacturaList;

// src/components/VentaList.js
import React, { useEffect, useState } from 'react';
import { obtenerVentas } from '../../services/VentaService';
import { eliminarVenta } from '../../services/VentaService';



const VentaList = () => {
  const [ventas, setVentas] = useState([]);

  useEffect(() => {
    cargarVentas();
  }, []);

  const cargarVentas = async () => {
    const response = await obtenerVentas();
    setVentas(response.data);
  };

  const handleEliminar = async (id) => {
    await eliminarVenta(id);
    cargarVentas();
  };

  return (
    <div>
      <h2 className="text-xl font-bold mb-4">Lista de Ventas</h2>
      <ul>
        {ventas.map((venta) => (
          <li key={venta.id_venta}>
            <p><strong>Fecha:</strong> {venta.fecha_venta}</p>
            <p><strong>Total:</strong> {venta.total_venta}</p>
            <p><strong>Tipo de Pago:</strong> {venta.tipoPago}</p>
            <button onClick={() => handleEliminar(venta.id_venta)} className="text-red-600">Eliminar</button>
            <hr className="my-2" />
          </li>
        ))}
      </ul>
    </div>
  );
};

export default VentaList;

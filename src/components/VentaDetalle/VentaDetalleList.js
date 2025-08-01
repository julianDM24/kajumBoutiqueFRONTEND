import React, { useEffect, useState } from 'react';
import VentaDetalleService from '../../services/VentaDetalleService';

const VentaDetalleList = () => {
  const [ventaDetalles, setVentaDetalles] = useState([]);

  useEffect(() => {
    VentaDetalleService.getVentaDetalles().then((res) => {
      setVentaDetalles(res.data);
    });
  }, []);

  return (
    <div>
      <h2>Lista de Detalles de Venta</h2>
      <ul>
        {ventaDetalles.map((detalle) => (
          <li key={detalle.id_venta_detalle}>
            Venta ID: {detalle.venta?.id_venta}, Prenda ID: {detalle.prendas?.id_prenda}, Cantidad: {detalle.cantidad}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default VentaDetalleList;

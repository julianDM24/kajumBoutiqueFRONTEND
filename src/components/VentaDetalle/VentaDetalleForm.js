import React, { useState } from 'react';
import VentaDetalleService from '../../services/VentaDetalleService';

const VentaDetalleForm = () => {
  const [detalle, setDetalle] = useState({
    venta: { id_venta: '' },
    prendas: { id_prenda: '' },
    cantidad: '',
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    if (name === 'venta' || name === 'prendas') {
      setDetalle({ ...detalle, [name]: { [`id_${name}`]: value } });
    } else {
      setDetalle({ ...detalle, [name]: value });
    }
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    VentaDetalleService.crearVentaDetalle(detalle).then(() => {
      alert('Detalle de venta guardado');
    });
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>Venta ID:</label>
      <input name="venta" onChange={handleChange} required />

      <label>Prenda ID:</label>
      <input name="prendas" onChange={handleChange} required />

      <label>Cantidad:</label>
      <input type="number" name="cantidad" onChange={handleChange} required />

      <button type="submit">Guardar</button>
    </form>
  );
};

export default VentaDetalleForm;

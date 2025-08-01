import React, { useEffect, useState } from 'react';
import { obtenerSalidas } from '../../services/SalidaService';

const SalidaList = () => {
  const [salidas, setSalidas] = useState([]);

  useEffect(() => {
    obtenerSalidas().then(res => {
      setSalidas(res.data);
    }).catch(error => {
      console.error('Error al obtener salidas:', error);
    });
  }, []);

  return (
    <div>
      <h2>Listado de Salidas</h2>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Código Prenda</th>
            <th>Cantidad</th>
            <th>Fecha</th>
            <th>Usuario</th>
          </tr>
        </thead>
        <tbody>
          {salidas.map(salida => (
            <tr key={salida.id_salida}>
              <td>{salida.id_salida}</td>
              <td>{salida.codigo_prenda}</td>
              <td>{salida.cantidad_salida}</td>
              <td>{salida.fecha_salida}</td>
              <td>{salida.usuario?.nombre}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default SalidaList;

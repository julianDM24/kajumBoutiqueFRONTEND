import React, { useEffect, useState } from 'react';
import axios from 'axios';

const EntradaList = () => {
  const [entradas, setEntradas] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/api/entradas')
      .then(response => {
        setEntradas(response.data);
      })
      .catch(error => {
        console.error('Error al obtener entradas:', error);
      });
  }, []);

  return (
    <div>
      <h2>Entradas Registradas</h2>
      <table border="1">
        <thead>
          <tr>
            <th>Codigo Prenda</th>
            <th>Cantidad</th>
            <th>Fecha</th>
            <th>Usuario</th>
          </tr>
        </thead>
        <tbody>
          {entradas.map((entrada) => (
            <tr key={entrada.id_entrada}>
              <td>{entrada.codigo_prenda}</td>
              <td>{entrada.cantidad_entrada}</td>
              <td>{entrada.fecha_entrada}</td>
              <td>{entrada.usuario ? entrada.usuario.nombre : 'Sin usuario'}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default EntradaList;




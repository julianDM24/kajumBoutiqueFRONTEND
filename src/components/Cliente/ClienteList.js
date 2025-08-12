import React, { useEffect, useState } from 'react';
import ClienteService from '../../services/ClienteService';

const ListaClientes = () => {
  const [clientes, setClientes] = useState([]);

  useEffect(() => {
    ClienteService.getClientes()
      .then(response => {
        setClientes(response.data);
      })
      .catch(error => {
        console.error('Error al obtener los clientes:', error);
      });
  }, []);

  return (
    <div>
      <h2>Lista de Clientes</h2>
      <table border="1">
        <thead>
          <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Teléfono</th>
            <th>Dirección</th>
          </tr>
        </thead>
        <tbody>
          {clientes.map(cliente => (
            <tr key={cliente.id_cliente}>
              <td>{cliente.id_cliente}</td>
              <td>{cliente.nombre}</td>
              <td>{cliente.telefono}</td>
              <td>{cliente.direccion}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ListaClientes;




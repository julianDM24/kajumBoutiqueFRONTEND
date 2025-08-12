import React, { useEffect, useState } from 'react';
import { getUsuarios } from '../../services/UsuarioService';

const UsuarioList = () => {
  const [usuarios, setUsuarios] = useState([]);

  useEffect(() => {
    getUsuarios().then(response => {
      setUsuarios(response.data);
    }).catch(error => {
      console.error('Error al obtener usuarios:', error);
    });
  }, []);

  return (
    <div>
      <h3>Usuarios Registrados</h3>
      <ul>
        {usuarios.map(usuario => (
          <li key={usuario.idUsuario}>
            {usuario.nombre} - {usuario.rol}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default UsuarioList;

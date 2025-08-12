import React, { useState } from 'react';
import { crearUsuario } from '../../services/UsuarioService';

const UsuarioForm = () => {
  const [usuario, setUsuario] = useState({
    nombre: '',
    contrasena: '',
    rol: ''
  });

  const handleChange = (e) => {
    setUsuario({ ...usuario, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    crearUsuario(usuario).then(() => {
      alert('Usuario creado');
      setUsuario({ nombre: '', contrasena: '', rol: '' });
    }).catch(error => {
      console.error('Error al crear usuario:', error);
    });
  };

  return (
    <form onSubmit={handleSubmit}>
      <input name="nombre" placeholder="Nombre" value={usuario.nombre} onChange={handleChange} required />
      <input name="contrasena" placeholder="Contraseña" value={usuario.contrasena} onChange={handleChange} required />
      <input name="rol" placeholder="Rol" value={usuario.rol} onChange={handleChange} required />
      <button type="submit">Guardar Usuario</button>
    </form>
  );
};

export default UsuarioForm;


import React, { useState } from 'react';
import axios from 'axios';

const UsuarioForm = () => {
  const [usuario, setUsuario] = useState({
    idUsuario: '',
    nombre: '',
    contrasena: '',
    fecha_creacion: '',
    rol: ''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setUsuario({ ...usuario, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    axios.post('http://localhost:8080/api/usuarios', usuario)
      .then(response => {
        console.log("Usuario creado", response.data);
        alert("Usuario creado exitosamente");
      })
      .catch(error => {
        console.error("Error al crear usuario:", error);
        alert("Error al crear usuario");
      });
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Crear Usuario</h2>

      <input
        type="number"
        name="idUsuario"
        placeholder="ID del Usuario"
        value={usuario.idUsuario}
        onChange={handleChange}
        required
      /><br />

      <input
        type="text"
        name="nombre"
        placeholder="Nombre"
        value={usuario.nombre}
        onChange={handleChange}
        required
      /><br />

      <input
        type="password"
        name="contrasena"
        placeholder="Contraseña"
        value={usuario.contrasena}
        onChange={handleChange}
        required
      /><br />

      <input
        type="date"
        name="fecha_creacion"
        value={usuario.fecha_creacion}
        onChange={handleChange}
        required
      /><br />

      <input
        type="text"
        name="rol"
        placeholder="Rol"
        value={usuario.rol}
        onChange={handleChange}
        required
      /><br />

      <button type="submit">Guardar</button>
    </form>
  );
};

export default UsuarioForm;

import React, { useState } from 'react';
import axios from 'axios';

const PrendaForm = () => {
  const [formData, setFormData] = useState({
    codigo_prenda: '',
    nombre: '',
    descripcion: '',
    talla: '',
    precio_por_mayor: '',
    precio_publico: '',
    cantidad_disponible: ''
  });

  const handleChange = e => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = e => {
    e.preventDefault();
    axios.post('http://localhost:8080/api/prendas', formData)
      .then(() => {
        alert('Prenda registrada correctamente');
        setFormData({
          codigo_prenda: '',
          nombre: '',
          descripcion: '',
          talla: '',
          precio_por_mayor: '',
          precio_publico: '',
          cantidad_disponible: ''
        });
      })
      .catch(err => console.error('Error al registrar prenda:', err));
  };

  return (
    <form onSubmit={handleSubmit} className="p-4 space-y-4">
      {Object.keys(formData).map(key => (
        <input
          key={key}
          name={key}
          placeholder={key.replace(/_/g, ' ')}
          value={formData[key]}
          onChange={handleChange}
          className="block w-full p-2 border rounded"
        />
      ))}
      <button type="submit" className="bg-blue-500 text-white px-4 py-2 rounded">
        Guardar Prenda
      </button>
    </form>
  );
};

export default PrendaForm;

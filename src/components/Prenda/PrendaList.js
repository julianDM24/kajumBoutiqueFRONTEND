import React, { useEffect, useState } from 'react';
import axios from 'axios';

const PrendaList = () => {
  const [prendas, setPrendas] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/api/prendas')
      .then(response => setPrendas(response.data))
      .catch(error => console.error('Error al obtener las prendas:', error));
  }, []);

  return (
    <div className="p-4">
      <h2 className="text-xl font-bold mb-4">Lista de Prendas</h2>
      <ul className="space-y-2">
        {prendas.map(prenda => (
          <li key={prenda.id_prenda} className="p-2 border rounded shadow">
            <strong>{prenda.nombre}</strong> - Talla: {prenda.talla}, Precio público: ${prenda.precio_publico}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default PrendaList;

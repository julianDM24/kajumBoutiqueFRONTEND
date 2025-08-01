import React from 'react';
import ClienteList from './components/Cliente/ClienteList';
import UsuarioForm from './components/Usuario/UsuarioForm';
import UsuarioList from './components/Usuario/UsuarioList';
import EntradaForm from './components/EntradaMercancia/EntradaForm';
import EntradaList from './components/EntradaMercancia/EntradaList';
import FacturaForm from './components/Factura/FacturaForm';
import FacturaList from './components/Factura/FacturaList';
import PrendaForm from './components/Prenda/PrendaForm';
import PrendaList from './components/Prenda/PrendaList';
import SalidaForm from './components/SalidaMercancia/SalidaForm';
import SalidaList from './components/SalidaMercancia/SalidaList';
import VentaForm from './components/Venta/VentaForm';
import VentaList from './components/Venta/VentaList';
import VentaDetalleForm from './components/VentaDetalle/VentaDetalleForm'; 
import VentaDetalleList from './components/VentaDetalle/VentaDetalleList'; 
import axios from 'axios';
import './App.css';

function App() {
  const handleGuardarEntrada = (entrada) => {
    axios.post('http://localhost:8080/api/entradas', entrada)
      .then(() => {
        console.log('Entrada guardada exitosamente');
      })
      .catch(err => {
        console.error('Error al guardar la entrada:', err);
      });
  };

  const handleGuardarSalida = (salida) => {
    axios.post('http://localhost:8080/api/salidas', salida)
      .then(() => {
        console.log('Salida guardada exitosamente');
      })
      .catch(err => {
        console.error('Error al guardar la salida:', err);
      });
  };

  const handleGuardarVenta = (venta) => {
    axios.post('http://localhost:8080/api/ventas', venta)
      .then(() => {
        console.log('Venta guardada exitosamente');
      })
      .catch(err => {
        console.error('Error al guardar la venta:', err);
      });
  };

  return (
    <div className="App" style={{ padding: '20px', fontFamily: 'Arial' }}>
      <h1>Listado de Clientes</h1>
      <ClienteList />

      <h2>Gestión de Usuarios</h2>
      <UsuarioForm />
      <UsuarioList />

      <h2>Gestión de Entrada de Mercancía</h2>
      <EntradaForm onGuardarEntrada={handleGuardarEntrada} />
      <EntradaList />

      <h2>Gestión de Salida de Mercancía</h2>
      <SalidaForm onGuardarSalida={handleGuardarSalida} />
      <SalidaList />

      <h2>Gestión de Facturas</h2>
      <FacturaForm />
      <FacturaList />

      <h2>Gestión de Prendas</h2>
      <PrendaForm />
      <PrendaList />

      <h2>Gestión de Ventas</h2>
      <VentaForm onGuardarVenta={handleGuardarVenta} />
      <VentaList />

      <h2>Gestión de Detalles de Venta</h2>
      <VentaDetalleForm />
      <VentaDetalleList />
    </div>
  );
}

export default App;




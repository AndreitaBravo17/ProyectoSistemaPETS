const express = require('express');
const httpProxy = require('http-proxy');
const cors = require('cors');

const app = express();
const proxy = httpProxy.createProxyServer();

// Configurar CORS
app.use(cors());

// URLs de los microservicios
const propietariosApiUrl = 'http://localhost:8081';
const mascotasApiUrl = 'http://localhost:8082';
const citasMedicasApiUrl = 'http://localhost:8083';
const registrosMedicosApiUrl = 'http://localhost:8084';
const vacunasApiUrl = 'http://localhost:8085';
const kpiApiUrl = 'http://localhost:8086';

// Ruta para el microservicio de Mascotas
app.all('/api/mascotas*', (req, res) => {
  proxy.web(req, res, { target: mascotasApiUrl });
});

// Rutas para otros microservicios
app.all('/api/propietarios*', (req, res) => {
  proxy.web(req, res, { target: propietariosApiUrl });
});

app.all('/api/citas-medicas*', (req, res) => {
  proxy.web(req, res, { target: citasMedicasApiUrl });
});

app.all('/api/registros-medicos*', (req, res) => {
  proxy.web(req, res, { target: registrosMedicosApiUrl });
});

app.all('/api/vacunas*', (req, res) => {
  proxy.web(req, res, { target: vacunasApiUrl });
});

app.all('/api/kpi*', (req, res) => {
  proxy.web(req, res, { target: kpiApiUrl });
});

// Capturar errores del proxy
proxy.on('error', (err, req, res) => {
  console.error('Error en el proxy:', err);
  res.status(500).send('Ha ocurrido un error en el proxy.');
});

// Puerto del API Gateway
const port = 3000;
app.listen(port, () => {
  console.log(`API Gateway escuchando en el puerto ${port}`);
});

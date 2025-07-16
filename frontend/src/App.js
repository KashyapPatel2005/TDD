// src/App.js
import React, { useState, useEffect } from 'react';
import SweetList from './components/SweetList';
import AddSweetForm from './components/admin/AddSweetForm';
import axios from 'axios';
import './App.css';

function App() {
  const [role, setRole] = useState('user');
  const [sweets, setSweets] = useState([]);

  const fetchSweets = () => {
    axios.get('http://localhost:8080/api/sweets')
      .then(res => setSweets(res.data));
  };

  useEffect(() => {
    fetchSweets();
  }, []);

  return (
    <div className="container">
      <h1>Sweet Shop Management</h1>

      <div style={{ marginBottom: '1rem' }}>
        <label>Select Role: </label>
        <select value={role} onChange={(e) => setRole(e.target.value)}>
          <option value="user">User</option>
          <option value="admin">Admin</option>
        </select>
      </div>

      {role === 'admin' && <AddSweetForm onAdd={fetchSweets} />}
      <SweetList role={role} sweets={sweets} refresh={fetchSweets} />
    </div>
  );
}

export default App;

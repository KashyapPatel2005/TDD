// src/App.js
import React, { useState, useEffect } from 'react';
import SweetList from './components/SweetList';
import AddSweetForm from './components/admin/AddSweetForm';
import axios from 'axios';
import './App.css';

function App() {
  const [role, setRole] = useState('user');
  const [sweets, setSweets] = useState([]);
  const [searchTerm, setSearchTerm] = useState("");


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

      <div style={{ marginBottom: '1rem' }}>
        <input
          type="text"
          placeholder="Search sweets by name..."
          value={searchTerm}
          onChange={(e) => setSearchTerm(e.target.value)}
          style={{
            padding: '8px',
            width: '100%',
            borderRadius: '6px',
            border: '1px solid #ccc',
            fontSize: '14px'
          }}
        />
      </div>

      <SweetList role={role} sweets={sweets} refresh={fetchSweets}  searchTerm={searchTerm} />
    </div>
  );
}

export default App;

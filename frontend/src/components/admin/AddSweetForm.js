// src/components/admin/AddSweetForm.js
import React, { useState } from 'react';
import axios from 'axios';

function AddSweetForm({ onAdd }) {
  const [form, setForm] = useState({ id: '', name: '', category: '', price: '', quantity: '' });

  const handleChange = e => setForm({ ...form, [e.target.name]: e.target.value });

  const handleSubmit = e => {
    e.preventDefault();
    axios.post('http://localhost:8080/api/sweets', form).then(() => {
      alert("Sweet added successfully");
      setForm({ id: '', name: '', category: '', price: '', quantity: '' });
      onAdd(); // fetch latest sweets
    });
  };

  return (
    <form onSubmit={handleSubmit}>
      <h3>Add Sweet (Admin Only)</h3>
      <input name="id" placeholder="ID" value={form.id} onChange={handleChange} required />
      <input name="name" placeholder="Name" value={form.name} onChange={handleChange} required />
      <input name="category" placeholder="Category" value={form.category} onChange={handleChange} required />
      <input name="price" placeholder="Price" value={form.price} onChange={handleChange} required />
      <input name="quantity" placeholder="Quantity" value={form.quantity} onChange={handleChange} required />
      <button type="submit">Add Sweet</button>
    </form>
  );
}

export default AddSweetForm;

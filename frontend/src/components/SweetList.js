// src/components/SweetList.js
import React from 'react';
import axios from 'axios';
import UserActions from './user/UserActions';
import AdminActions from './admin/AdminActions';

function SweetList({ role, sweets, refresh, searchTerm }) {
  // Filter sweets based on search term
  const filteredSweets = sweets.filter(s =>
    s.name.toLowerCase().includes(searchTerm.toLowerCase())
  );

  const deleteSweet = (id) => {
    axios.delete(`http://localhost:8080/api/sweets/${id}`)
      .then(() => refresh());
  };

  const purchaseSweet = (id) => {
    axios.put(`http://localhost:8080/api/sweets/purchase/${id}`)
      .then(() => refresh());
  };

  const restockSweet = (id) => {
    const qty = prompt("Enter quantity to restock:");
    if (!qty) return;
    axios.put(`http://localhost:8080/api/sweets/restock/${id}?qty=${qty}`)
      .then(() => refresh());
  };

  return (
    <div>
      <h2>Sweet Inventory</h2>
      {filteredSweets.length === 0 ? (
        <p>No sweets found.</p>
      ) : (
        <ul>
          {filteredSweets.map(sweet => (
            <li key={sweet.id}>
              <b>{sweet.name}</b> ({sweet.category}) - ₹{sweet.price} | Stock: {sweet.quantity}
              
              {role === 'user' && (
                <UserActions sweet={sweet} purchaseSweet={purchaseSweet} />
              )}

              {role === 'admin' && (
                <AdminActions sweet={sweet} deleteSweet={deleteSweet} restockSweet={restockSweet} />
              )}
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}

export default SweetList;



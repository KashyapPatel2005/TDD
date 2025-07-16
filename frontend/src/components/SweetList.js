// src/components/SweetList.js
import React from 'react';
import axios from 'axios';
import UserActions from './user/UserActions';
import AdminActions from './admin/AdminActions';

function SweetList({ role, sweets, refresh }) {
  
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
      {sweets.length === 0 ? (
        <p>No sweets available.</p>
      ) : (
        <ul>
          {sweets.map(sweet => (
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

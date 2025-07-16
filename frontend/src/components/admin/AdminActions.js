import React from 'react';

function AdminActions({ sweet, deleteSweet, restockSweet }) {
  return (
    <>
      <button onClick={() => restockSweet(sweet.id)}>🔄 Restock</button>
      <button onClick={() => deleteSweet(sweet.id)}>🗑️ Delete</button>
    </>
  );
}

export default AdminActions;

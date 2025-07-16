import React from 'react';

function UserActions({ sweet, purchaseSweet }) {
  return (
    <button 
      onClick={() => purchaseSweet(sweet.id)} 
      disabled={sweet.quantity <= 0}>
      🛒 Purchase
    </button>
  );
}

export default UserActions;

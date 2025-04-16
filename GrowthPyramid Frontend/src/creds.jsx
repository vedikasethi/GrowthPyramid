import React from 'react';
import NavBarComponent from './components/NavBarComponent';

export default function Creds() {
  return (
    <>
      <NavBarComponent />
      <div style={{ display: 'flex', justifyContent: 'center', alignItems: 'center', height: '100vh' }}>
        <a 
          href="https://buy.stripe.com/test_14k28L3QNfAs8gg28c" 
          target="_blank" 
          rel="noopener noreferrer" 
          style={{ fontSize: '2rem', fontWeight: 'bold', textDecoration: 'none', color: '#007bff' }}
        >
          creds
        </a>
      </div>
    </>
  );
}

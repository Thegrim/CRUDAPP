import React, { useState, useEffect } from 'react';
import axios from 'axios';

function Counter() {
  const [count, setCount] = useState(0);

  useEffect(() => {
    axios.get('/api/counter/1')
      .then(response => {
        setCount(response.data.count);
      });
  }, []);

  const increment = () => {
    axios.post('/api/counter')
      .then(response => {
        setCount(response.data.count);
      });
  };

  return (
    <div>
      <p>Count: {count}</p>
      <button onClick={increment}>Increment</button>
    </div>
  );
}

export default Counter;

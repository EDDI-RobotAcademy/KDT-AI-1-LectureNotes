import React, { useEffect, useRef } from "react";
import { mount } from 'vueModuleApp/Sample';

const App = () => {
  const ref = useRef(null)

  useEffect(() => {
    mount(ref.current);
  }, []);

  return (
    <div style=
      {{ margin: '10px', padding: '10px', textAlign: 'center', backgroundColor: 'cyan' }}>
      <h1>나는 React로 만들어진 Container!</h1>
      <div ref={ref} />
    </div>
  )
};

export default App;
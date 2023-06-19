import React, { useEffect, useRef, useState } from "react";
import { vueMount } from 'vueModuleApp/Sample';
import { navigationMount } from 'vueNavigationApp/VueNavigation';

const App = () => {
  const vueRef = useRef(null)
  const [count, setCount ] = useState(0)
  const vuetifyNavigationRef = useRef(null)

  useEffect(() => {
    vueMount(vueRef.current, {
      count,
      incrementCount: () => setCount(currentCount => currentCount + 1)
    });   
    navigationMount(vuetifyNavigationRef.current)
  }, [count]);




  return (
    <div>
      <div ref={vuetifyNavigationRef}/>
      {/* <div style=
          {{ margin: '10px', padding: '10px', textAlign: 'center', backgroundColor: 'cyan' }}> */}
        <h1>나는 React로 만들어진 Container!</h1>
        <div ref={vueRef}/>
        <button onClick={() => setCount(currentCount => currentCount + 1)}>
          { count }
        </button>
      {/* </div> */}
    </div>
  )
};

export default App;

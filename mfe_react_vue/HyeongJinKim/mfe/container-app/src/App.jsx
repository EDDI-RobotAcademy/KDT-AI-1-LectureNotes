import React, { useEffect, useRef } from "react";
import { mount } from "vueModuleApp/Sample";
import { navigationMount } from "vueNavigationApp/VueNavigation";

const App = () => {
  const ref = useRef(null);
  const vuetifyNavigationRef = useRef(null);

  useEffect(() => {
    mount(ref.current);
    navigationMount(vuetifyNavigationRef.current);
  }, []);

  return (
    <div>
      <div ref={vuetifyNavigationRef} />
      <div
        style={{
          margin: "10px",
          padding: "10px",
          textAlign: "center",
          backgroundColor: "cyan",
        }}
      >
        <h1>나는 React</h1>
        <div ref={ref} />
      </div>
    </div>
  );
};

export default App;

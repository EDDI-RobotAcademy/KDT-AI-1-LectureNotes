import React, { useEffect, useRef, useState } from "react";
import { mount } from "vueModuleApp/Sample";
import { navigationMount } from "vueNavigationApp/VueNavigation";
import Counter from "reactModuleApp/Counter";

const App = () => {
  const vueRef = useRef(null);
  const vuetifyNavigationRef = useRef(null);

  useEffect(() => {
    mount(vueRef.current);
    navigationMount(vuetifyNavigationRef.current);
  }, []);

  return (
    <div>
      <div
        style={{
          margin: "10px",
          marginTop: "70px",
          padding: "10px",
          textAlign: "center",
          backgroundColor: "cyan",
        }}
      >
        <h1>나는 React Container</h1>
        <div ref={vueRef} />
      </div>
      <Counter />
      <div ref={vuetifyNavigationRef} />
    </div>
  );
};

export default App;

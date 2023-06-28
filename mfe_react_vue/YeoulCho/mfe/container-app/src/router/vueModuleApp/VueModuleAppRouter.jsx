import React, { useEffect } from 'react'

import { mount } from 'vueModuleApp/Sample';

const VueModuleAppRouter = ({ vueModuleRef }) => {
  useEffect(() => {
    mount(vueModuleRef.current)
  }, [])

  return (
    <div>
      <div style={{position:'relative'}}>
        <div ref={vueModuleRef}/>
      </div>
    </div>
  )
}

export default VueModuleAppRouter
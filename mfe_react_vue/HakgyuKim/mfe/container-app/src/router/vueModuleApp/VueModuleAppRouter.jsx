import React, { useEffect } from 'react'

import { mount } from 'vueModuleApp/Sample';

const VueModuleAppRouter = ({ vueModuleRef }) => {
  useEffect(() => {
    mount(vueModuleRef.current)
  }, [])

  return (
    <div style={{position: 'relative'}}>
      <div>
        <div ref={vueModuleRef}/>
      </div>
    </div>
  )
}

export default VueModuleAppRouter
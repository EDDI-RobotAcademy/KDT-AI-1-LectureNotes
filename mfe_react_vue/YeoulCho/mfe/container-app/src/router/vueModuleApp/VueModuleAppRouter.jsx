import React, { useEffect } from 'react'

const VueModuleAppRouter = ({ vueModuleRef }) => {
  useEffect(() => {
    const loadRemoteComponent = async () => {
      const { mount } = await import('vueModuleApp/Sample')
      mount(vueModuleRef.current)
    }

    loadRemoteComponent()
  }, [vueModuleRef])

  return (
    <div>
      <div style={{position:'relative'}}>
        <div ref={vueModuleRef}/>
      </div>
    </div>
  )
}

export default VueModuleAppRouter
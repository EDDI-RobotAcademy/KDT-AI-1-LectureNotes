import React, { useEffect } from 'react'

const VueModuleAppRouter = ({vueModuleRef}) => {

  useEffect(() => {
    const loadRemoteComponent = async () => {
        const { mount } = await import('vueModuleApp/Sample')
        mount(vueModuleRef.current)
    }

    loadRemoteComponent()
  }, [vueModuleRef])

  return (
    <div style={{position: 'relative'}}>
      <div>
        <div ref={vueModuleRef}/>
      </div>
    </div>
  )
}

export default VueModuleAppRouter
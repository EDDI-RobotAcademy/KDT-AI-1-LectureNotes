import React, { useEffect } from 'react'

import { mount } from 'vueModuleApp/Sample';

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
            <div style={{ position: 'relative' }} ref={vueModuleRef}/>
        </div>
    )
}

export default VueModuleAppRouter
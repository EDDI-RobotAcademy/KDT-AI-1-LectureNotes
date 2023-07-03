import React, { useEffect, useRef } from 'react'

const VueModuleAppModifyRouter = () => {
  const vueModuleModifyRef = useRef(null)

    useEffect(() => {
        const loadRemoteComponent = async () => {
          const { modifyBootstrapMount } = await import('vueModuleApp/boardModifyBootstrap')
          modifyBootstrapMount(vueModuleModifyRef.current)
        }

        loadRemoteComponent()
    }, [vueModuleModifyRef])

    return (
      <div>
            <div>
          <div style={{ position: 'relative' }} ref={vueModuleModifyRef} />
            </div>
      </div>
  )
}

export default VueModuleAppModifyRouter
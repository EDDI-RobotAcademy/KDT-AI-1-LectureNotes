import React, { useEffect, useRef } from 'react'

const VueModuleAppReadRouter = () => {
  const vueModuleReadRef = useRef(null)

    useEffect(() => {
        const loadRemoteComponent = async () => {
            const { readBootstrapMount } = await import('vueModuleApp/boardReadBootstrap')
          readBootstrapMount(vueModuleReadRef.current)
        }

        loadRemoteComponent()
    }, [vueModuleReadRef])

    return (
      <div>
            <div>
              <div style={{ position: 'relative' }} ref={vueModuleReadRef} />
            </div>
      </div>
  )
}

export default VueModuleAppReadRouter
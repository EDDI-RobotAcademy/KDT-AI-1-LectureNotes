import React, { useEffect, useRef } from 'react'

const VuetifyTypeScriptBoardAppRegisterRouter = () => {
  const vuetifyBoardRegisterRef = useRef(null)

  useEffect(() => {
    const loadRemoteComponent = async () => {
      const { registerBootstrapMount } = await import('vuetifyTailwindBoardApp/boardRegisterBootstrap')
      registerBootstrapMount(vuetifyBoardRegisterRef.current)
    }
  
    loadRemoteComponent()
  }, [vuetifyBoardRegisterRef])
  
  return (
    <div>
      <div>
        <div style={{ position: 'relative' }} ref={vuetifyBoardRegisterRef}/>
      </div>
    </div>
  )
}

export default VuetifyTypeScriptBoardAppRegisterRouter
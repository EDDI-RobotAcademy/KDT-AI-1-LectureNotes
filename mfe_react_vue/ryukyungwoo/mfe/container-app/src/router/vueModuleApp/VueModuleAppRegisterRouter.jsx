import React, { useEffect, useRef } from 'react'

const VueModuleAppRegisterRouter = () => {
  const vueModuleRegisterRef = useRef(null)

  useEffect(() => {
    const loadRemoteComponent = async () => {
      const { registerBootstrapMount } = await import('vueModuleApp/boardRegisterBootstrap')
      registerBootstrapMount(vueModuleRegisterRef.current)
    }

    loadRemoteComponent()
    return () => {
      console.log('해제 작업 진행중 ......')

      vueModuleModifyRef.current = null
    }
  }, [vueModuleRegisterRef])

  return (
    <div>
    <div>
      <div style={{ position: 'relative' }} ref={vueModuleRegisterRef}/>
    </div>
  </div>
  )
}

export default VueModuleAppRegisterRouter
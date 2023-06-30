import React, { useEffect, useRef } from 'react'

const VueModuleAppListRouter = () => {
  const vueModuleListRef = useRef(null)

  useEffect(() => {
    const loadRemoteComponent = async () => {
      const { listBootstrapMount } = await import('vueModuleApp/boardListBootstrap')
      listBootstrapMount(vueModuleListRef.current,)
    }

    loadRemoteComponent()

    return () => {
      console.log('해제 작업 진행중 ......')

      vueModuleListRef.current = null
    }
  }, [vueModuleListRef])

  return (
    <div>
      <div>
        <div style={{ position: 'relative' }} ref={vueModuleListRef}/>
      </div>
    </div>
  )
}

export default VueModuleAppListRouter
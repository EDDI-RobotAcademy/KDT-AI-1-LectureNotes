import React, { useEffect, useRef } from 'react'
import { useParams } from 'react-router-dom'

const VueModuleAppModifyRouter = () => {
  const { boardId } = useParams()
  const vueModuleModifyRef = useRef(null)

  useEffect(() => {
    const loadRemoteComponent = async () => {
      const { modifyBootstrapMount } = await import('vueModuleApp/boardModifyBootstrap')
      modifyBootstrapMount(vueModuleModifyRef.current, boardId)
    }

    loadRemoteComponent()
  }, [vueModuleModifyRef, boardId])

  return (
    <div>
      <div>
        <div style={{ position: 'relative' }} ref={vueModuleModifyRef}/>
      </div>
    </div>
  )
}

export default VueModuleAppModifyRouter
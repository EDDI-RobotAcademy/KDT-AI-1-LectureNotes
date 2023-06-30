import React, { useEffect, useRef } from 'react'
import { useParams } from 'react-router-dom'

const VueModuleAppReadRouter = () => {
  const { boardId } = useParams()
  const vueModuleReadRef = useRef(null)

  useEffect(() => {
    const loadRemoteComponent = async () => {
      const { readBootstrapMount } = await import('vueModuleApp/boardReadBootstrap')
      readBootstrapMount(vueModuleReadRef.current, boardId)
    }

    loadRemoteComponent()
  }, [vueModuleReadRef, boardId])

  return (
    <div>
      <div>
        <div style={{ position: 'relative' }} ref={vueModuleReadRef}/>
      </div>
    </div>
  )
}

export default VueModuleAppReadRouter
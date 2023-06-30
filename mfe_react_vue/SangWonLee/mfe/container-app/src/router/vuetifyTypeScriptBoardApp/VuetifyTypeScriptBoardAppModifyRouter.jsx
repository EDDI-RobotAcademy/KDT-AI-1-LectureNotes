import React, { useEffect, useRef } from 'react'
import { useParams } from 'react-router-dom'

const VuetifyTypeScriptBoardAppModifyRouter = () => {
  const { boardId } = useParams()
  const vuetifyBoardModifyRef = useRef(null)

  useEffect(() => {
    const loadRemoteComponent = async () => {
      const { modifyBootstrapMount } = await import('vuetifyTailwindBoardApp/boardModifyBootstrap')
      modifyBootstrapMount(vuetifyBoardModifyRef.current, boardId)
    }
  
    loadRemoteComponent()
  }, [vuetifyBoardModifyRef, boardId])
  
  return (
    <div>
      <div>
        <div style={{ position: 'relative' }} ref={vuetifyBoardModifyRef}/>
      </div>
    </div>
  )
}

export default VuetifyTypeScriptBoardAppModifyRouter
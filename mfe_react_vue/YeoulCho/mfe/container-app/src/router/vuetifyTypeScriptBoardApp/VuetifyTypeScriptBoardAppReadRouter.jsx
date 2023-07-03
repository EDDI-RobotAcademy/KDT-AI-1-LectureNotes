import React, { useEffect, useRef } from 'react'

import { useParams } from 'react-router-dom'

const VuetifyTypeScriptBoardAppReadRouter = () => {
  const { boardId } = useParams()
  const vuetifyBoardReadRef = useRef(null)

  useEffect(() => {
    const loadRemoteComponent = async () => {
      const { readBootstrapMount } = await import('vuetifyTailwindBoardApp/boardReadBootstrap')
      readBootstrapMount(vuetifyBoardReadRef.current, boardId)
    }

    loadRemoteComponent()
  }, [vuetifyBoardReadRef, boardId])

  return (
    <div>
      <div>
        <div style={{ position: 'relative' }} ref={vuetifyBoardReadRef}/>
      </div>
    </div>
  )
}

export default VuetifyTypeScriptBoardAppReadRouter
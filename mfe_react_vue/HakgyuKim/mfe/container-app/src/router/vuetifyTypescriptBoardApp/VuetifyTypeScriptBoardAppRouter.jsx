import React, { useEffect } from 'react'

const VuetifyTypeScriptBoardAppRouter = ({vuetifyTailwindBoardRef, naviHeight}) => {

  useEffect(() => {
    const loadRemoteComponent = async () => {
        const { vuetifyTailwindBoardAppMount } = await import('vuetifyTailwindBoardApp/vuetifyBoardBootstrap')
        vuetifyTailwindBoardAppMount(vuetifyTailwindBoardRef.current)
    }

    loadRemoteComponent()
  }, [vuetifyTailwindBoardRef])

  return (
    <div style={{position: 'relative'}}>
      <div>
        <div ref={vuetifyTailwindBoardRef}/>
      </div>
    </div>
  )
}

export default VuetifyTypeScriptBoardAppRouter
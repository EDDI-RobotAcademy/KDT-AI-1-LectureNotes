import React, { useEffect, useState } from 'react'

const VuetifyTailwindBoardAppRouterComponent = ({ vuetifyTailwindBoardRef, naviHeight }) => {
  useEffect(() => {
    const loadRemoteComponent = async () => {
      const { vuetifyTailwindBoardAppMount } = await import('vuetifyTailwindBoardApp/vuetifyBoardBootstrap')
      vuetifyTailwindBoardAppMount(vuetifyTailwindBoardRef.current)
    }

    loadRemoteComponent()
  }, [vuetifyTailwindBoardRef])

  return (
    <div>
      <div>
        <div ref={vuetifyTailwindBoardRef} />
      </div>
    </div>
  )
}

export default VuetifyTailwindBoardAppRouterComponent